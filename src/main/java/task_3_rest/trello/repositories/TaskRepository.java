package task_3_rest.trello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task_3_rest.trello.entities.CardTask;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<CardTask,Long> {
    List<CardTask> findAllByCard_Id(Long id);
}
