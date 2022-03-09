package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;

import java.util.List;

public interface RebelPersistenceGateway {
    RebelResponse save(RebelRequest rebel);

    List<RebelResponse> findAll();

    Rebel findById(Long id);

    void updateCoordinates(CoordinatesResponse coordinatesResponse);

    void reportRebel(Long id);

    void trade(Trade trade);

}
