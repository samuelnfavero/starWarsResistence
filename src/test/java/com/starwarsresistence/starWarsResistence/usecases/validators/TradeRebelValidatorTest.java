package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.RebelTradeData;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TradeRebelValidatorTest {

    @InjectMocks
    TradeRebelItemsValidator tradeRebelItemsValidator;

    @Test
    void shouldValidateTheTrade(){
        RebelTradeData rebelTradeData = new RebelTradeData(null,null);


        Trade trade = Trade.builder().rebelTradeData1(rebelTradeData).rebelTradeData2(rebelTradeData).build();
        List<String> fakeErrorList= List.of("Id não informado", "Items da troca não informados");

        List<String> errorList = tradeRebelItemsValidator.validate(trade);
        assertEquals(fakeErrorList, errorList);
    }
}
