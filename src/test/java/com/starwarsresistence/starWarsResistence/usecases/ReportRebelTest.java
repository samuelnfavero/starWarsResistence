package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportRebelTest {

    @Mock
    private RebelPersistenceGateway rebelPersistenceGateway;

    @InjectMocks
    ReportRebel reportRebel;

    @Test
    void shouldThrowAnExceptionWhenIdIsNull(){
        Long id = null;

        BusinessValidationException exception = Assertions.assertThrows(BusinessValidationException.class,() -> reportRebel.execute(id));

        Assertions.assertEquals("É necessário ID do rebelde para reportar.", exception.getMessage());
        verify(rebelPersistenceGateway, times(0)).reportRebel(id);
    }

    @Test
    void shouldReportWhenIdIsNotNull(){
        Long id = 1L;

        doNothing().when(rebelPersistenceGateway).reportRebel(id);

        reportRebel.execute(id);
        Assertions.assertDoesNotThrow(()-> BusinessValidationException.class);

        verify(rebelPersistenceGateway, times(1)).reportRebel(id);
    }
}
