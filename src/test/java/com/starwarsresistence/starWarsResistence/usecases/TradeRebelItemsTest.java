package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.TradeRebelItemsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeRebelItemsTest {

    @Mock
    TradeRebelItemsValidator tradeRebelItemsValidator;
    @Mock
    RebelPersistenceGateway rebelPersistenceGateway;
    @InjectMocks
    TradeRebelItems tradeRebelItems;

    @Test
    void shouldThrowAnExceptionWhenValidationFailed(){
        String errorMessage = "VALIDATION ERROR";
        Trade trade = Trade.builder().build();
        when(tradeRebelItemsValidator.validate(trade)).thenReturn(List.of("VALIDATION ERROR"));


        BusinessValidationException exception = Assertions.assertThrows(BusinessValidationException.class, () -> tradeRebelItems.execute(trade));

        Assertions.assertEquals(errorMessage, exception.getMessage());

        verify(rebelPersistenceGateway, times(0)).trade(trade);
    }

    @Test
    void shouldTradeWhenValidationSuceed(){
        Trade trade = Trade.builder().build();
        when(tradeRebelItemsValidator.validate(trade)).thenReturn(List.of());
        doNothing().when(rebelPersistenceGateway).trade(trade);

        tradeRebelItems.execute(trade);

        verify(rebelPersistenceGateway, times(1)).trade(trade);
    }

}
