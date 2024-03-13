package Fasttrackit.won14.ReminderApp.service;

import Fasttrackit.won14.ReminderApp.exception.ResourceNotFoundException;
import Fasttrackit.won14.ReminderApp.model.Event;
import Fasttrackit.won14.ReminderApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id:%s was not found".formatted(id)));
        return event;
    }

    public Event addNewEvent(Event NewEvent) {
        return eventRepository.save(NewEvent);
    }

    public Event replaceEvent(Long id, Event replaceEvent) {
        Event foundEvent = getEventById(id);
        Event updatedEvent = Event.builder()
                .id(foundEvent.getId())
                .eventName(replaceEvent.getEventName())
                .eventDateTime(replaceEvent.getEventDateTime())
                .build();
        return eventRepository.save(updatedEvent);
    }

    public void deleteById(Long id) {
        Event foundEvent = getEventById(id);
        eventRepository.deleteById(id);
    }
}

