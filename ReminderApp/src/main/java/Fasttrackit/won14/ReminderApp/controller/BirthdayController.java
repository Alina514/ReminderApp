package Fasttrackit.won14.ReminderApp.controller;

import Fasttrackit.won14.ReminderApp.model.Birthday;
import Fasttrackit.won14.ReminderApp.service.BirthdayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/birthdays")
@CrossOrigin(value = "http://localhost:4200")
public class BirthdayController {
    @Autowired
    private BirthdayService birthdayService;

    @GetMapping()
    public List<Birthday> getAllBirthday() {
        return birthdayService.getAllBirthday();
    }

    @GetMapping("/{id}")
    public Birthday getBirthdayById(@PathVariable Long id) {
        return birthdayService.getBirthdayById(id);
    }

    @PostMapping
    public Birthday createBirthday(@RequestBody Birthday birthday) {
        return birthdayService.addNewBirthday(birthday);
    }

    @PutMapping("/{id}")
    public Birthday updateBirthday(@PathVariable Long id, @RequestBody Birthday birthday) {
        return birthdayService.replaceBirthday(id, birthday);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        birthdayService.deleteById(id);
    }

}





