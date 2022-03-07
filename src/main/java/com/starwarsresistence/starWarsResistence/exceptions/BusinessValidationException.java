package com.starwarsresistence.starWarsResistence.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessValidationException extends RuntimeException {
    public BusinessValidationException(List<String> errorList) {
        super(errorList.stream().collect(Collectors.joining(";")));
    }

    public BusinessValidationException(String errorMessage) {
        super(errorMessage);
    }
}
