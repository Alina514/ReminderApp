package Fasttrackit.won14.ReminderApp;

import Fasttrackit.won14.ReminderApp.model.Action;
import Fasttrackit.won14.ReminderApp.model.Birthday;
import Fasttrackit.won14.ReminderApp.model.Event;
import Fasttrackit.won14.ReminderApp.repository.ActionRepository;
import Fasttrackit.won14.ReminderApp.repository.BirthdayRepository;
import Fasttrackit.won14.ReminderApp.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class CommandRunner implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final ActionRepository actionRepository;
    private final BirthdayRepository birthdayRepository;

    public CommandRunner(EventRepository eventRepository, ActionRepository actionRepository, BirthdayRepository birthdayRepository) {
        this.eventRepository = eventRepository;
        this.actionRepository = actionRepository;
        this.birthdayRepository = birthdayRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Action action1 = Action.builder().actionName("Complete report").build();
        Action action2 = Action.builder().actionName("Send email").build();

        actionRepository.saveAll(Arrays.asList(action1, action2));

        Birthday birthday1 = Birthday.builder().personName("Mihai").birthDate(LocalDate.of(1990, 5, 15)).build();
        Birthday birthday2 = Birthday.builder().personName("Andrei").birthDate(LocalDate.of(1985, 10, 20)).build();

        birthdayRepository.saveAll(Arrays.asList(birthday1, birthday2));

        Event event1 = Event.builder().eventName("Meeting").eventDateTime(LocalDateTime.now()).build();
        Event event2 = Event.builder().eventName("Conference").eventDateTime(LocalDateTime.now().plusDays(1)).build();

        eventRepository.saveAll(Arrays.asList(event1, event2));
    }
}