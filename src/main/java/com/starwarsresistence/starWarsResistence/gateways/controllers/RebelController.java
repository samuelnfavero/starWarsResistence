package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.usecases.*;
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
    private ReportRebel reportRebel;
    private TradeRebelItems tradeRebelItems;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RebelResponse save(@RequestBody RebelRequest rebelRequest){
        return createRebel.execute(rebelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<RebelResponse> list(){
        return listRebels.execute();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCoordinates(@RequestBody CoordinatesResponse coordinatesResponse){
        updateCoordinates.execute(coordinatesResponse);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void reportRebel(@PathVariable("id") Long id){
        reportRebel.execute(id);
    }

    @PutMapping("/trade")
    public void tradeRebelItems(@RequestBody Trade trade) {
        tradeRebelItems.execute(trade);
    }

}
