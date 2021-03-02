package task_3_rest.trello.services;

import task_3_rest.trello.entities.CardTask;

import java.util.List;

public interface TaskService {
    List<CardTask> getAllTasks();
    CardTask addTask(CardTask task);
    CardTask getTaskById(Long id);
    void deleteTask(CardTask task);
    CardTask updateTask(CardTask task);
    List<CardTask> findAllByCard_Id(Long id);
}
