package task_3_rest.trello.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_3_rest.trello.entities.Card;
import task_3_rest.trello.entities.CardTask;
import task_3_rest.trello.repositories.TaskRepository;
import task_3_rest.trello.services.TaskService;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<CardTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public CardTask addTask(CardTask task) {
        return taskRepository.save(task);
    }

    @Override
    public CardTask getTaskById(Long id){
        Optional<CardTask> card =taskRepository.findById(id);
        return card.orElse(null);
    }

    @Override
    public void deleteTask(CardTask task) {
        taskRepository.delete(task);
    }

    @Override
    public CardTask updateTask(CardTask task) {
        return taskRepository.save(task);
    }

    @Override
    public List<CardTask> findAllByCard_Id(Long id) {
        return taskRepository.findAllByCard_Id(id);
    }
}
