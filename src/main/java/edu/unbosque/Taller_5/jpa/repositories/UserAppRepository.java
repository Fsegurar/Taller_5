package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByUsername(String username);

    List<UserApp> findAll();

    Optional<UserApp> save(UserApp userapp);

    void deleteByUsername(String Username);

    Optional<UserApp> editEmailByUsername(String username,String email);
}
