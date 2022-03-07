package com.starwarsresistence.starWarsResistence.domains;

import com.starwarsresistence.starWarsResistence.enums.RebelStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RebelStatus {

    private RebelStatusEnum status = RebelStatusEnum.REBEL;
    private int reports;
}
