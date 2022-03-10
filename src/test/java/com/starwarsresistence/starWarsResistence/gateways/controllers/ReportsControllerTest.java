package com.starwarsresistence.starWarsResistence.gateways.controllers;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.usecases.Reports;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportsControllerTest {

    @Mock
    Reports reports;
    @InjectMocks
    ReportsController reportsController;

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
