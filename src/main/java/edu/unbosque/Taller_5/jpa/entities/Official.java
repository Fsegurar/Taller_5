package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Official")
public class Official implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;

    @Column(name = "name",nullable = false)
    private String name;

    public Official(){}

    public Official(String name){
        this.name = name;
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
}