package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.domains.Rebel;

public interface RebelPersistenceGateway {
    Rebel save(Rebel rebel);
}
