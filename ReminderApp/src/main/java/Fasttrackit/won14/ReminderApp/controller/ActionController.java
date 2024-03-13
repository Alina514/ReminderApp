package Fasttrackit.won14.ReminderApp.controller;

import Fasttrackit.won14.ReminderApp.model.Action;
import Fasttrackit.won14.ReminderApp.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/actions")
@CrossOrigin(value = "http://localhost:4200")
public class ActionController {
    @Autowired
    private ActionService actionService;

    @GetMapping
    public List<Action> getAllAction() {
        return actionService.getAllAction();
    }

    @GetMapping("/{id}")
    public Action getActionById(@PathVariable Long id) {
        return actionService.getActionById(id);
    }

    @PostMapping
    public Action createAction(@RequestBody Action action) {
        return actionService.addNewAction(action);
    }

    @PutMapping("/{id}")
    public Action updateAction(@PathVariable Long id, @RequestBody Action action) {
        return actionService.replaceAction(id, action);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        actionService.deleteById(id);
    }
}
