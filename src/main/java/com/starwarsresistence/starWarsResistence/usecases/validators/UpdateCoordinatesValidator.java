package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.CoordinatesRequest;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.CoordinatesResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateCoordinatesValidator {
    public List<String> validate(CoordinatesResponse coordinatesResponse) {
        List<String> errorMessages = new ArrayList<>();

        if(coordinatesResponse.getId() == null){
            errorMessages.add("ID não informado");
        }
        if(!StringUtils.hasText(coordinatesResponse.getLatitude())){
            errorMessages.add("Latitude não informada");
        }
        if(!StringUtils.hasText(coordinatesResponse.getLongitude())){
            errorMessages.add("Longitude não informada");
        }
        if(!StringUtils.hasText(coordinatesResponse.getGalaxyName())){
            errorMessages.add("Nome da galáxia não informado");
        }
        return errorMessages;
    }
}
