package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.usecases.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RebelControllerTest {

    @Mock
    private CreateRebel createRebel;
    @Mock
    private ListRebels listRebels;
    @Mock
    private UpdateCoordinates updateCoordinates;
    @Mock
    private ReportRebel reportRebel;
    @Mock
    private TradeRebelItems tradeRebelItems;
    @InjectMocks
    RebelController rebelController;

    @Test
    void shouldCreateARebel(){
        RebelRequest rebelRequest = RebelRequest.builder().build();
        RebelResponse rebelResponse = RebelResponse.builder().build();

        when(createRebel.execute(rebelRequest)).thenReturn(rebelResponse);

        RebelResponse savedRebel = rebelController.save(rebelRequest);

        assertEquals(rebelResponse, savedRebel);

        verify(createRebel, times(1)).execute(rebelRequest);
    }

    @Test
    void shouldListAllRebels(){
        List<RebelResponse> emptyListOfAllRebels = new ArrayList<>();

        when(rebelController.list()).thenReturn(emptyListOfAllRebels);

        List<RebelResponse> allRebels = rebelController.list();

        assertEquals(emptyListOfAllRebels, allRebels);

        verify(listRebels, times(1)).execute();
    }

    @Test
    void shouldUpdateCoordinates(){
        CoordinatesResponse coordinatesResponse = CoordinatesResponse.builder().build();

        doNothing().when(updateCoordinates).execute(coordinatesResponse);

        rebelController.updateCoordinates(coordinatesResponse);

        verify(updateCoordinates,times(1)).execute(coordinatesResponse);
    }

    @Test
    void shouldMakeATrade(){
        Trade trade = Trade.builder().build();

        doNothing().when(tradeRebelItems).execute(trade);

        rebelController.tradeRebelItems(trade);

        verify(tradeRebelItems, times(1)).execute(trade);
    }


}
