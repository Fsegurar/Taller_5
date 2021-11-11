package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Owner;
import edu.unbosque.Taller_5.jpa.repositories.OwnerRepository;
import edu.unbosque.Taller_5.jpa.repositories.OwnerRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.OwnerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;

    public OwnerPOJO editNameByUsername(String username,String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.editNameByUsername(username,name).get();
        List<Owner> users = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();
        OwnerPOJO ownerPOJO = new OwnerPOJO();
        for (Owner user : users) {
            if (user.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(user.getUsername().getUsername(),user.getPerson_id(),user.getName(),user.getAddress(),user.getNeighborhood());
            }
        }

        return ownerPOJO;
    }
    public OwnerPOJO editAddressByUsername(String username,String address){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.editAddressByUsername(username,address).get();
        List<Owner> users = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();
        OwnerPOJO ownerPOJO = new OwnerPOJO();
        for (Owner user : users) {
            if (user.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(user.getUsername().getUsername(),user.getPerson_id(),user.getName(),user.getAddress(),user.getNeighborhood());
            }
        }

        return ownerPOJO;
    }
    public OwnerPOJO editNeighborhoodByUsername(String username,String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.editNeighborhoodByUsername(username,neighborhood).get();

        List<Owner> users = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();
        OwnerPOJO ownerPOJO = new OwnerPOJO();
        for (Owner user : users) {
            if (user.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(user.getUsername().getUsername(),user.getPerson_id(),user.getName(),user.getAddress(),user.getNeighborhood());
            }
        }

        return ownerPOJO;

    }

    public Owner findByOwnerId(Integer owner_id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.findByOwnerId(owner_id).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    public Owner findByName(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.findByName(name).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    public Owner findByAddress(String address){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.findByAddress(address).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    public Owner findByNeighborhood(String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner persistedOwner = ownerRepository.findByNeighborhood(neighborhood).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    public List<OwnerPOJO> listOwners(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownerPOJO = new ArrayList<>();
        for (Owner owner : owners){
            ownerPOJO.add(new OwnerPOJO(
                    owner.getUsername().getUsername(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()
            ));
        }
        return ownerPOJO;
    }

    public Owner saveOwner(String name, String address, String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller_5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(name,address,neighborhood);
        Owner persistedOwner = ownerRepository.save(owner).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }
}
