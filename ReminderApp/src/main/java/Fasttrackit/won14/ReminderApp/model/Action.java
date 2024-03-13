package Fasttrackit.won14.ReminderApp.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String actionName;

    public Action(Long id, String actionName) {
        this.id = id;
        this.actionName = actionName;
    }

    public String getName() {
        return actionName;
    }

    public LocalDate getBirthDate() {
        return getBirthDate();
    }
}
