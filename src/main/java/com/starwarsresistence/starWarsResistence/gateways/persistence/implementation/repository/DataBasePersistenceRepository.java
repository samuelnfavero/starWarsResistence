package com.starwarsresistence.starWarsResistence.gateways.persistence.implementation.repository;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBasePersistenceRepository extends JpaRepository<Rebel, Long> {
}
