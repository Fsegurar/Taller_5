package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Visit")
public class Visit implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "visit_id",nullable = false)
    private Integer visit_id;

    @Column(name = "created_at",nullable = false)
    private String created_at;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "description",nullable = false)
    private String description;


    @ManyToOne
    @JoinColumn(name = "pet_id",referencedColumnName = "pet_id",unique = true)
    private Pet pet_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name",unique = true)
    private Vet vet_id;

    //Falta constructor
    public Visit(){}

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVet_id() {
        return vet_id;
    }

    public void setVet_id(Vet vet) {
        this.vet_id = vet;
    }

    public Pet getPet_id() {
        return pet_id;
    }

    public void setPet_id(Pet pet) {
        this.pet_id = pet;
    }
}


