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
    @OneToOne
    private Bag bag;
    @OneToOne
    private Localization localization;
    @OneToOne
    private RebelStatus rebelStatus;
}
