package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.RebelTradeData;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.List;

@Component
public class TradeRebelItemsValidator {

    public List<String> validate(Trade trade) {
        List<String> errorList = new ArrayList<>();

        RebelTradeData rebel1 = trade.getRebelTradeData1();
        RebelTradeData rebel2 = trade.getRebelTradeData2();

        if(trade.getRebelTradeData1().getRebelId() == null || trade.getRebelTradeData2().getRebelId() == null){
            errorList.add("Id não informado");
        }

        if(CollectionUtils.isEmpty(rebel1.getRebelTradeBag()) || CollectionUtils.isEmpty(rebel2.getRebelTradeBag())){
            errorList.add("Items da troca não informados");
        }
        return errorList;
    }
}
