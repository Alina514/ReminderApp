package Fasttrackit.won14.ReminderApp.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String eventName;
    @Column
    private LocalDateTime eventDateTime;

    public Event(Long id, String eventName, LocalDateTime eventDateTime) {
        this.id = id;
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
    }
}
