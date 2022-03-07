package com.starwarsresistence.starWarsResistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum RebelReportsEnum {
    IS_NOT_A_TRAITOR(2),
    IS_A_TRAITOR(3);

    public int numberOfReports;
}
