package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UpdateCoordinatesValidatorTest {

    @InjectMocks
    UpdateCoordinatesValidator updateCoordinatesValidator;

    @Test
    void shouldValidateCoordinates(){
        CoordinatesResponse coordinates = CoordinatesResponse.builder().build();

        List<String> fakeErrorList = List.of("ID não informado", "Latitude não informada", "Longitude não informada", "Nome da galáxia não informado");
        List<String> errorList = updateCoordinatesValidator.validate(coordinates);

        assertEquals(fakeErrorList, errorList);
    }
}
