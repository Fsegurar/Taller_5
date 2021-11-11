package edu.unbosque.Taller_5.services;


import edu.unbosque.Taller_5.jpa.entities.Official;
import edu.unbosque.Taller_5.jpa.entities.UserApp;
import edu.unbosque.Taller_5.jpa.repositories.OfficialRepository;
import edu.unbosque.Taller_5.jpa.repositories.OfficialRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.OfficialPOJO;
import edu.unbosque.Taller_5.servlets.pojos.UserAppPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public OfficialPOJO editNameByUsername(String username,String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official persistedOfficial = officialRepository.editNameByUsername(username,name).get();
        List<Official> users = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();
        OfficialPOJO officialPOJO = new OfficialPOJO();
        for (Official user : users) {
            if (user.getUsername().equals(username)){
                officialPOJO = new OfficialPOJO(user.getUsername().getUsername(),user.getName());
            }
        }

        return officialPOJO;

    }
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
                    official.getUsername().getUsername(),
                    official.getName()
            ));
        }

        return officialPOJOS;

    }

    public OfficialPOJO saveOfficial(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);

        Official official = new Official(name);
         officialRepository.save(official);

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialpojo = new OfficialPOJO(name);

        return officialpojo;

    }
}
