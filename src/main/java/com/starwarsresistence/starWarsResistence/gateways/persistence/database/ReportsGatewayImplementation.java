package com.starwarsresistence.starWarsResistence.gateways.persistence.database;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.BagResponse;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.gateways.persistence.ReportsGateway;
import com.starwarsresistence.starWarsResistence.gateways.persistence.database.repository.DatabasePersistenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ReportsGatewayImplementation implements ReportsGateway {

    DatabasePersistenceRepository persistenceRepository;
    @Override
    public MessageResponseDTO traitorPercentageReport() {
        List<Rebel> allRebels = persistenceRepository.findAll();
        List<Rebel> allTraitors = allRebels.stream()
                .filter(rebel -> rebel.isATraitor())
                .collect(Collectors.toList());

        float numberOfTraitors = allTraitors.size();
        float numberOfRebels = allRebels.size();
        float traitorsPercentage = (numberOfTraitors/numberOfRebels)*100;
        float rebelsPercentage = 100 - traitorsPercentage;

        return new MessageResponseDTO("Porcentagem de Traidores: " + traitorsPercentage + "%" +
                ". Porcentagem de rebeldes: " + rebelsPercentage + "%.");
    }

    @Override
    public MessageResponseDTO itemsAverageReport() {

        List<Rebel> allRebels = persistenceRepository.findAll().stream()
                .filter(rebel -> !rebel.isATraitor())
                .collect(Collectors.toList());

        BagResponse bag = countAllItemsOfARebelList(allRebels);

        float weaponAverage = bag.getWeapons()/(float) (allRebels.size());
        float ammunitionAverage = bag.getAmmunition()/(float)(allRebels.size());
        float waterAverage = bag.getWater()/(float)(allRebels.size());
        float foodAverage = bag.getFood()/(float)(allRebels.size());

        return new MessageResponseDTO("Média de armas por rebelde " + weaponAverage
                + ". Média de munição por rebelde " + ammunitionAverage
                + ". Média de água por rebelde " + waterAverage
                + ". Média de comida por rebelde " + foodAverage
        );
    }

    @Override
    public MessageResponseDTO lostPointsReport() {

        List<Rebel> allTraitors = persistenceRepository.findAll().stream()
                .filter(rebel -> rebel.isATraitor())
                .collect(Collectors.toList());

        BagResponse bag = countAllItemsOfARebelList(allTraitors);
        return new MessageResponseDTO("Pontos perdidos devido a traidores: " + countBagPoints(bag));
    }

    private int countBagPoints(BagResponse bag){
        return bag.getWeapons()* ItemsEnum.WEAPON.getItemPoints()
                + bag.getAmmunition() * ItemsEnum.AMMUNITION.getItemPoints()
                + bag.getWater() * ItemsEnum.WATER.getItemPoints()
                + bag.getFood() * ItemsEnum.FOOD.getItemPoints();

    }

    private BagResponse countAllItemsOfARebelList(List<Rebel> list){

        BagResponse bag = new BagResponse();

        list.forEach(rebel -> {
            bag.setWeapons(bag.getWeapons() + rebel.getBag().getWeapons());
            bag.setAmmunition(bag.getAmmunition() + rebel.getBag().getAmmunition());
            bag.setWater(bag.getWater() + rebel.getBag().getWater());
            bag.setFood(bag.getFood() + rebel.getBag().getFood());
        });
        return bag;
    }
}
