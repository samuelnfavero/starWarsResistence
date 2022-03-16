package com.starwarsresistence.starWarsResistence.testModels;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Item;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.RebelTradeData;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;

import java.util.List;

public class FakeTrade {

    public static Trade createFakeTrade(){
        return Trade.builder()
                .rebelTradeData1(createFakeRebelTradeData())
                .rebelTradeData2(createFakeRebelTradeData())
                .build();
    }

    private static RebelTradeData createFakeRebelTradeData(){
        return new RebelTradeData(1L,createFakeItemList());
    }

    public static List<Item> createFakeItemList(){
        Item item =  new Item(ItemsEnum.WEAPON,1);
        return List.of(item, item, item);
    }

    public static List<Item> createAEquivalentFakeItemList(){
        Item item1 =  new Item(ItemsEnum.WEAPON,1);
        Item item2 =  new Item(ItemsEnum.AMMUNITION,1);
        Item item3 =  new Item(ItemsEnum.FOOD,1);

        return List.of(item1, item1, item2, item3);
    }

    public static List<Item> createAnotherFakeItemList(){
        Item item =  new Item(ItemsEnum.WEAPON,1);
        return List.of(item, item, item, item);
    }

}
