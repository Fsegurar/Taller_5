package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Official;
import edu.unbosque.Taller_5.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository{

    private EntityManager entityManager;

    public OfficialRepositoryImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Official> findByUsername(String username) {
        Official official =entityManager.find(Official.class,username);
        return official!=null ? Optional.of(official) : Optional.empty();
    }

    @Override
    public Optional<Official> findByName(String name) {
        Official official =entityManager.find(Official.class,name);
        return official!=null ? Optional.of(official) : Optional.empty();
    }

    @Override
    public List<Official> findAll() {return entityManager.createQuery("from Official ").getResultList();}

    @Override
    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Official> editNameByUsername(String username, String name) {
        Official official = (Official) entityManager.createQuery("UPDATE Official o  SET  o.name = :name  WHERE o.username = :username")
                .setParameter("name",name)
                .setParameter("username",username);
        return official!=null ? Optional.of(official) : Optional.empty();
    }

}
