package com.vighneshspringboot.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.Set;
import java.time.OffsetTime;

@Entity
@Table(name = "users", schema = "subsHub")
public class User {

    // variable as per the users database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String email;

    // need to hash the pw
    @Column(nullable = false)
    private String password;

    // ------------------------------------------> createdAt - maybe do not need it, already handled at DB level <------------------------------------------

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subscription> subscriptions;

    // constructor
    public User(){

    }

    // Getters & Setters

    // user Id
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    // username
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    // email
    public String getEmail(){
        return username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // password
    public String getPassword(){
        return password;
    }

    public void setPassword(String email){
        this.password = password;
    }

    // ------------------------------------------> created Timestamp - may not need handled a DB level <------------------------------------------

    // Subscription
    public Set<Subscription> getSubscriptions(){
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions){
        this.subscriptions = subscriptions;
    }

}
