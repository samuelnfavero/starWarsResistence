package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateCoordinatesValidator {
    public List<String> validate(Coordinates coordinates) {
        List<String> errorMessages = new ArrayList<>();

        //TODO
        return errorMessages;
    }
}
