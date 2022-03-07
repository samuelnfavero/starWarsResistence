package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.usecases.validators.CreateRebelValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.List;


@Component
@AllArgsConstructor
public class CreateRebel {

    private CreateRebelValidator createRebelValidator;
    private RebelPersistenceGateway rebelPersistenceGateway;

    public Rebel execute(Rebel rebel){
        List<String> errorList = createRebelValidator.validate(rebel);

        if(!CollectionUtils.isEmpty(errorList)){
            throw new BusinessValidationException(errorList);
        }

        return rebelPersistenceGateway.save(rebel);
    }
}
