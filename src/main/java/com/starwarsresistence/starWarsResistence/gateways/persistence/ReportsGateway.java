package com.starwarsresistence.starWarsResistence.gateways.persistence;

import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;

public interface ReportsGateway {

    MessageResponseDTO traitorPercentageReport();

    MessageResponseDTO itemsAverageReport();

    MessageResponseDTO lostPointsReport();
}
