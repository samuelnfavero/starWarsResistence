package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.CreateRebelValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class CreateRebelTest {

    @InjectMocks CreateRebel createRebel;
    @Mock private CreateRebelValidator createRebelValidator;
    @Mock private RebelPersistenceGateway rebelPersistenceGateway;

    @Test
    void shouldSaveWhenValidantionSucceed() {
        RebelRequest rebelRequest = RebelRequest.builder().build();
        Mockito.when(createRebelValidator.validate(rebelRequest)).thenReturn(List.of());
        createRebel.execute(rebelRequest);
        Mockito.verify(rebelPersistenceGateway).save(rebelRequest);
    }

    @Test
    void shouldNotSaveWhenValidantionFailed() {
        RebelRequest rebel = RebelRequest.builder().build();
        Mockito.when(createRebelValidator.validate(rebel)).thenReturn(List.of("validation error"));
        Assertions.assertThrows(BusinessValidationException.class, () -> createRebel.execute(rebel));
    }
}