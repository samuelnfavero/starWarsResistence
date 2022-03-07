package com.starwarsresistence.starWarsResistence.domains;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Rebel {

    private Long id;
    private String name;
    private String age;
    private String genre;
    private Bag bag;
    private Localization localization;
    private RebelStatus rebelStatus;
}
