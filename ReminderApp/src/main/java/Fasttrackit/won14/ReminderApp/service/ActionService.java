package Fasttrackit.won14.ReminderApp.service;

import Fasttrackit.won14.ReminderApp.exception.ResourceNotFoundException;
import Fasttrackit.won14.ReminderApp.model.Action;
import Fasttrackit.won14.ReminderApp.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionService {

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> getAllAction() {
        return actionRepository.findAll();
    }

    public Action getActionById(Long id) {
       Action action = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("action with id:%s was not found".formatted(id)));
        return action;
    }

    public Action addNewAction(Action NewAction) {
        return actionRepository.save(NewAction);
    }

    public Action replaceAction(Long id, Action replaceAction) {
        Action foundAction = getActionById(id);
        Action updatedAction = Action.builder()
                .id(foundAction.getId())
                .actionName(replaceAction.getName())
                .build();
        return actionRepository.save(updatedAction);
    }

    public void deleteById(Long id) {
        Action foundAction = getActionById(id);
       actionRepository.deleteById(id);
    }
}