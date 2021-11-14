package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Pet;
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
    public Optional<Vet> findByUsername(String username) {
        Vet vet = entityManager.find(Vet.class,username);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findByName(String name) {
        Vet vet = entityManager.find(Vet.class,name);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findByAddress(String address) {
        Vet vet = entityManager.find(Vet.class,address);
        return vet!=null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findByNeighborhood(String neighborhood) {
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

    @Override
    public Optional<Vet> editNameByUsername(String username, String name) {
        try {
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setName(name);

            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> editAddressByUsername(String username, String address) {
        try {
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setAddress(address);

            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> editNeighborhoodByUsername(String username, String neighborhood) {
        try {
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setNeighborhood(neighborhood);

            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
