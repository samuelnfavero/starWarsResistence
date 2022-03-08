package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TradeRebelItemsValidator {

    public List<String> validate(Trade trade) {
        List<String> errorList = new ArrayList<>();

        //TODO
        return errorList;
    }
}
