package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.entities;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RebelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String genre;

    @Column
    private int reports = 0;

    @Column
    private boolean isATraitor = false;

    @OneToOne(cascade = CascadeType.ALL)
    private Bag bag;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinates coordinates;
}
