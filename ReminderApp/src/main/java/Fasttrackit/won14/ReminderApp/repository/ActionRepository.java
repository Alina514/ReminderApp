package Fasttrackit.won14.ReminderApp.repository;

import Fasttrackit.won14.ReminderApp.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
