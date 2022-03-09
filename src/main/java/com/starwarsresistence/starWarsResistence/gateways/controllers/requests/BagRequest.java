package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class BagRequest {

    @ApiModelProperty(required = true, value="Weapon amount", example = "10")
    private int weapons;

    @ApiModelProperty(required = true, value="Weapon amount", example = "10")
    private int ammunition;

    @ApiModelProperty(required = true, value="Weapon amount", example = "10")
    private int water;

    @ApiModelProperty(required = true, value="Weapon amount", example = "10")
    private int food;
}
