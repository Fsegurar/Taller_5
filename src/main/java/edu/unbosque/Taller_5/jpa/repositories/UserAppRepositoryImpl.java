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
    public Optional<UserApp> findByUsername(String username) {
        UserApp userApp = entityManager.find(UserApp.class,username);
        return userApp!=null ? Optional.of(userApp) : Optional.empty();
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("from UserApp ").getResultList();
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

    @Override
    public void deleteByUsername(String Username) {
        UserApp userApp = entityManager.find(UserApp.class,Username);
        if(userApp!=null){
            try{
                entityManager.getTransaction().begin();
                entityManager.remove(userApp.getOfficial());
                entityManager.remove(userApp.getOwner());
                entityManager.remove(userApp.getVet());
                entityManager.remove(userApp);
                entityManager.getTransaction().commit();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editEmailByUsername(String username, String email) {

        entityManager.createQuery("UPDATE UserApp  u SET  u.email = :email  WHERE u.username = :username")
                .setParameter("email",email)
                .setParameter("username",username);

    }

    /*public Optional<UserApp> editEmailByUsername(String username, String email) {
        try {
            entityManager.getTransaction().begin();
            UserApp userapp = entityManager.find(UserApp.class, username);
            userapp.setEmail(email)
            // entityManager.update(userapp); // Revisar si esto es obligatorio
            entityManager.getTransaction().commit();
            return Optional.of(userapp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }*/

}
