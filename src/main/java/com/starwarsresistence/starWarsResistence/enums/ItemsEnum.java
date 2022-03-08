package com.starwarsresistence.starWarsResistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemsEnum {
    WEAPON(4),
    AMMUNITION(3),
    WATER(2),
    FOOD(1);

    public int itemPoints;
}
