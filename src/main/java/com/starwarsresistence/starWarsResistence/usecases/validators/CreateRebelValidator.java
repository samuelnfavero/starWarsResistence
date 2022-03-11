package com.starwarsresistence.starWarsResistence.usecases.validators;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateRebelValidator {

    public List<String> validate(RebelRequest rebelRequest) {
        List<String> errorList = new ArrayList<>();

        if(!StringUtils.hasText(rebelRequest.getName())){
            errorList.add("Nome não informado");
        }
        if(!StringUtils.hasText(rebelRequest.getAge())){
            errorList.add("Idade não informada");
        }
        if(!StringUtils.hasText(rebelRequest.getGenre())){
            errorList.add("Gênero não informado");
        }
        if(ObjectUtils.isEmpty(rebelRequest.getBag())){
            errorList.add("Itens não informados");
        }
        if(ObjectUtils.isEmpty(rebelRequest.getCoordinates())){
            errorList.add("Coordenadas não informadas");
        }

        return errorList;
    }
}
