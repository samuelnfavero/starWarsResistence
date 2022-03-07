package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.usecases.CreateRebel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("starwarsresistence")
public class RebelController {

    private CreateRebel createRebel;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rebel save(Rebel rebel){
        return createRebel.execute(rebel);
    }
}
