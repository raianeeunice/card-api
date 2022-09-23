package com.amefastforwad.cardapi.service;

import com.amefastforwad.cardapi.controller.request.CreateOriginRequest;
import com.amefastforwad.cardapi.model.Origin;
import com.amefastforwad.cardapi.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OriginService {
    private final OriginRepository originRepository;

    @Autowired
    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    public Optional<Origin> findById(int id) {
        return originRepository.findById(id);
    }

    public Origin createOrigin(CreateOriginRequest originRequest) {
        var origin = new Origin();
        origin.setName(originRequest.getName());
        origin.setDescription(originRequest.getDescription());
        origin.setCreator(originRequest.getCreator());
        origin.setCreatedAt(LocalDateTime.now());
        origin.setUpdatedAt(LocalDateTime.now());

        return originRepository.save(origin);
    }
}
