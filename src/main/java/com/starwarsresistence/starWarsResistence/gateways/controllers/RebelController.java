package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.usecases.CreateRebel;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/starwarsresistence")
@AllArgsConstructor
public class RebelController {

    private CreateRebel createRebel;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rebel save(@RequestBody Rebel rebel){
        return createRebel.execute(rebel);
    }
}
