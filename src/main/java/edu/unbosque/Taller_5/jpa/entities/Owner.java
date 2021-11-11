package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp username;

    @GeneratedValue
    @Column(nullable = false, unique = true, name = "person_id")
    private Integer person_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "neighborhood",nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner() {

    }

    public Owner( String name, String address, String neighborhood) {
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public UserApp getUsername() {
        return username;
    }

    public void setUsername(UserApp userapp) {
        this.username = userapp;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}