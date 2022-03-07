package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateRebelValidator {

    public List<String> validate(Rebel rebel) {
        List<String> errorList = new ArrayList<>();

        //TODO

        return errorList;
    }
}
