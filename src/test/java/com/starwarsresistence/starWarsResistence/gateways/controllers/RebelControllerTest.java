package com.starwarsresistence.starWarsResistence.gateways.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.testModels.FakeCoordinates;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import com.starwarsresistence.starWarsResistence.testModels.FakeTrade;
import com.starwarsresistence.starWarsResistence.usecases.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class RebelControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    private CreateRebel createRebel;
    @MockBean
    private ListRebels listRebels;
    @MockBean
    private UpdateCoordinates updateCoordinates;
    @MockBean
    private ReportRebel reportRebel;
    @MockBean
    private TradeRebelItems tradeRebelItems;
    @InjectMocks
    RebelController rebelController;

    //INTEGRAÇÃO
    @Test
    public void shouldCreateANewRebel() throws Exception {
        RebelRequest fakeRebelRequest = FakeRebel.createFakeRebelRequest();
        RebelResponse fakeRebelResponse = FakeRebel.createFakeRebelResponse();

        String jsonRequest = mapper.writeValueAsString(fakeRebelRequest);

        when(createRebel.execute(fakeRebelRequest)).thenReturn(fakeRebelResponse);

        mvc.perform(
                post("/starwarsresistence")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)
        )
                .andExpect(status().isCreated());

        ArgumentCaptor<RebelRequest> captor = ArgumentCaptor.forClass(RebelRequest.class);

        verify(createRebel).execute(captor.capture());
        RebelRequest rebelCaptor = captor.getValue();


        assertEquals(fakeRebelResponse.getName(), rebelCaptor.getName());
        assertEquals(fakeRebelResponse.getAge(), rebelCaptor.getAge());
        assertEquals(fakeRebelResponse.getGenre(), rebelCaptor.getGenre());
        assertEquals(fakeRebelResponse.getBag().getWeapons(), rebelCaptor.getBag().getWeapons());
        assertEquals(fakeRebelResponse.getBag().getAmmunition(), rebelCaptor.getBag().getAmmunition());
        assertEquals(fakeRebelResponse.getBag().getWater(), rebelCaptor.getBag().getWater());
        assertEquals(fakeRebelResponse.getBag().getFood(), rebelCaptor.getBag().getFood());
    }

    @Test
    public void shouldFindAllRebelsWhenReceiveAHttpRequest() throws Exception {
        RebelResponse fakeRebelResponse = FakeRebel.createFakeRebelResponse();
        List<RebelResponse> allRebels = List.of(fakeRebelResponse);

        when(listRebels.execute()).thenReturn(allRebels);
        mvc.perform(
                get("/starwarsresistence")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].name", Matchers.is(fakeRebelResponse.getName())))
                .andExpect(jsonPath("$[0].age", Matchers.is(fakeRebelResponse.getAge())))
                .andExpect(jsonPath("$[0].genre", Matchers.is(fakeRebelResponse.getGenre())))
                .andExpect(jsonPath("$[0].reports", Matchers.is(fakeRebelResponse.getReports())))
                .andExpect(jsonPath("$[0].bag.weapons", Matchers.is(fakeRebelResponse.getBag().getWeapons())))
                .andExpect(jsonPath("$[0].bag.ammunition", Matchers.is(fakeRebelResponse.getBag().getAmmunition())))
                .andExpect(jsonPath("$[0].bag.water", Matchers.is(fakeRebelResponse.getBag().getWater())))
                .andExpect(jsonPath("$[0].bag.food", Matchers.is(fakeRebelResponse.getBag().getFood())));
    }

    @Test
    public void shouldUpdateCoordinatesWhenReceiveAHttpRequest() throws Exception {
        CoordinatesResponse fakeCoordinates = FakeCoordinates.createFakeCoordinatesResponse();
        String jsonCoordinates = mapper.writeValueAsString(fakeCoordinates);
        mvc.perform(
                put("/starwarsresistence")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCoordinates)
        )
                .andExpect(status().isOk());

        ArgumentCaptor<CoordinatesResponse> captor = ArgumentCaptor.forClass(CoordinatesResponse.class);
        verify(updateCoordinates).execute(captor.capture());
        CoordinatesResponse coordinatesCaptor = captor.getValue();

        assertEquals(fakeCoordinates.getLatitude(), coordinatesCaptor.getLatitude());
        assertEquals(fakeCoordinates.getLongitude(), coordinatesCaptor.getLongitude());
        assertEquals(fakeCoordinates.getGalaxyName(), coordinatesCaptor.getGalaxyName());
    }

    @Test
    public void shouldReportARebelWhenReceiveAHttpRequest() throws Exception {
        Long id = 1L;
        mvc.perform(
                put("/starwarsresistence/" + id)
        )
                .andExpect(status().isOk());

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(reportRebel).execute(captor.capture());
        Long captorId = captor.getValue();

        assertEquals(id, captorId);
    }

    @Test
    public void shouldTradeItemsWhenReceiveAHttpRequest() throws Exception {
        Trade fakeTrade = FakeTrade.createFakeTrade();
        String jsonFakeTrade = mapper.writeValueAsString(fakeTrade);

        mvc.perform(
                put("/starwarsresistence/trade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonFakeTrade)
        )
                .andExpect(status().isOk());

        ArgumentCaptor<Trade> captor = ArgumentCaptor.forClass(Trade.class);
        verify(tradeRebelItems).execute(captor.capture());
        Trade tradeCaptor = captor.getValue();

        assertEquals(fakeTrade.getRebelTradeData1().getRebelTradeBag().get(0).getItem(),tradeCaptor.getRebelTradeData1().getRebelTradeBag().get(0).getItem());
        assertEquals(fakeTrade.getRebelTradeData1().getRebelTradeBag().get(0).getAmount(),tradeCaptor.getRebelTradeData1().getRebelTradeBag().get(0).getAmount());
        assertEquals(fakeTrade.getRebelTradeData1().getRebelId(), tradeCaptor.getRebelTradeData1().getRebelId());
    }

    //UNITÁRIOS
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

    @Test
    void shouldReportARebel(){
        Long id = null;
        doNothing().when(reportRebel).execute(id);
        rebelController.reportRebel(id);
        verify(reportRebel,times(1)).execute(id);
    }



}
