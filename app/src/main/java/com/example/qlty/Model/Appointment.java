package com.example.qlty.Model;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private long Id;
    private Date BookingDate;
    private long ServicesId;
    private String Note;
    private long ClientID;
    private String Name;
    private String Phone;
    private String Email;

    public Appointment() {
    }

    public Appointment(Date bookingDate, long servicesId, String note, long clientID, String name, String phone, String email) {
        BookingDate = bookingDate;
        ServicesId = servicesId;
        Note = note;
        ClientID = clientID;
        Name = name;
        Phone = phone;
        Email = email;
    }

    public Appointment(long id, Date bookingDate, long servicesId, String note, long clientID, String name, String phone, String email) {
        Id = id;
        BookingDate = bookingDate;
        ServicesId = servicesId;
        Note = note;
        ClientID = clientID;
        Name = name;
        Phone = phone;
        Email = email;
    }

    @Override
    public String toString() {
        return "Apointment{" +
                ", BookingDate='" + BookingDate + '\'' +
                ", ServicesId=" + ServicesId +
                ", Note='" + Note + '\'' +
                ", ClientID=" + ClientID +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public long getServicesId() {
        return ServicesId;
    }

    public void setServicesId(long servicesId) {
        ServicesId = servicesId;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public long getClientID() {
        return ClientID;
    }

    public void setClientID(long clientID) {
        ClientID = clientID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
