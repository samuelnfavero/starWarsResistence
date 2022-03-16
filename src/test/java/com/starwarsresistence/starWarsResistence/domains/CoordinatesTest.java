package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.testModels.FakeCoordinates;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CoordinatesTest {

    @InjectMocks
    Coordinates coordinates;

    @Test
    void shouldSetLatitude(){
        Coordinates fakeCoordinates = FakeRebel.createFakeRebel().getCoordinates();
        coordinates.setLatitude("10");

        assertEquals(fakeCoordinates.getLatitude(), coordinates.getLatitude());
    }

    @Test
    void shouldSetLongitude(){
        Coordinates fakeCoordinates = FakeRebel.createFakeRebel().getCoordinates();
        coordinates.setLongitude("10");

        assertEquals(fakeCoordinates.getLongitude(), coordinates.getLongitude());
    }

    @Test
    void shouldSetGalaxyName(){
        Coordinates fakeCoordinates = FakeRebel.createFakeRebel().getCoordinates();
        coordinates.setGalaxyName("Via Láctea");

        assertEquals(fakeCoordinates.getGalaxyName(), coordinates.getGalaxyName());
    }
}
