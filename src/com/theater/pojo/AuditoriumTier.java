package com.theater.pojo;

import com.theater.enumeration.AuditoriumTierName;

import java.util.ArrayList;
import java.util.List;

public class AuditoriumTier {
    private AuditoriumTierName auditoriumTierName;
    private float price;
    private float tierSales = 0;
    List<Seat> seats = new ArrayList<>();

    public AuditoriumTier () {

    }

    public float getTierSales() {
        return tierSales;
    }

    public void setTierSales(float tierSales) {
        this.tierSales = tierSales;
    }

    public AuditoriumTier(AuditoriumTierName auditoriumTierName, float price, List<Seat> seats) {
        this.auditoriumTierName = auditoriumTierName;
        this.price = price;
        this.seats = seats;
    }

    public AuditoriumTierName getAuditoriumTierName() {
        return auditoriumTierName;
    }

    public void setAuditoriumTierName(AuditoriumTierName auditoriumTierName) {
        this.auditoriumTierName = auditoriumTierName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
