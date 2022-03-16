package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import com.starwarsresistence.starWarsResistence.usecases.Reports;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class ReportsControllerTest {


    @Autowired
    MockMvc mvc;
    @Mock
    Reports reports;
    @InjectMocks
    ReportsController reportsController;

    //INTEGRAÇÃO

    @Test
    public void shouldReturnThePercentageReportWhenReceiveAHttpRequest() throws Exception {

        MessageResponseDTO fakeMessage = MessageResponseDTO.builder().message("Porcentagem de Traidores: NaN%. Porcentagem de rebeldes: NaN%.").build();


        mvc.perform(
                get("/starwarsresistence/reports/traitorpercentagereport")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is(fakeMessage.getMessage())));
    }

    @Test
    public void shouldReturnTheAverageReportWhenReceiveAHttpRequest() throws Exception {

        MessageResponseDTO fakeMessage = MessageResponseDTO.builder().message("Média de armas por rebelde NaN. Média de munição por rebelde NaN. Média de água por rebelde NaN. Média de comida por rebelde NaN").build();


        mvc.perform(
                        get("/starwarsresistence/reports/itemsaveragereport")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is(fakeMessage.getMessage())));
    }

    @Test
    public void shouldReturnTheLostPointsReportWhenReceiveAHttpRequest() throws Exception {

        MessageResponseDTO fakeMessage = MessageResponseDTO.builder().message("Pontos perdidos devido a traidores: 0").build();


        mvc.perform(
                        get("/starwarsresistence/reports/lostpointsreport")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is(fakeMessage.getMessage())));
    }

    //UNITÁRIOS
    @Test
    void shouldReturnAMessageWithTraitorPercentage(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reports.traitorPercentageReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reportsController.traitorPercentageReport();

        verify(reports, times(1)).traitorPercentageReport();

    }

    @Test
    void shouldReturnAMessageWithItemsAverage(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reports.itemsAverageReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reportsController.itemsAverageReport();

        verify(reports, times(1)).itemsAverageReport();

    }

    @Test
    void shouldReturnAMessageWithLostPoints(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reports.lostPointsReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reportsController.lostPointsReport();

        verify(reports, times(1)).lostPointsReport();

    }
}
