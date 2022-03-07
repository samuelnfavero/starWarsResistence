package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.repository.DataBasePersistenceRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RebelPersistenceGatewayImplementation implements RebelPersistenceGateway {

    DataBasePersistenceRepository persistenceRepository;

    @Override
    public Rebel save(Rebel rebel) {

        persistenceRepository.save(rebel);
        return rebel;
    }
}