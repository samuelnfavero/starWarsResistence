package com.starwarsresistence.starWarsResistence.usecases;


import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.UpdateCoordinatesValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateCoordinatesTest {

    @Mock
    private UpdateCoordinatesValidator updateCoordinatesValidator;
    @Mock
    private RebelPersistenceGateway rebelPersistenceGateway;
    @InjectMocks
    private UpdateCoordinates updateCoordinates;


    @Test
    void shouldThrowAnExceptionWhenValidationFailed(){
        CoordinatesResponse coordinates = CoordinatesResponse.builder().build();
        when(updateCoordinatesValidator.validate(coordinates)).thenReturn(List.of("Some validation didn't pass"));

        BusinessValidationException exception = Assertions.assertThrows(BusinessValidationException.class, ()-> updateCoordinates.execute(coordinates));

        Assertions.assertEquals("Some validation didn't pass", exception.getMessage());

        verify(updateCoordinatesValidator, times(1)).validate(coordinates);
        verify(rebelPersistenceGateway,times(0)).updateCoordinates(coordinates);
    }

    @Test
    void shouldUpdateWhenExceptionValidationSuceed(){
        CoordinatesResponse coordinates = CoordinatesResponse.builder().build();

        when(updateCoordinatesValidator.validate(coordinates)).thenReturn(List.of());
        doNothing().when(rebelPersistenceGateway).updateCoordinates(coordinates);

        updateCoordinates.execute(coordinates);
        Assertions.assertDoesNotThrow(()->BusinessValidationException.class);

        verify(rebelPersistenceGateway, times(1)).updateCoordinates(coordinates);


    }
}
