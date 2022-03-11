package com.starwarsresistence.starWarsResistence.gateways.controllers.request;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.BagRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RebelRequestTest {

    @Mock
    BagRequest bagRequest;
    @Mock
    CoordinatesRequest coordinatesRequest;
    @InjectMocks
    RebelRequest rebelRequest;

    @Test
    void shouldConvertClassToModel(){
        Rebel fakeRebel = Rebel.builder().build();
        Rebel rebel = rebelRequest.toModel();
        assertEquals(fakeRebel.getClass(), rebel.getClass());
    }

}
