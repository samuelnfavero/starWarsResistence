package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.BagRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.BagResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListRebelsTest {

    @Mock
    RebelPersistenceGateway rebelPersistenceGateway;
    @InjectMocks
    ListRebels listRebels;

    @Test
    void shouldReturnAnEmptyListWhenFindAllRebels(){
        List<RebelResponse> allRebels = new ArrayList<>();


        List<RebelResponse> generatedList = listRebels.execute();

        Assertions.assertEquals(allRebels, generatedList);

        verify(rebelPersistenceGateway, times(1)).findAll();

    }

    @Test
    void shouldReturnAListWithAllRebelsWhenFindAllRebels(){
        RebelResponse rebelResponse = RebelResponse.builder()
                .id(1L).name("Samuel")
                .age("25")
                .genre("Masc")
                .isATraitor(false)
                .reports(0)
                .bag(BagResponse.builder().id(1L).weapons(1).ammunition(1).water(1).food(1).build())
                .coordinates(CoordinatesResponse.builder().id(1L).latitude("1").longitude("1").galaxyName("Andromeda").build()).build();

        List<RebelResponse> fakeAllRebels = new ArrayList<>();
        fakeAllRebels.add(rebelResponse);
        fakeAllRebels.add(rebelResponse);
        fakeAllRebels.add(rebelResponse);


        when(rebelPersistenceGateway.findAll()).thenReturn(List.of(rebelResponse,rebelResponse,rebelResponse));


        List<RebelResponse> allRebels = rebelPersistenceGateway.findAll();

        Assertions.assertEquals(fakeAllRebels, allRebels);
        verify(rebelPersistenceGateway, times(1)).findAll();
    }
}
