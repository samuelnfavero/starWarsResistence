package com.starwarsresistence.starWarsResistence.domains.itemTrade;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RebelTradeData {
    private Long rebelId;
    private List<Item> rebelTradeBag;
    private Rebel rebel;

    public RebelTradeData(Long rebelId, List<Item> tradeBagRebel) {
        this.rebelId = rebelId;
        this.rebelTradeBag = tradeBagRebel;
    }
}
