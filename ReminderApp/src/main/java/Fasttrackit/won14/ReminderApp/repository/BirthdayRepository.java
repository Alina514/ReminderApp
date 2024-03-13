package Fasttrackit.won14.ReminderApp.repository;

import Fasttrackit.won14.ReminderApp.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {
}
