package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository{

    private EntityManager entityManager;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Pet> findByPetId(Integer pet_id) {
        Pet pet = entityManager.find(Pet.class,pet_id);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findByName(String name) {
        Pet pet = entityManager.find(Pet.class,name);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findBySpecies(String species) {
        Pet pet = entityManager.find(Pet.class,species);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findByRace(String race) {
        Pet pet = entityManager.find(Pet.class,race);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findBySize(String size) {
        Pet pet = entityManager.find(Pet.class,size);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findBySex(String sex) {
        Pet pet = entityManager.find(Pet.class,sex);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findByOwner(Integer owner_id) {
        Pet pet = entityManager.find(Pet.class,owner_id);
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public List<Pet> findAll() {return entityManager.createQuery("from Pet ").getResultList();
    }


    @Override
    public Optional<Pet> save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> editNameByPetId(Integer pet_id, String name) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  name = :name  WHERE pet_id = :pet_id")
                .setParameter("name",name)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> editSpecieByPetId(Integer pet_id, String specie) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  species = :specie  WHERE pet_id = :pet_id")
                .setParameter("specie",pet_id)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> editRaceByPetId(Integer pet_id, String race) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  race = :race  WHERE pet_id = :pet_id")
                .setParameter("race",race)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> editSizeByPetId(Integer pet_id, String size) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  size = :size  WHERE pet_id = :pet_id")
                .setParameter("size",size)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> editSexByPetId(Integer pet_id, String sex) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  sex = :sex  WHERE pet_id = :pet_id")
                .setParameter("sex",sex)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> editPictureByPetId(Integer pet_id, String picture) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet   SET  picture = :picture  WHERE pet_id = :pet_id")
                .setParameter("picture",picture)
                .setParameter("pet_id",pet_id)
                .getSingleResult();
        return pet!=null ? Optional.of(pet) : Optional.empty();
    }


}
