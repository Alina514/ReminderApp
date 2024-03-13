package Fasttrackit.won14.ReminderApp.repository;

import Fasttrackit.won14.ReminderApp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
