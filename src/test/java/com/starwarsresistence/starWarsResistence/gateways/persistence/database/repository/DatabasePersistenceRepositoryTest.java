package com.starwarsresistence.starWarsResistence.gateways.persistence.database.repository;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.testModels.FakeRebel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class DatabasePersistenceRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    DatabasePersistenceRepository persistenceRepository;

    @Test
    void shoudFindAllRebels(){
        Rebel rebel1 = entityManager.persist(
                FakeRebel.createFakeRebelWithoutId()
        );
        Rebel rebel2 = entityManager.persist(
                FakeRebel.createFakeRebelWithoutId()
        );

        List<Rebel> allRebels = persistenceRepository.findAll();

        Assertions.assertEquals(2, allRebels.size());

    }
}
