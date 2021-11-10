package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Userapp")
@NamedQueries({
        @NamedQuery(name = "UserApp.findByUserName",
        query = "SELECT a FROM UserApp a WHERE  a.username= :username")
})
public class UserApp {

    @Id
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "role",nullable = false)
    private String role;

    @OneToOne(mappedBy = "userapp")
    private Official official;

    @OneToOne(mappedBy = "userapp")
    private Owner owner;

    @OneToOne(mappedBy = "userapp")
    private Vet vet;

    public UserApp(){}

    public UserApp(String username, String password, String email, String role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
