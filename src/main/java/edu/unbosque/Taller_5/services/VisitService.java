package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Visit;
import edu.unbosque.Taller_5.jpa.repositories.VisitRepository;
import edu.unbosque.Taller_5.jpa.repositories.VisitRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VisitService {
    VisitRepository visitRepository;

    public Visit findByVisitId(Integer visit_id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Visit persistedVisit = visitRepository.findByVisitId(visit_id).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;
    }

    public Visit findByType(String type){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Visit persistedVisit = visitRepository.findByType(type).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;
    }

    public Visit findByVet(String vet_name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Visit persistedVisit = visitRepository.findByVet(vet_name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;
    }

    public Visit findByPetId(Integer pet_id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Visit persistedVisit = visitRepository.findByPetId(pet_id).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;
    }

    public List<VisitPOJO> listVisits(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJO = new ArrayList<>();
        for (Visit visit : visits){
            visitPOJO.add(new VisitPOJO(
                    visit.getVisit_id(),
                    visit.getCreated_at(),
                    visit.getType(),
                    visit.getDescription(),
                    visit.getVet().getName(),
                    visit.getPet().getPet_id()
            ));
        }
        return  visitPOJO;
    }

    public Visit saveVisit(String created_at, String type, String description){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);

        Visit visit = new Visit(created_at,type,description);
        Visit persistedVisit = visitRepository.save(visit).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;
    }
}
