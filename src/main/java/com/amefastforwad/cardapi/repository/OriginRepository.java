package com.amefastforwad.cardapi.repository;

import com.amefastforwad.cardapi.model.Origin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginRepository {
    Optional<Origin> findById(int id);

    Origin save(Origin origin);
}
