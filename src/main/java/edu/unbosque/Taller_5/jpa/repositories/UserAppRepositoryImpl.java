package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserApp> findAll() {
        return entityManager.createQuery("from Userapp").getResultList();
    }

    @Override
    public Optional<UserApp> save(UserApp userapp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userapp);
            entityManager.getTransaction().commit();
            return Optional.of(userapp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
