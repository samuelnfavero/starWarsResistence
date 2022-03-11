package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;


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


}
