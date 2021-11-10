package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Optional<Pet> findByPetId(Integer pet_id);

    Optional<Pet> findByName(String name);

    Optional<Pet> findBySpecies(String species);

    Optional<Pet> findByRace(String race);

    Optional<Pet> findBySize(String size);

    Optional<Pet> findBySex(String sex);

    Optional<Pet> findByOwner(Integer owner_id);

    List<Pet> findAll();

    Optional<Pet> save(Pet pet);



}
