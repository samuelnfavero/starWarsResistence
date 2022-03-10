package com.starwarsresistence.starWarsResistence.gateways.controllers;


import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.gateways.persistence.ReportsGateway;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwarsresistence/reports")
@AllArgsConstructor
public class ReportsController {

    ReportsGateway reportsGateway;

    @GetMapping("/traitorpercentagereport")
    public MessageResponseDTO traitorPercentageReport(){
        return reportsGateway.traitorPercentageReport();
    }

    @GetMapping("/itemsaveragereport")
    public MessageResponseDTO itemsPercentageReport(){
        return reportsGateway.itemsAverageReport();
    }

    @GetMapping("/lostpointsreport")
    public MessageResponseDTO lostPointsReport(){
        return reportsGateway.lostPointsReport();
    }

}
