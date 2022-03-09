package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor

@Setter
@Getter
@Builder
public class CoordinatesRequest {

    private Long id;

    @ApiModelProperty(required = true, value="Rebel's latitude", example = "455")
    private String latitude;

    @ApiModelProperty(required = true, value="Rebel's longitude", example = "359")
    private String longitude;

    @ApiModelProperty(required = true, value="Rebel's galaxy", example = "Via Láctea")
    private String galaxyName;


    public Coordinates toModel(){
        return Coordinates.builder()
                .id(id)
                .latitude(latitude)
                .longitude(longitude)
                .galaxyName(galaxyName)
                .build();
    }
}
