package com.starwarsresistence.starWarsResistence.gateways.persistence.database.validators;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import org.springframework.stereotype.Component;

@Component
public class TradeValidator {

    public String verifyIfRebelHasTheAmountOfWeapon(Rebel rebel, int amountOfWeapons) {
        String message = null;
        if(rebel.getBag().getWeapons() < amountOfWeapons){
            message = rebel.getName() + " não tem a quantidade de armas suficientes para a troca";
        }
        return message;
    }

    public String verifyIfRebelHasTheAmountOfAmmunition(Rebel rebel, int amountOfAmmunition) {
        String message = null;
        if(rebel.getBag().getAmmunition() < amountOfAmmunition){
            message = rebel.getName() + " não tem a quantidade de munição suficiente para a troca";
        }
        return message;
    }

    public String verifyIfRebelHasTheAmountOfWater(Rebel rebel, int amountOfWater) {
        String message = null;
        if(rebel.getBag().getWater() < amountOfWater){
            message = rebel.getName() + " não tem a quantidade de água suficiente para a troca";
        }
        return message;
    }

    public String verifyIfRebelHasTheAmountOfFood(Rebel rebel, int amountOfFood) {
        String message = null;
        if(rebel.getBag().getFood() < amountOfFood){
            message = rebel.getName() + " não tem a quantidade de comida suficiente para a troca";
        }
        return message;

    }
}
