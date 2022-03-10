package com.starwarsresistence.starWarsResistence.usecases;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.gateways.persistence.ReportsGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Reports {

    ReportsGateway reportsGateway;

    public MessageResponseDTO traitorPercentageReport(){
        return reportsGateway.traitorPercentageReport();
    }

    public MessageResponseDTO itemsAverageReport(){
        return reportsGateway.itemsAverageReport();
    }

    public MessageResponseDTO lostPointsReport(){
        return reportsGateway.lostPointsReport();
    }

}
