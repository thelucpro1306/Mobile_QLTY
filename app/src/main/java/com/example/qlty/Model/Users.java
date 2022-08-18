package com.example.qlty.Model;

import java.io.Serializable;

public class Users implements Serializable {
    private long ID ;
    private String UserName;
    private String Password;
    private String Email;
    private String Phone;

    public Users() {
    }

    public Users(long ID, String userName, String password, String email, String phone) {
        this.ID = ID;
        UserName = userName;
        Password = password;
        Email = email;
        Phone = phone;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "ID=" + ID +
                ", UserName=" + UserName +
                ", Password=" + Password +
                ", Email=" + Email +
                ", Phone=" + Phone +
                '}';
    }
}
