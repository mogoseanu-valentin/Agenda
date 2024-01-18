package com.example.agendaelectronica;

public class Contact {
    private String name;
    private String address;
    private int imageResourceId; // Resource ID for the image

    public Contact(String name, String address, int imageResourceId) {
        this.name = name;
        this.address = address;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
