package com.starwarsresistence.starWarsResistence.testModels;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;

public class FakeCoordinates {

    public static CoordinatesResponse createFakeCoordinatesResponse(){
        return CoordinatesResponse.builder()
                .id(1L)
                .latitude("100")
                .longitude("100")
                .galaxyName("Via Lactea")
                .build();
    }

    public static CoordinatesResponse createFakeCoordinatesResponseWithoutId(){
        return CoordinatesResponse.builder()
                .latitude("100")
                .longitude("100")
                .galaxyName("Via Lactea")
                .build();
    }
}
