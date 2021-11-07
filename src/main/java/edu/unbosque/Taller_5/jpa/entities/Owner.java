package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Owner")
public class Owner implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;

    @GeneratedValue
    @Column(nullable = false, unique = true, name = "person_id")
    private Integer person_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "neighborhood",nullable = false)
    private String neighborhood;



    //Falta constructor

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
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