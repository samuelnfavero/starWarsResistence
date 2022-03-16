package com.starwarsresistence.starWarsResistence.testModels;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.BagRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.BagResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class FakeRebel {

    public static Rebel createFakeRebelWithoutId(){
        return Rebel.builder()
                .name("Jão")
                .age("33")
                .genre("Masc")
                .isATraitor(false)
                .reports(0)
                .bag(createFakeBag())
                .coordinates(createFakeCoordinates())
                .build();
    }

    public static Rebel createFakeRebel(){
        return Rebel.builder()
                .id(1L)
                .name("Jão")
                .age("33")
                .genre("Masc")
                .isATraitor(false)
                .reports(0)
                .bag(createFakeBag())
                .coordinates(createFakeCoordinates())
                .build();
    }
    private static Coordinates createFakeCoordinates(){
        return Coordinates.builder()
                .latitude("10")
                .longitude("10")
                .galaxyName("Via Láctea")
                .build();
    }
    private static Bag createFakeBag(){
        return Bag.builder()
                .weapons(5)
                .ammunition(5)
                .water(5)
                .food(5)
                .build();
    }

    public static RebelRequest createFakeRebelRequest(){
        return RebelRequest.builder()
                .name("Jão")
                .age("33")
                .genre("Masc")
                .bag(createFakeBagRequest())
                .coordinates(createFakeCoordinatesRequest())
                .build();
    }
    private static CoordinatesRequest createFakeCoordinatesRequest(){
        return CoordinatesRequest.builder()
                .latitude("10")
                .longitude("10")
                .galaxyName("Via Láctea")
                .build();
    }
    private static BagRequest createFakeBagRequest(){
        return BagRequest.builder()
                .weapons(5)
                .ammunition(5)
                .water(5)
                .food(5)
                .build();
    }

    public static RebelResponse createFakeRebelResponse(){
        return RebelResponse.builder()
                .id(1L)
                .name("Jão")
                .age("33")
                .genre("Masc")
                .reports(0)
                .isATraitor(false)
                .bag(createFakeBagResponse())
                .coordinates(createFakeCoordinatesResponse())
                .build();
    }
    private static CoordinatesResponse createFakeCoordinatesResponse(){
        return CoordinatesResponse.builder()
                .latitude("10")
                .longitude("10")
                .galaxyName("Via Láctea")
                .build();
    }
    private static BagResponse createFakeBagResponse(){
        return BagResponse.builder()
                .weapons(5)
                .ammunition(5)
                .water(5)
                .food(5)
                .build();
    }
}
