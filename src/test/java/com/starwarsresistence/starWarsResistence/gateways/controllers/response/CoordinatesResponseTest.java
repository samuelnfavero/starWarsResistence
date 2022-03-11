package com.starwarsresistence.starWarsResistence.gateways.controllers.response;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CoordinatesResponseTest {

    @InjectMocks
    CoordinatesResponse coordinatesResponse;

    @Test
    void shouldConvertCoordinateResponseToModel(){
        Coordinates fakeCoordinates = Coordinates.builder().build();
        Coordinates coordinates = coordinatesResponse.toModel();
        assertEquals(fakeCoordinates.getClass(), coordinates.getClass());
    }
}
