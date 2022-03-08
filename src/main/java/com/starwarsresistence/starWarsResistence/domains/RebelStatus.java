package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.enums.RebelStatusEnum;
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
public class RebelStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RebelStatusEnum status = RebelStatusEnum.REBEL;

    @Column
    private int reports = 0;

}
