package com.amefastforwad.cardapi.repository;

import com.amefastforwad.cardapi.model.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(int id);

    Card save(Card card);
}
