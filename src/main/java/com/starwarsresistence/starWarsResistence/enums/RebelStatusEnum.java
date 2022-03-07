package com.starwarsresistence.starWarsResistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum RebelStatusEnum {
    TRAITOR("Traidor"),
    REBEL("Rebelde");

    private String rebelStatus;
}
