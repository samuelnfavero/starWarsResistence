package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.BagRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.BagResponse;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int weapons;

    @Column
    private int ammunition;

    @Column
    private int water;

    @Column
    private int food;



    public Bag(BagRequest bagRequest){
        weapons = bagRequest.getWeapons();
        ammunition = bagRequest.getAmmunition();
        water = bagRequest.getWater();
        food = bagRequest.getFood();
    }
}
