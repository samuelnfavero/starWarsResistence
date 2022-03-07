package com.starwarsresistence.starWarsResistence.domains;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Bag bag;
    @OneToOne(cascade = CascadeType.ALL)
    private Localization localization;
    @OneToOne(cascade = CascadeType.ALL)
    private RebelStatus rebelStatus;
}
