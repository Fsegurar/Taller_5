package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Vet;
import edu.unbosque.Taller_5.jpa.repositories.VetRepository;
import edu.unbosque.Taller_5.jpa.repositories.VetRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VetService {

    VetRepository vetRepository;

    public Vet editNameByUsername(String username,String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.editNameByUsername(username,name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }
    public Vet editAddressByUsername(String username,String address){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.editAddressByUsername(username,address).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }
    public Vet editNeighborhoodByUsername(String username,String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.editNeighborhoodByUsername(username,neighborhood).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }
    public Vet findByName(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.findByName(name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }

    public Vet findByAdress(String Adress){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.findByAddress(Adress).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }

    public  Vet findeByNeighborhood(String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet persistedVet = vetRepository.findByNeighborhood(neighborhood).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }

    public List<VetPOJO> listVets(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetPOJO> vetPOJO = new ArrayList<>();
        for (Vet vet : vets){
            vetPOJO.add(new VetPOJO(
                    vet.getUsername().getUsername(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()
            ));
        }
        return vetPOJO;
    }

    public VetPOJO saveVet(String name, String address, String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet(name,address,neighborhood);
        Vet persistedVet = vetRepository.save(vet).get();

        entityManager.close();
        entityManagerFactory.close();

        VetPOJO vetPOJO= new VetPOJO(name,address,neighborhood);

        return vetPOJO;
    }
}
