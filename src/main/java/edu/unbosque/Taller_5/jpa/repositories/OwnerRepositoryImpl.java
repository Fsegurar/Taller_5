package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository{

    private EntityManager entityManager;

    public  OwnerRepositoryImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Owner> findByOwnerId(Integer owner_id) {
        Owner owner = entityManager.find(Owner.class,owner_id);
        return owner!=null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> findByName(String name) {
        Owner owner = entityManager.find(Owner.class,name);
        return owner!=null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> findByAddress(String address) {
        Owner owner = entityManager.find(Owner.class,address);
        return owner!=null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> findByNeighborhood(String neighborhood) {
        Owner owner = entityManager.find(Owner.class,neighborhood);
        return owner!=null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public List<Owner> findAll() {return entityManager.createQuery("from Owner ").getResultList();
}

    @Override
    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
