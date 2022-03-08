package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.TradeRebelItemsValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@AllArgsConstructor
@Component
public class TradeRebelItems {

    TradeRebelItemsValidator tradeRebelItemsValidator;
    private RebelPersistenceGateway rebelPersistenceGateway;

    public void execute(Trade trade) {
        List<String> errorList = tradeRebelItemsValidator.validate(trade);

        if(!CollectionUtils.isEmpty(errorList)){
            throw new BusinessValidationException(errorList);
        }

        rebelPersistenceGateway.trade(trade);
    }
}
