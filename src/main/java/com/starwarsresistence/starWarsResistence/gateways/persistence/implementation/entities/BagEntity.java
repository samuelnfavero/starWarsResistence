package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BagEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int weapons;

    @Column
    private int ammunition;

    @Column
    private int water;

    @Column
    private int food;
}