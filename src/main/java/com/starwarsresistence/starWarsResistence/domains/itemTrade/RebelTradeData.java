package com.starwarsresistence.starWarsResistence.domains.itemTrade;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;


@Getter
@Setter
//@Builder
public class RebelTradeData {
    private Long rebelId;
    private List<Item> rebelTradeBag;
    @ApiModelProperty(hidden = true)
    private Rebel rebel;

    public RebelTradeData(Long rebelId, List<Item> tradeBagRebel) {
        this.rebelId = rebelId;
        this.rebelTradeBag = tradeBagRebel;
    }
//
//    public RebelTradeData(Long rebelId, List<Item> rebelTradeBag, Rebel rebel) {
//        this.rebelId = rebelId;
//        this.rebelTradeBag = rebelTradeBag;
//        this.rebel = rebel;
//    }
}
