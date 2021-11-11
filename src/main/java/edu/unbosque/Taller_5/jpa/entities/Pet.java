package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Integer pet_id;

    @Column(name = "microchip", unique = true)
    private String microchip;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "species",nullable = false)
    private String species;

    @Column(name = "race",nullable = false)
    private String race;

    @Column(name = "size",nullable = false)
    private String size;

    @Column(name = "sex",nullable = false)
    private String sex;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PetCase> cases = new ArrayList<>();



    public Pet(String microchip, String name, String species,String sex, String race, String size, String picture) {
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.sex=sex;
        this.race = race;
        this.size = size;
        this.picture = picture;
    }

    public Pet(){}

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<PetCase> getCases() {
        return cases;
    }

    public void setCases(List<PetCase> cases) {
        this.cases = cases;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

