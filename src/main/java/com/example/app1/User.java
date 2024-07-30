package com.example.app1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;


@Entity(name = "Пользователи")
public class User {
    @Column(name = "Имя")
    private String name;
    @Column(name = "Фамилия")
    private String surname;
    @Id
    @Column(name = "Номер телефона")
    private String phone;
    @Column(name = "Направление")
    private String direction;
    @Column(name = "Дата получения заявки")
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    private Timestamp date;
    @Column(name = "Регистрационный код")
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }



}
