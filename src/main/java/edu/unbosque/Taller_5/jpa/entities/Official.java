package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Official")
public class Official implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp username;

    @Column(name = "name",nullable = false)
    private String name;



    public Official(String name){
        this.name = name;
    }

    public Official() {

    }

    public UserApp getUsername() {
        return username;
    }

    public void setUsername(UserApp userapp) {
        this.username = userapp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}