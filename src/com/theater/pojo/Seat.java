package com.theater.pojo;

public class Seat {
    private String name;
    private boolean isBooked;

    public Seat(String name, boolean isBooked) {
        this.name = name;
        this.isBooked = isBooked;
    }

    public Seat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
