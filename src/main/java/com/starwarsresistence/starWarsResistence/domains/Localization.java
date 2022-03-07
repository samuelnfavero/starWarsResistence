package com.starwarsresistence.starWarsResistence.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Localization {

    private Long id;
    private String latitude;
    private String longitude;
    private String galaxyName;
}
