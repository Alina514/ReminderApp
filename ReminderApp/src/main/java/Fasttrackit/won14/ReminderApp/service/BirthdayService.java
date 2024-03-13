package Fasttrackit.won14.ReminderApp.service;

import Fasttrackit.won14.ReminderApp.exception.ResourceNotFoundException;
import Fasttrackit.won14.ReminderApp.model.Birthday;
import Fasttrackit.won14.ReminderApp.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthdayService {
    @Autowired
    private BirthdayRepository birthdayRepository;

    public List<Birthday> getAllBirthday() {
        return birthdayRepository.findAll();
    }

    public Birthday getBirthdayById(Long id) {
        Birthday birthday = birthdayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("action with id:%s was not found".formatted(id)));
        return birthday;
    }

    public Birthday addNewBirthday(Birthday NewBirthday) {
        return birthdayRepository.save(NewBirthday);
    }

    public Birthday replaceBirthday(Long id, Birthday replaceBirthday) {
        Birthday foundBirthday = getBirthdayById(id);
        Birthday updatedBirthday = Birthday.builder()
                .id(foundBirthday.getId())
                .personName(replaceBirthday.getPersonName())
                .birthDate(replaceBirthday.getBirthDate())
                .build();
        return birthdayRepository.save(updatedBirthday);
    }

    public void deleteById(Long id) {
        Birthday foundBirthday = getBirthdayById(id);
        birthdayRepository.deleteById(id);
    }
}