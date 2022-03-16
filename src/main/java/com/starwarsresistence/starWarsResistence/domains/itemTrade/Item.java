package com.starwarsresistence.starWarsResistence.domains.itemTrade;

import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {

    private ItemsEnum item;
    private int amount;

    public int pointsPerItem(){
        return item.getItemPoints() * amount;
    }
}
