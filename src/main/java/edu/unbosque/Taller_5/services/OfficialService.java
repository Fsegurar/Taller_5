package edu.unbosque.Taller_5.services;


import edu.unbosque.Taller_5.jpa.entities.Official;
import edu.unbosque.Taller_5.jpa.entities.UserApp;
import edu.unbosque.Taller_5.jpa.repositories.OfficialRepository;
import edu.unbosque.Taller_5.jpa.repositories.OfficialRepositoryImpl;
import edu.unbosque.Taller_5.jpa.repositories.UserAppRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public Official findByUsername(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official persistedOfficial = officialRepository.findByUsername(name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial;
    }

    public Official findByname(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official persistedOfficial = officialRepository.findByName(name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial;
    }

    public List<OfficialPOJO> listOfficials() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPOJO> officialPOJOS = new ArrayList<>();
        for (Official official : officials) {
            officialPOJOS.add(new OfficialPOJO(
                    official.getUserapp().getUsername(),
                    official.getName()
            ));
        }

        return officialPOJOS;

    }

    public Official saveOfficial(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);

        Official official = new Official(name);
        Official persistedOfficial1 = officialRepository.save(official).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial1;

    }
}
