package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> findByName(String name);

    Optional<Vet> findByAdress(String Adress);

    Optional<Vet> findeByNeighborhood(String neighborhood);

    List<Vet> findAll();

    Optional<Vet> save(Vet vet);
}
