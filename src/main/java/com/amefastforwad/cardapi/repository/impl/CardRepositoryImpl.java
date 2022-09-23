package com.amefastforwad.cardapi.repository.impl;

import com.amefastforwad.cardapi.exception.InvalidEntityException;
import com.amefastforwad.cardapi.model.Card;
import com.amefastforwad.cardapi.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryImpl() {
        cards = new ArrayList<>();

        var card = new Card();
        card.setCard_id(1);
        card.setName("Iron Man");
        card.setDescription("Tony Stark");
        card.setStrength(5);
        card.setSpeed(5);
        card.setSkill(7);
        card.setGear(6);
        card.setIntellect(7);
        card.setImageUrl("url_image_iron_man");
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        cards.add(card);
    }

    @Override
    public Optional<Card> findById(int id) {
        return cards.stream().filter(card -> card.getCard_id() == id).findFirst();
    }

    @Override
    public Card save(Card card) {
        var cardFound = cards.stream()
                .filter(cardInList -> cardInList.getName().equals(card.getName()))
                .findFirst();

        if (cardFound.isPresent()) {
            throw new InvalidEntityException("Nome [" + card.getName() + "] ");
        }

        card.setCard_id(cards.size() + 1);
        cards.add(card);
        return card;
    }
}
