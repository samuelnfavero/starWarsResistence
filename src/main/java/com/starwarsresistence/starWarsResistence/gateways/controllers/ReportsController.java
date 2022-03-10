package com.starwarsresistence.starWarsResistence.gateways.controllers;


import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.MessageResponseDTO;
import com.starwarsresistence.starWarsResistence.usecases.Reports;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwarsresistence/reports")
@AllArgsConstructor
public class ReportsController {

    Reports reports;

    @GetMapping("/traitorpercentagereport")
    public MessageResponseDTO traitorPercentageReport(){
        return reports.traitorPercentageReport();
    }

    @GetMapping("/itemsaveragereport")
    public MessageResponseDTO itemsAverageReport(){
        return reports.itemsAverageReport();
    }

    @GetMapping("/lostpointsreport")
    public MessageResponseDTO lostPointsReport(){
        return reports.lostPointsReport();
    }

}
