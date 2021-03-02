package task_3_rest.trello.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task_3_rest.trello.entities.Card;

import java.util.List;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findAllByNameContaining(String name);
}
