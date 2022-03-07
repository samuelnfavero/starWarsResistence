package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class UpdateCoordinates {

    private com.starwarsresistence.starWarsResistence.usecases.validators.UpdateCoordinatesValidator UpdateCoordinatesValidator;
    private RebelPersistenceGateway rebelPersistenceGateway;

    public void execute(Coordinates coordinates){

        List<String> errorMEssages = UpdateCoordinatesValidator.validate(coordinates);

        if(!CollectionUtils.isEmpty(errorMEssages)){
            throw new BusinessValidationException(errorMEssages);
        }

        rebelPersistenceGateway.updateCoordinates(coordinates);

    }
}
