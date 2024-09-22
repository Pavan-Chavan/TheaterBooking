package com.theater.utils;

import com.theater.enumeration.AuditoriumTierName;
import com.theater.pojo.Auditorium;
import com.theater.pojo.AuditoriumTier;
import com.theater.pojo.Seat;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public class BookingUtility {
    public static void printAvailableSeats(Auditorium auditorium) {
        for (AuditoriumTierName auditoriumTierName: AuditoriumTierName.values()) {
            auditorium.getAuditoriumTierMap().get(auditoriumTierName).getSeats().forEach(seat -> {
                System.out.print(seat.getName() + " ");
            });
            System.out.println("");
        }
    }

    public static List<String> checkIfSeatsAraAvailable(Auditorium auditorium, List<String> wantedSeats, List<String> bookedSeatsArray) {
        wantedSeats.forEach(wantedSeat->{
            List<Seat> seats = auditorium.getAuditoriumTierMap().get(TheaterUtility.getAuditoriumTierFromSeatName(wantedSeat.charAt(0))).getSeats();
            seats.forEach(seat -> {
                if (seat.getName().equalsIgnoreCase(wantedSeat) && seat.isBooked()) {
                    bookedSeatsArray.add(seat.getName());
                }
            });
        });
        return bookedSeatsArray;
    }

    public static void bookSeats(List<String> wantedSeatsArray, Auditorium auditorium) {
        float subTotal = 0f;
        for(String wantedSeat : wantedSeatsArray) {
            AuditoriumTier auditoriumTier = auditorium.getAuditoriumTierMap().get(TheaterUtility.getAuditoriumTierFromSeatName(wantedSeat.charAt(0)));
            List<Seat> seats = auditoriumTier.getSeats();
            for(Seat seat: seats) {
                if (seat.getName().equalsIgnoreCase(wantedSeat) && !seat.isBooked()) {
                    seat.setBooked(true);
                    subTotal += auditoriumTier.getPrice();
                    auditoriumTier.setTierSales(auditoriumTier.getTierSales() + auditoriumTier.getPrice());
                }
            }
        }
        BillingUtility.printBookingDetails(auditorium,subTotal);
    }
}
