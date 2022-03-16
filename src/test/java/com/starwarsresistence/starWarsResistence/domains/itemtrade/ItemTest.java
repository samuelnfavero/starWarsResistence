package com.starwarsresistence.starWarsResistence.domains.itemtrade;

import com.starwarsresistence.starWarsResistence.domains.itemTrade.Item;
import com.starwarsresistence.starWarsResistence.enums.ItemsEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class ItemTest {

    @Test
    public void shouldCalculatetheNumberOfPointsPerItem(){
        Item item = new Item(ItemsEnum.WEAPON, 2);

        int numberOfPoints = item.pointsPerItem();

        Assertions.assertEquals(8, numberOfPoints);
    }
}
