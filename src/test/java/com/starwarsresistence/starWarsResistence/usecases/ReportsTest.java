package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.gateways.persistence.ReportsGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportsTest {

    @Mock
    ReportsGateway reportsGateway;
    @InjectMocks
    Reports reports;

    @Test
    void shouldReturnAMessageWithTraitorPercentage(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reportsGateway.traitorPercentageReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reports.traitorPercentageReport();

        verify(reportsGateway, times(1)).traitorPercentageReport();

    }

    @Test
    void shouldReturnAMessageWithItemsAverage(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reportsGateway.itemsAverageReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reports.itemsAverageReport();

        verify(reportsGateway, times(1)).itemsAverageReport();

    }

    @Test
    void shouldReturnAMessageWithLostPoints(){
        MessageResponseDTO reportMessage = MessageResponseDTO.builder().build();

        when(reportsGateway.lostPointsReport()).thenReturn(reportMessage);

        MessageResponseDTO responseMessage = reports.lostPointsReport();

        verify(reportsGateway, times(1)).lostPointsReport();

    }
}
