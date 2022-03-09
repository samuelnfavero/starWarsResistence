package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListRebels {

    RebelPersistenceGateway rebelPersistenceGateway;

    public List<RebelResponse> execute(){
        return rebelPersistenceGateway.findAll();
    }
}
