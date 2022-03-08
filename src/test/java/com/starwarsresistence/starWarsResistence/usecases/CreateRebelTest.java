package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
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
        Rebel rebel = Rebel.builder().build();
        Mockito.when(createRebelValidator.validate(rebel)).thenReturn(List.of());
        createRebel.execute(rebel);
        Mockito.verify(rebelPersistenceGateway).save(rebel);
    }

    @Test
    void shouldNotSaveWhenValidantionFailed() {
        Rebel rebel = Rebel.builder().build();
        Mockito.when(createRebelValidator.validate(rebel)).thenReturn(List.of("validation error"));
        Assertions.assertThrows(BusinessValidationException.class, () -> createRebel.execute(rebel));
    }
}