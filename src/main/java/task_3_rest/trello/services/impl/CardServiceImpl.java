package task_3_rest.trello.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_3_rest.trello.entities.Card;
import task_3_rest.trello.repositories.CardRepository;
import task_3_rest.trello.services.CardService;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card getCardById(Long id) {
        Optional<Card> card =cardRepository.findById(id);
        return card.orElse(null);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> findAllByNameContaining(String name) {
        return cardRepository.findAllByNameContaining(name);
    }
}
