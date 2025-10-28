package com.vighneshspringboot.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "users", schema = "subshub")
public class User {

    // variable as per the users database
    @Id
    @Column(nullable = false, updatable = false)
    private String  id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String email;

    // ------------------------------------------> createdAt - maybe do not need it, already handled at DB level <------------------------------------------

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Subscription> subscriptions;

    // constructor
    public User(){

    }

    public User(String keycloakUserId, String username, String email) {
        this.id = keycloakUserId; // No more Long.valueOf()
        this.username = username;
        this.email = email;
    }

    // Getters & Setters

    // user Id
    public String getId(){
        return id;
    }

    public void setId(String id){
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
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // ------------------------------------------> created Timestamp - may not need handled a DB level <------------------------------------------

    // Subscription
//    public Set<Subscription> getSubscriptions(){
//        return subscriptions;
//    }

//    public void setSubscriptions(Set<Subscription> subscriptions){
//        this.subscriptions = subscriptions;
//    }
}
