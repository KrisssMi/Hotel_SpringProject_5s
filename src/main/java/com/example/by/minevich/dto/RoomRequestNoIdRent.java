package com.example.by.minevich.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RoomRequestNoIdRent {
    private String name;
    private String description;
    private int capacity;
    private int cost;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
