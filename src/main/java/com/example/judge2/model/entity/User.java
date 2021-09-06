package com.example.judge2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String git;
    private Role role;

    @Column(name = "username", nullable = false, unique = true)
    public String getUsername () {
        return this.username;
    }

    public User setUsername (String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword () {
        return this.password;
    }

    public User setPassword (String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail () {
        return this.email;
    }

    public User setEmail (String email) {
        this.email = email;
        return this;
    }

    @Column(name = "git")
    public String getGit () {
        return this.git;
    }

    public User setGit (String git) {
        this.git = git;
        return this;
    }

    @ManyToOne
    public Role getRole () {
        return this.role;
    }

    public User setRole (Role role) {
        this.role = role;
        return this;
    }

    public User () {
    }
}
