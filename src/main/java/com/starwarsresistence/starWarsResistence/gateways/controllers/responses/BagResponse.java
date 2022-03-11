package com.starwarsresistence.starWarsResistence.gateways.controllers.responses;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class BagResponse {

    private Long id;

    private int weapons;

    private int ammunition;

    private int water;

    private int food;

    public BagResponse(Bag bag) {
        this.id = bag.getId();
        this.weapons = bag.getWeapons();
        this.ammunition = bag.getAmmunition();
        this.water = bag.getWater();
        this.food = bag.getFood();
    }

}
