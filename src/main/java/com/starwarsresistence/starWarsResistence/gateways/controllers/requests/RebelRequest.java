package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class RebelRequest {
    private String name;

    private String age;

    private String genre;

    private Bag bag;

    private Coordinates coordinates;


}
