package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Item;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.RebelTradeData;
import com.starwarsresistence.starWarsResistence.domains.itemTrade.Trade;
import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import com.starwarsresistence.starWarsResistence.enums.RebelReportsEnum;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.repository.DataBasePersistenceRepository;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.validators.TradeValidator;
import com.starwarsresistence.starWarsResistence.mappers.RebelRequestMapper;
import com.starwarsresistence.starWarsResistence.mappers.RebelResponseMapper;
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
    private final RebelRequestMapper rebelRequestMapper = RebelRequestMapper.INSTANCE;
    private final RebelResponseMapper rebelResponseMapper = RebelResponseMapper.INSTANCE;

    @Override
    public RebelResponse save(RebelRequest rebelRequest) {

        Rebel rebel = rebelRequestMapper.toModel(rebelRequest);
        Rebel savedRebel = persistenceRepository.save(rebel);
        return rebelResponseMapper.toDTO(savedRebel);
    }

    @Override
    public List<RebelResponse> findAll() {
        List<RebelResponse> allRebelsResponse = new ArrayList<>();
        persistenceRepository.findAll().forEach(rebel -> allRebelsResponse.add(new RebelResponse(rebel)));
        return allRebelsResponse;
    }


    @Override
    public Rebel findById(Long id) {
        return persistenceRepository.findById(id).get();
    }

    @Override
    public void updateCoordinates(CoordinatesResponse coordinatesResponse) {
        Rebel rebel = findById(coordinatesResponse.getId());
        Coordinates coordinates = coordinatesResponse.toModel();
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
        trade.isATraitorValidator(trade.getRebelTradeData1().getRebel(), trade.getRebelTradeData2().getRebel());
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



            for(int i =0; i <= errorList.size(); i++){
                errorList.remove(null);
            }


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
        int reports = rebel.getReports();
        if(reports < RebelReportsEnum.IS_NOT_A_TRAITOR.getNumberOfReports()){
            reports++;
            rebel.setReports(reports);
        }else{
            rebel.setReports(RebelReportsEnum.IS_A_TRAITOR.getNumberOfReports());
            rebel.setATraitor(true);
        }
        return rebel;
    }
}
