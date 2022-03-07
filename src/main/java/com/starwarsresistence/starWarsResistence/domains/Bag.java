package com.starwarsresistence.starWarsResistence.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bag {

    private Long id;
    private int weapons;
    private int ammunition;
    private int water;
    private int food;
}
