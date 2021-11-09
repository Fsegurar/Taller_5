package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vet")
public class Vet implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "neighborhood",nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "vet_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();

    public Vet(){}

    public Vet(String name, String address, String neighborhood){
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

}