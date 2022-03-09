package com.starwarsresistence.starWarsResistence.gateways.controllers.responses;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Builder
public class CoordinatesResponse {

    private Long id;

    private String latitude;

    private String longitude;

    private String galaxyName;

    public CoordinatesResponse(Coordinates coordinates) {
        this.id = coordinates.getId();
        this.latitude = coordinates.getLatitude();
        this.longitude = coordinates.getLongitude();
        this.galaxyName = coordinates.getGalaxyName();
    }
}
