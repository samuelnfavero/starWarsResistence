package com.starwarsresistence.starWarsResistence.domains.itemTrade;

import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemTrade {

    private Long rebelId1;
    private Long rebelId2;

    private ItemsEnum itemToTradeRebel1;
    private ItemsEnum itemToTradeRebel2;

    private int numberOfItems1;
    private int numberOfItems2;

    public void trade(){}//TODO

}
