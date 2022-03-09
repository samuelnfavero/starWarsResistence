package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;

import java.util.List;

public interface RebelPersistenceGateway {
    RebelResponse save(RebelRequest rebel);

    List<Rebel> findAll();

    Rebel findById(Long id);

    void updateCoordinates(Coordinates coordinates);

    void reportRebel(Long id);

    void trade(Trade trade);

}
