package com.starwarsresistence.starWarsResistence.usecases;


import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.UpdateCoordinatesValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class UpdateCoordinates {

    private UpdateCoordinatesValidator updateCoordinatesValidator;
    private RebelPersistenceGateway rebelPersistenceGateway;

    public void execute(CoordinatesResponse coordinatesResponse){

        List<String> errorMessages = updateCoordinatesValidator.validate(coordinatesResponse);

        if(!CollectionUtils.isEmpty(errorMessages)){
            throw new BusinessValidationException(errorMessages);
        }

        rebelPersistenceGateway.updateCoordinates(coordinatesResponse);

    }
}
