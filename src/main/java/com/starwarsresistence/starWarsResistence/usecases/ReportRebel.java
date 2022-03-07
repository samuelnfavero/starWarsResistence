package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.exceptions.BusinessValidationException;
import com.starwarsresistence.starWarsResistence.gateways.controllers.RebelController;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportRebel {

    private RebelPersistenceGateway rebelPersistenceGateway;

    public void execute(Long id) {

        if(id == null){
            throw new BusinessValidationException("É necessário ID do rebelde para reportar.");
        }
        rebelPersistenceGateway.reportRebel(id);
    }
}
