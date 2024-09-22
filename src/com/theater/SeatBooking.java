package com.theater;

import com.theater.pojo.Auditorium;
import com.theater.pojo.Theater;
import com.theater.utils.BillingUtility;
import com.theater.utils.BookingUtility;
import com.theater.utils.TheaterUtility;

import java.util.*;

public class SeatBooking {

    SeatBooking () {

    }
    public static void main(String[] args) {
        Theater theater = TheaterUtility.createTheater();
        Scanner scanner = new Scanner(System.in);
        String toBeContinue = "Yes";
        int auditoriumNo;
        List<String> wantedSeatsArray = new ArrayList<>();
        List<String> bookedSeatsArray;
        String wantedSeats = "";

       try {
           while (toBeContinue.equalsIgnoreCase("Yes")) {
               bookedSeatsArray = new ArrayList<>();
               System.out.print("Enter Show No : ");
               auditoriumNo = scanner.nextInt();
               Auditorium auditorium = theater.getAuditoriumMap().get(TheaterUtility.getAuditorium(auditoriumNo));
               BookingUtility.printAvailableSeats(auditorium);

               System.out.print("Enter seats :");
               wantedSeats = scanner.next();
               wantedSeatsArray = Arrays.asList(wantedSeats.split("\\s*,\\s*"));
               bookedSeatsArray = BookingUtility.checkIfSeatsAraAvailable(auditorium,wantedSeatsArray,bookedSeatsArray);
               if (bookedSeatsArray.isEmpty()) {
                   System.out.println("seats are available");
                   BookingUtility.bookSeats(wantedSeatsArray,auditorium);
               } else {
                   bookedSeatsArray.forEach(seatName -> {
                       System.out.print(seatName + " ");
                   });
                   System.out.println("Not Available, Please select different seats");
               }
               System.out.print("Would you like to continue (Yes/No) :");
               toBeContinue = scanner.next();
           }
           BillingUtility.printSalesDetails(theater);
       } catch (InputMismatchException e) {
           System.out.println("Please Enter Correct Input");
       }
    }
}
