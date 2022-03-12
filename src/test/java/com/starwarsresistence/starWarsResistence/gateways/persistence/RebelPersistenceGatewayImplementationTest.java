package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.BagRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.BagResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.RebelPersistenceGatewayImplementation;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.repository.DataBasePersistenceRepository;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.validators.TradeValidator;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RebelPersistenceGatewayImplementationTest {
//
//    @Mock
//    Rebel rebel;
//    @Mock
//    RebelRequest rebelRequest;
//    @Mock
//    RebelResponse rebelResponse;
    @Mock
    DataBasePersistenceRepository persistenceRepository;
    @Mock
    TradeValidator tradeValidator;
    @InjectMocks
    RebelPersistenceGatewayImplementation rebelPersistenceGateway;


    @Test
    void shouldSaveARebel(){
        RebelRequest fakeRebelRequest = FakeRebel.createFakeRebelRequest();

        Rebel rebel = FakeRebel.createFakeRebel();


        when(persistenceRepository.save(any(Rebel.class))).thenReturn(rebel);
        RebelResponse savedRebel = rebelPersistenceGateway.save(fakeRebelRequest);

        assertNotNull(savedRebel);
        assertNotNull(savedRebel.getId());
        assertEquals(fakeRebelRequest.getName(),rebel.getName());

    }
}
