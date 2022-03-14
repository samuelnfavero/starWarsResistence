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
import com.starwarsresistence.starWarsResistence.testModels.FakeCoordinates;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RebelPersistenceGatewayImplementationTest {

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
        assertEquals(fakeRebelRequest.getAge(),  rebel.getAge());
        assertEquals(fakeRebelRequest.getGenre(), rebel.getGenre());
    }

    @Test
    void shouldFindAllRebels(){
        List<RebelResponse> fakeAllRebels = List.of();
        when(persistenceRepository.findAll()).thenReturn(List.of());

        List<RebelResponse> allRebels = rebelPersistenceGateway.findAll();

        assertEquals(fakeAllRebels, allRebels);
    }

    @Test
    void shouldFindARebelById(){
        Long id = 1L;
        Rebel fakeRebel = FakeRebel.createFakeRebel();
        Optional<Rebel> optionalFakeRebel = Optional.of(fakeRebel);
        when(persistenceRepository.findById(id)).thenReturn(optionalFakeRebel);

        Rebel rebel = rebelPersistenceGateway.findById(id);

        assertEquals(fakeRebel.getName(),rebel.getName());
        assertEquals(fakeRebel.getAge(),rebel.getAge());
        assertEquals(fakeRebel.getGenre(),rebel.getGenre());

        verify(persistenceRepository, timeout(1)).findById(id);

    }

    @Test
    void shouldUpdateCoordinates(){

        CoordinatesResponse fakeCoordinatesReponse = FakeCoordinates.createFakeCoordinatesResponse();
        Optional<Rebel> fakeRebel = Optional.of(FakeRebel.createFakeRebel());
        when(persistenceRepository.findById(fakeCoordinatesReponse.getId())).thenReturn(fakeRebel);
        rebelPersistenceGateway.updateCoordinates(fakeCoordinatesReponse);
        verify(persistenceRepository,times(1)).save(any(Rebel.class));

    }

    @Test
    void shouldReportARebel(){
        Long id = 1L;
        Optional<Rebel> rebel = Optional.of(FakeRebel.createFakeRebel());
        when(persistenceRepository.findById(id)).thenReturn(rebel);
        rebelPersistenceGateway.reportRebel(id);
        verify(persistenceRepository,times(1)).save(any(Rebel.class));
    }
}
