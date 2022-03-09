package com.starwarsresistence.starWarsResistence.gateways.controllers.responses;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Builder
@Getter
@Setter
public class RebelResponse {

    private Long id;

    private String name;

    private String age;

    private String genre;

    private int reports;

    private boolean isATraitor;

    private BagResponse bag;

    private CoordinatesResponse coordinates;

    public RebelResponse(Rebel rebel) {
        id = rebel.getId();
        name = rebel.getName();
        age = rebel.getAge();
        genre = rebel.getGenre();
        reports = rebel.getReports();
        isATraitor = rebel.isATraitor();
        bag = new BagResponse(rebel.getBag());
        coordinates = new CoordinatesResponse(rebel.getCoordinates());
    }
}
