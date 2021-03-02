package task_3_rest.trello.services;

import task_3_rest.trello.entities.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    Card addCard(Card card);
    Card getCardById(Long id);
    void deleteCard(Card card);
    Card updateCard(Card card);
    List<Card> findAllByNameContaining(String name);
}
