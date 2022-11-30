package com.example.by.minevich.dto;

public class IdBookingRequest {
    private Long id;
    private boolean booking;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public boolean isBooking() {
        return booking;
    }

    public void setBooking(boolean booking) {
        this.booking = booking;
    }
}
