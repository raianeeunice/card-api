package com.amefastforwad.cardapi.repository.impl;

import com.amefastforwad.cardapi.exception.InvalidEntityException;
import com.amefastforwad.cardapi.model.Origin;
import com.amefastforwad.cardapi.repository.OriginRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OriginRepositoryImpl implements OriginRepository {
    private final List<Origin> origins;

    public OriginRepositoryImpl() {
        origins = new ArrayList<>();

        var origin = new Origin();
        origin.setOrigin_id(1);
        origin.setName("Stan Lee");
        origin.setDescription("Criador de HQ");
        origin.setCreator("Stan Lee");
        origin.setCreatedAt(LocalDateTime.now());
        origin.setUpdatedAt(LocalDateTime.now());

        origins.add(origin);
    }

    @Override
    public Optional<Origin> findById(int id) {
        return origins.stream().filter(card -> card.getOrigin_id() == id).findFirst();
    }

    @Override
    public Origin save(Origin origin) {
        var originFound = origins.stream()
                .filter(originInList -> originInList.getName().equals(origin.getName()))
                .findFirst();

        if (originFound.isPresent()) {
            throw new InvalidEntityException("Nome [" + origin.getName() + "] ");
        }

        origin.setOrigin_id(origins.size() + 1);
        origins.add(origin);
        return origin;
    }
}
