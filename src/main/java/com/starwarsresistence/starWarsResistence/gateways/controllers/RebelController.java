package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.usecases.CreateRebel;
import com.starwarsresistence.starWarsResistence.usecases.ListRebels;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwarsresistence")
@AllArgsConstructor
public class RebelController {

    private CreateRebel createRebel;
    private ListRebels listRebels;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rebel save(@RequestBody Rebel rebel){
        return createRebel.execute(rebel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Rebel> list(){
        return listRebels.execute();
    }
}
