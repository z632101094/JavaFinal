package com.example.javafinal.bean;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "reservation", catalog = "")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "username", nullable = false, length = 128)
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 128)
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
