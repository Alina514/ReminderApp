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
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String personName;
    @Column
    private LocalDate birthDate;

    public Birthday(Long id, String personName, LocalDate birthDate) {
        this.id = id;
        this.personName = personName;
        this.birthDate = birthDate;
    }
}
