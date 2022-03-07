package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.enums.RebelStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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
    private RebelStatusEnum status;

    @Column(columnDefinition = "integer default 0")
    private Integer reports = 0;

}
