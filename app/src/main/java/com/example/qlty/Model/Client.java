package com.example.qlty.Model;

import java.io.Serializable;

public class Client implements Serializable {
    private  long id;
    private  String Name ;
    private  String Address;
    private  String email ;
    private  String Phone ;
    private long UserId;

    public Client() {
    }

    public Client(long id, String name, String address, String email, String phone, long userId) {
        this.id = id;
        Name = name;
        Address = address;
        this.email = email;
        Phone = phone;
        UserId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", UserId=" + UserId +
                '}';
    }
}
