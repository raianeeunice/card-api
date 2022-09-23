package com.amefastforwad.cardapi.controller;

import com.amefastforwad.cardapi.controller.request.CreateOriginRequest;
import com.amefastforwad.cardapi.model.Origin;
import com.amefastforwad.cardapi.service.OriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/origin")
public class OriginController {
    private static final Logger LOG = LoggerFactory.getLogger(OriginController.class);

    private final OriginService originService;

    @Autowired
    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/health")
    public String health() {
        LOG.info("Verificando API");
        return "OK";
    }

    @GetMapping("{id}")
    public Origin findCardById(@PathVariable("id") int id) {
        LOG.info("Iniciando busca pelo origin com id [{}]", id);
        var origin = originService.findById(id);

        if (origin.isPresent()) {
            return origin.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Origin não encontrado");
    }

    @PostMapping
    public Origin createOrigin(@RequestBody CreateOriginRequest createOriginRequest) {
        LOG.info("Iniciando criacao de Origin com nome [{}]", createOriginRequest.getName());
        return originService.createOrigin(createOriginRequest);
    }
}
