package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateCoordinatesValidator {
    public List<String> validate(CoordinatesResponse coordinatesResponse) {
        List<String> errorMessages = new ArrayList<>();

        //TODO
        return errorMessages;
    }
}
