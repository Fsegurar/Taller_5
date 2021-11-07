package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.UserApp;
import edu.unbosque.Taller_5.jpa.repositories.UserAppRepository;
import edu.unbosque.Taller_5.jpa.repositories.UserAppRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.UserAppPOJO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserAppService {

    UserAppRepository userappRepository;

    public List<UserAppPOJO> listUsers() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);
        List<UserApp> users = userappRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserAppPOJO> userappPOJO = new ArrayList<>();
        for (UserApp user : users) {
            userappPOJO.add(new UserAppPOJO(
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRole()
            ));
        }

        return userappPOJO;

    }

    public void saveUserApp(String username, String password, String email, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userapp = new UserApp(username, password, email, role);
        UserApp persistedUserApp = userappRepository.save(userapp).get();

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

}
