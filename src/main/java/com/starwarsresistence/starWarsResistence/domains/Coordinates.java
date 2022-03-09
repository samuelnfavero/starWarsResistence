package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private String galaxyName;

    public Coordinates(CoordinatesResponse coordinatesResponse){
        id = coordinatesResponse.getId();
        latitude = coordinatesResponse.getLatitude();
        longitude = coordinatesResponse.getLongitude();
        galaxyName = coordinatesResponse.getGalaxyName();
    }
}
