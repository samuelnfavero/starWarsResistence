package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation;

import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.enums.RebelReportsEnum;
import com.starwarsresistence.starWarsResistence.enums.RebelStatusEnum;
import com.starwarsresistence.starWarsResistence.gateways.persistence.RebelPersistenceGateway;
import com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.repository.DataBasePersistenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class RebelPersistenceGatewayImplementation implements RebelPersistenceGateway {

    DataBasePersistenceRepository persistenceRepository;

    @Override
    public Rebel save(Rebel rebel) {
        persistenceRepository.save(rebel);
        return rebel;
    }

    @Override
    public List<Rebel> findAll() {
        return persistenceRepository.findAll();
    }


    @Override
    public Rebel findById(Long id) {
        return persistenceRepository.findById(id).get();
    }

    @Override
    public void updateCoordinates(Coordinates coordinates) {
        Rebel rebel = findById(coordinates.getId());
        rebel.setCoordinates(coordinates);
        persistenceRepository.save(rebel);
    }

    @Override
    public void reportRebel(Long id) {
        Rebel rebel = giveAReportOrDefineAsATraitor(id);
        persistenceRepository.save(rebel);
    }


    private Rebel giveAReportOrDefineAsATraitor(Long id){
        Rebel rebel = persistenceRepository.findById(id).get();
        int reports = rebel.getRebelStatus().getReports();
        if(reports < RebelReportsEnum.IS_NOT_A_TRAITOR.getNumberOfReports()){
            reports++;
            rebel.getRebelStatus().setReports(reports);
        }else{
            rebel.getRebelStatus().setReports(RebelReportsEnum.IS_A_TRAITOR.getNumberOfReports());
            rebel.getRebelStatus().setStatus(RebelStatusEnum.TRAITOR);
        }
        return rebel;
    }
}
