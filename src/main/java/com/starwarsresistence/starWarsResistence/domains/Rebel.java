package com.starwarsresistence.starWarsResistence.domains;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Rebel {

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
