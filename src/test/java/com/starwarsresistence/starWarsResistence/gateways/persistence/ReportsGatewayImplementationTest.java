package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.ReportsGatewayImplementation;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.repository.DatabasePersistenceRepository;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportsGatewayImplementationTest {

    @Mock
    DatabasePersistenceRepository persistenceRepository;
    @InjectMocks
    ReportsGatewayImplementation reportsGatewayImplementation;

    @Test
    public void shouldReturnThePercentageReport(){
        Rebel rebel = FakeRebel.createFakeRebel();
        Rebel traitor = FakeRebel.createFakeRebel();
        traitor.setATraitor(true);
        List<Rebel> fakeAllRebels = List.of(rebel, rebel, rebel, rebel, traitor);
        MessageResponseDTO fakeMessage = new MessageResponseDTO("Porcentagem de Traidores: 20.0%. Porcentagem de rebeldes: 80.0%.");

        when(persistenceRepository.findAll()).thenReturn(fakeAllRebels);

        MessageResponseDTO message = reportsGatewayImplementation.traitorPercentageReport();

        assertEquals(fakeMessage.getMessage(), message.getMessage());

    }

    @Test
    public void shouldReturnTheAverageReport(){
        Rebel rebel = FakeRebel.createFakeRebel();
        List<Rebel> fakeAllRebels = List.of(rebel, rebel, rebel, rebel, rebel);
        MessageResponseDTO fakeMessage = new MessageResponseDTO("Média de armas por rebelde 5.0. Média de munição por rebelde 5.0." +
                " Média de água por rebelde 5.0." +
                " Média de comida por rebelde 5.0");
        when(persistenceRepository.findAll()).thenReturn(fakeAllRebels);

        MessageResponseDTO message = reportsGatewayImplementation.itemsAverageReport();
        assertEquals(fakeMessage.getMessage(), message.getMessage());
    }

    @Test
    public void shouldReturnTheLostPointsReport(){
        Rebel rebel = FakeRebel.createFakeRebel();
        Rebel traitor = FakeRebel.createFakeRebel();
        traitor.setATraitor(true);
        List<Rebel> fakeAllRebels = List.of(rebel, rebel, rebel, rebel, traitor);
        MessageResponseDTO fakeMessage = new MessageResponseDTO("Pontos perdidos devido a traidores: 50");
        when(persistenceRepository.findAll()).thenReturn(fakeAllRebels);

        MessageResponseDTO message = reportsGatewayImplementation.lostPointsReport();

        assertEquals(fakeMessage.getMessage(), message.getMessage());
    }
}
