package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateRebelValidatorTest {

    @InjectMocks
    CreateRebelValidator createRebelValidator;

    @Test
    void shouldValidateRebelRequest(){
        RebelRequest rebelRequest = RebelRequest.builder().build();
        List<String> fakeErrorList = List.of("Nome não informado", "Idade não informada", "Gênero não informado", "Itens não informados", "Coordenadas não informadas");
        List<String> errorList = createRebelValidator.validate(rebelRequest);

        assertEquals(fakeErrorList, errorList);
    }
}
