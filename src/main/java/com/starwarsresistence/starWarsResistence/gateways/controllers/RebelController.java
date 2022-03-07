package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.usecases.CreateRebel;
import com.starwarsresistence.starWarsResistence.usecases.ListRebels;
import com.starwarsresistence.starWarsResistence.usecases.UpdateCoordinates;
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
    private UpdateCoordinates updateCoordinates;

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

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCoordinates(@RequestBody Coordinates coordinates){
        updateCoordinates.execute(coordinates);
    }
}
