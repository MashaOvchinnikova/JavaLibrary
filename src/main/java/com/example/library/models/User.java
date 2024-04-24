package com.example.library.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="table_users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id")) @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    private String Name;
    private String HashedPassword;
    private boolean isActive;

    public User(String name, String password) {
        this.Name = name;
        this.HashedPassword = password;
    }

    public String getUsername() {
        return this.Name;
    }
    public String getHashedPassword() {return this.HashedPassword;}
    public Set<Role> getRoles() {
        return this.roles;
    }
    public void setRoles(Set<Role> singleton) {
        this.roles = singleton;
    }
    public void setActive(boolean active) {
        this.isActive = active;
    }
    public boolean isActive() {
        return isActive;
    }
}
