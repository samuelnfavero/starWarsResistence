package com.starwarsresistence.starWarsResistence.domains.itemTrade;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Trade {

    private RebelTradeData rebelTradeData1;
    private RebelTradeData rebelTradeData2;


    public void tradePointsValidator(List<Item> tradeBag1, List<Item> tradeBag2){
        int pointsRebel1 = pointsCalculator(tradeBag1);
        int pointsRebel2 = pointsCalculator(tradeBag2);

        if(pointsRebel1 != pointsRebel2){
            throw new BusinessValidationException("A troca não pode ser realizada. Pontuações diferentes");
        }
    }

    private int pointsCalculator(List<Item> tradeBag){
        return tradeBag.stream()
                .reduce(0, (parcial, item) -> parcial + item.pointsPerItem(), Integer::sum);
    }
}
