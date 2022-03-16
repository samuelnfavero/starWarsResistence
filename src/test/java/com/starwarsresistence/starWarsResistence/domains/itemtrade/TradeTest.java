package com.starwarsresistence.starWarsResistence.domains.itemtrade;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Item;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import com.starwarsresistence.starWarsResistence.testModels.FakeTrade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeTest {


    @InjectMocks
    Trade trade;

    @Test
    public void shouldValidateTheTradeWhenThePointsAreEqual(){
        List<Item> tradeBag1 = FakeTrade.createFakeItemList();
        List<Item> tradeBag2 = FakeTrade.createFakeItemList();

        trade.tradePointsValidator(tradeBag1, tradeBag2);

    }

    @Test
    public void shouldThrowAnExceptionWhenThePointsAreNotEqual(){
        List<Item> tradeBag1 = FakeTrade.createFakeItemList();
        List<Item> tradeBag2 = FakeTrade.createAnotherFakeItemList();

        assertThrows(BusinessValidationException.class, () -> trade.tradePointsValidator(tradeBag1, tradeBag2));

    }

    @Test
    public void shouldThrowAnExceptionWhenOneOfTheRebelsIsATraitor(){
        Rebel rebel1 = FakeRebel.createFakeRebel();
        Rebel rebel2 = FakeRebel.createFakeRebel();
        rebel2.setATraitor(true);

        assertThrows(BusinessValidationException.class, () -> trade.isATraitorValidator(rebel1,rebel2));
    }

    @Test
    public void shouldDoNothingWhenThereAreNoTraitors(){
        Rebel rebel1 = FakeRebel.createFakeRebel();
        Rebel rebel2 = FakeRebel.createFakeRebel();

        trade.isATraitorValidator(rebel1,rebel2);
    }
}
