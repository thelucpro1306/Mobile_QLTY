package com.example.qlty.Model;


import java.time.LocalDate;
import java.util.Date;

public class MEF {
    public long Id;
    public Date BookingDate;
    public long ServicesId;
    public long ClientID;
    public String Name;

    public MEF(long id, Date bookingDate, long servicesId, long clientID, String name) {
        Id = id;
        BookingDate = bookingDate;
        ServicesId = servicesId;
        ClientID = clientID;
        Name = name;
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

    public MEF() {
    }

    @Override
    public String toString() {
        return "MEF{" +
                "Id=" + Id +
                ", BookingDate=" + BookingDate +
                ", ServicesId=" + ServicesId +
                ", ClientID=" + ClientID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
