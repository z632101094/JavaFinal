package com.example.javafinal.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calendar", schema = "reservation", catalog = "")
public class CalendarEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    public CalendarEntity(Date date, String name, String password) {
        this.date = date;
        this.name = name;
        this.password = password;
    }
    public CalendarEntity() {}
    @Basic
    @Column(name = "date", nullable = false, unique = true)
    private Date date;
    @Basic
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Basic
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



