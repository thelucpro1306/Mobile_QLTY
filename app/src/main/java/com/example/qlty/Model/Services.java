package com.example.qlty.Model;

public class Services {
    private long id;
    private String Name;
    private String Description;

    public Services() {
    }

    public Services(long id, String name, String description) {
        this.id = id;
        Name = name;
        Description = description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Services(long id, String name) {
        this.id = id;
        Name = name;
    }
}
