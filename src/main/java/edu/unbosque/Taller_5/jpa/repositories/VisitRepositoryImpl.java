package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> findByVisitId(Integer visit_id) {
        Visit visit = entityManager.find(Visit.class,visit_id);
        return visit!=null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public Optional<Visit> findByType(String type) {
        Visit visit = entityManager.find(Visit.class,type);
        return visit!=null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public Optional<Visit> findByVet(String vet_name) {
        Visit visit = entityManager.find(Visit.class,vet_name);
        return visit!=null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public Optional<Visit> findByPetId(Integer pet_id) {
        Visit visit = entityManager.find(Visit.class,pet_id);
        return visit!=null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public List<Visit> findAll() {return entityManager.createQuery("from UserApp ").getResultList();
    }


    @Override
    public Optional<Visit> save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
