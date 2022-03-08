package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Item;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.RebelTradeData;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import com.starwarsresistence.starWarsResistence.enums.RebelReportsEnum;
import com.starwarsresistence.starWarsResistence.enums.RebelStatusEnum;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.repository.DataBasePersistenceRepository;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.validators.TradeValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class RebelPersistenceGatewayImplementation implements RebelPersistenceGateway {

    DataBasePersistenceRepository persistenceRepository;
    TradeValidator tradeValidator;

    @Override
    public Rebel save(Rebel rebel) {
        persistenceRepository.save(rebel);
        return rebel;
    }

    @Override
    public List<Rebel> findAll() {
        return persistenceRepository.findAll();
    }


    @Override
    public Rebel findById(Long id) {
        return persistenceRepository.findById(id).get();
    }

    @Override
    public void updateCoordinates(Coordinates coordinates) {
        Rebel rebel = findById(coordinates.getId());
        rebel.setCoordinates(coordinates);
        persistenceRepository.save(rebel);
    }

    @Override
    public void reportRebel(Long id) {
        Rebel rebel = giveAReportOrDefineAsATraitor(id);
        persistenceRepository.save(rebel);
    }

    @Override
    public void trade(Trade trade) {
        trade.tradePointsValidator(trade.getRebelTradeData1().getRebelTradeBag(), trade.getRebelTradeData2().getRebelTradeBag());
        Trade tradeWithRebels = setRebelsOnTrade(trade);
        validateTrade(tradeWithRebels.getRebelTradeData1());
        validateTrade(tradeWithRebels.getRebelTradeData2());
        trade = makingTrade(tradeWithRebels);

        persistenceRepository.save(trade.getRebelTradeData1().getRebel());
        persistenceRepository.save(trade.getRebelTradeData2().getRebel());
    }


    private Trade makingTrade(Trade trade){
        Rebel rebel1 = trade.getRebelTradeData1().getRebel();
        List<Item> tradeBag1 = trade.getRebelTradeData1().getRebelTradeBag();

        Rebel rebel2 = trade.getRebelTradeData2().getRebel();
        List<Item> tradeBag2 = trade.getRebelTradeData2().getRebelTradeBag();

        Rebel[] rebelsInTrade = tradeBagItems(rebel1, tradeBag1, rebel2);
        //[0] -> Rebel1, [1] -> Rebel2
        Rebel[] rebelsAfterTrade = tradeBagItems(rebelsInTrade[1], tradeBag2, rebelsInTrade[0]);
        //[0] -> Rebel2, [1] -> Rebel1

        trade.getRebelTradeData1().setRebel(rebelsAfterTrade[1]);
        trade.getRebelTradeData2().setRebel(rebelsAfterTrade[0]);

        return trade;
    }

    private Rebel[] tradeBagItems(Rebel rebelWhoLosesItems, List<Item> tradeBag, Rebel rebelWhoReceiveItems){
        tradeBag.forEach(item -> {
            if(item.getItem() == ItemsEnum.WEAPON){
                int weaponAmount = item.getAmount();
                rebelWhoLosesItems.getBag().setWeapons(rebelWhoLosesItems.getBag().getWeapons() - weaponAmount);
                rebelWhoReceiveItems.getBag().setWeapons(rebelWhoReceiveItems.getBag().getWeapons() + weaponAmount);
            }
            if(item.getItem() == ItemsEnum.AMMUNITION){
                int ammunitionAmount = item.getAmount();
                rebelWhoLosesItems.getBag().setAmmunition(rebelWhoLosesItems.getBag().getAmmunition() - ammunitionAmount);
                rebelWhoReceiveItems.getBag().setAmmunition(rebelWhoReceiveItems.getBag().getAmmunition() + ammunitionAmount);
            }
            if(item.getItem() == ItemsEnum.WATER){
                int waterAmount = item.getAmount();
                rebelWhoLosesItems.getBag().setWater(rebelWhoLosesItems.getBag().getWater() - waterAmount);
                rebelWhoReceiveItems.getBag().setWater(rebelWhoReceiveItems.getBag().getWater() + waterAmount);
            }
            if(item.getItem() == ItemsEnum.FOOD){
                int foodAmount = item.getAmount();
                rebelWhoLosesItems.getBag().setFood(rebelWhoLosesItems.getBag().getFood() - foodAmount);
                rebelWhoReceiveItems.getBag().setFood(rebelWhoReceiveItems.getBag().getFood() + foodAmount);
            }
        });

        return new Rebel[]{rebelWhoLosesItems, rebelWhoReceiveItems};
    }

    private void validateTrade(RebelTradeData trade) {
        List<String> errorList = new ArrayList<>();

        trade.getRebelTradeBag().forEach(item -> {
            if(item.getItem() == ItemsEnum.WEAPON){
                int weaponAmount = item.getAmount();
                String message = tradeValidator.verifyIfRebelHasTheAmountOfWeapon(trade.getRebel(), weaponAmount);
                errorList.add(message);
            }
            if(item.getItem() == ItemsEnum.AMMUNITION){
                int ammunitionAmount = item.getAmount();
                String message = tradeValidator.verifyIfRebelHasTheAmountOfAmmunition(trade.getRebel(), ammunitionAmount);
                errorList.add(message);
            }
            if(item.getItem() == ItemsEnum.WATER){
                int waterAmount = item.getAmount();
                String message = tradeValidator.verifyIfRebelHasTheAmountOfWater(trade.getRebel(), waterAmount);
                errorList.add(message);
            }
            if(item.getItem() == ItemsEnum.FOOD){
                int foodAmount = item.getAmount();
                String message = tradeValidator.verifyIfRebelHasTheAmountOfFood(trade.getRebel(), foodAmount);
                errorList.add(message);
            }
        });

        errorList.remove(null);
        if (!CollectionUtils.isEmpty(errorList)) {
            throw new BusinessValidationException(errorList);
        }
    }

    private Trade setRebelsOnTrade(Trade trade){
        Rebel rebel1 = persistenceRepository.findById(trade.getRebelTradeData1().getRebelId()).get();
        trade.getRebelTradeData1().setRebel(rebel1);

        Rebel rebel2 = persistenceRepository.findById(trade.getRebelTradeData2().getRebelId()).get();
        trade.getRebelTradeData2().setRebel(rebel2);

        return  trade;
    }


    private Rebel giveAReportOrDefineAsATraitor(Long id){
        Rebel rebel = persistenceRepository.findById(id).get();
        int reports = rebel.getRebelStatus().getReports();
        if(reports < RebelReportsEnum.IS_NOT_A_TRAITOR.getNumberOfReports()){
            reports++;
            rebel.getRebelStatus().setReports(reports);
        }else{
            rebel.getRebelStatus().setReports(RebelReportsEnum.IS_A_TRAITOR.getNumberOfReports());
            rebel.getRebelStatus().setStatus(RebelStatusEnum.TRAITOR);
        }
        return rebel;
    }
}
