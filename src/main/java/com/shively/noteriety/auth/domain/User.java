package com.shively.noteriety.auth.domain;

import com.google.common.base.Objects;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Size(max = 64)
//    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;

    public User() {}

    public User(final Long id, final String username, final String password, final String fname,
                final String lname, final String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("password", password)
                .toString();
    }
}
