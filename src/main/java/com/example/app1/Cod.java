package com.example.app1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Коды")
public class Cod {
    @Id
    @Column(name = "Номер телефона")
    private String phone;
    @Column(name = "Регистрационный код")
    private int code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
