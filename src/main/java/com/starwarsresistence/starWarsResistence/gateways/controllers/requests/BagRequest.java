package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class BagRequest {

    private int weapons;

    private int ammunition;

    private int water;

    private int food;
}
