package com.starwarsresistence.starWarsResistence.gateways.persistence.database.validators;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TradeValidatorTest {



    @InjectMocks
    TradeValidator tradeValidator;

    @Test
    public void shouldReturnAMessageWhenTheWeaponsAreNotEnough(){
        int amount = 6;
        Rebel rebel = FakeRebel.createFakeRebel();
        String fakeMessage = rebel.getName() + " não tem a quantidade de armas suficientes para a troca";

        String message = tradeValidator.verifyIfRebelHasTheAmountOfWeapon(rebel, amount);

        Assertions.assertEquals(fakeMessage,message);

    }

    @Test
    public void shouldReturnNullWhenTheWeaponsAreEnough(){
        int amount = 1;
        Rebel rebel = FakeRebel.createFakeRebel();


        String message = tradeValidator.verifyIfRebelHasTheAmountOfWeapon(rebel, amount);

        Assertions.assertEquals(null,message);

    }

    @Test
    public void shouldReturnAMessageWhenTheAmmunitionAreNotEnough(){
        int amount = 6;
        Rebel rebel = FakeRebel.createFakeRebel();
        String fakeMessage = rebel.getName() + " não tem a quantidade de munição suficiente para a troca";

        String message = tradeValidator.verifyIfRebelHasTheAmountOfAmmunition(rebel, amount);

        Assertions.assertEquals(fakeMessage,message);

    }

    @Test
    public void shouldReturnNullWhenTheAmmunitionAreEnough(){
        int amount = 1;
        Rebel rebel = FakeRebel.createFakeRebel();

        String message = tradeValidator.verifyIfRebelHasTheAmountOfAmmunition(rebel, amount);

        Assertions.assertEquals(null,message);

    }

    @Test
    public void shouldReturnAMessageWhenTheWaterAreNotEnough(){
        int amount = 6;
        Rebel rebel = FakeRebel.createFakeRebel();
        String fakeMessage = rebel.getName() + " não tem a quantidade de água suficiente para a troca";

        String message = tradeValidator.verifyIfRebelHasTheAmountOfWater(rebel, amount);

        Assertions.assertEquals(fakeMessage,message);

    }

    @Test
    public void shouldReturnNullWhenTheWaterAreEnough(){
        int amount = 1;
        Rebel rebel = FakeRebel.createFakeRebel();

        String message = tradeValidator.verifyIfRebelHasTheAmountOfWater(rebel, amount);

        Assertions.assertEquals(null,message);

    }

    @Test
    public void shouldReturnAMessageWhenTheFoodAreNotEnough(){
        int amount = 6;
        Rebel rebel = FakeRebel.createFakeRebel();
        String fakeMessage = rebel.getName() + " não tem a quantidade de comida suficiente para a troca";

        String message = tradeValidator.verifyIfRebelHasTheAmountOfFood(rebel, amount);

        Assertions.assertEquals(fakeMessage,message);

    }

    @Test
    public void shouldReturnNullWhenTheFoodAreEnough(){
        int amount = 1;
        Rebel rebel = FakeRebel.createFakeRebel();

        String message = tradeValidator.verifyIfRebelHasTheAmountOfFood(rebel, amount);

        Assertions.assertEquals(null,message);

    }
}
