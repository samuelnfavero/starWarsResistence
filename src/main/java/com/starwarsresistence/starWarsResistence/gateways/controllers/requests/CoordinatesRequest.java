package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class CoordinatesRequest {

    private String latitude;

    private String longitude;

    private String galaxyName;
}
