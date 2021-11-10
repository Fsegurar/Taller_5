package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository{

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Vet> findByName(String name) {
        Vet vet = entityManager.find(Vet.class,name);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findByAdress(String Adress) {
        Vet vet = entityManager.find(Vet.class,Adress);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findeByNeighborhood(String neighborhood) {
        Vet vet = entityManager.find(Vet.class,neighborhood);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public List<Vet> findAll() {return entityManager.createQuery("from Vet ").getResultList();
    }

    @Override
    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
