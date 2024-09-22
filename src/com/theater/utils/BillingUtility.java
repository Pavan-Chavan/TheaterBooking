package com.theater.utils;

import com.theater.enumeration.AuditoriumName;
import com.theater.enumeration.AuditoriumTierName;
import com.theater.pojo.Auditorium;
import com.theater.pojo.Theater;

public class BillingUtility {
    public static void printBookingDetails(Auditorium auditorium, float subTotal){
        System.out.println("Successfully booked - " + auditorium.getShowName());
        System.out.println("Subtoal : Rs. " + subTotal);
        System.out.println("Service Tax @14%: Rs. " + Utility.humanReadable((float) (subTotal*0.14)));
        System.out.println("Swachh Bharat Cess @0.5%: Rs. " +  Utility.humanReadable((float) (subTotal*0.05)));
        System.out.println("Krishi Kalyan Cess @0.5%: Rs. " +  Utility.humanReadable((float) (subTotal*0.05)));
        System.out.println("Total Rs. " + Utility.humanReadable ((float) (subTotal + (subTotal * 0.14) + ((subTotal * 0.05)*2))));
    }

    public static void printSalesDetails(Theater theater) {
        float totalSales=0;
        for (AuditoriumName auditoriumName: AuditoriumName.values()) {
            Auditorium auditorium = theater.getAuditoriumMap().get(auditoriumName);
            for (AuditoriumTierName auditoriumTierName: AuditoriumTierName.values()) {
                totalSales += auditorium.getAuditoriumTierMap().get(auditoriumTierName).getTierSales();
            }
        }
        System.out.println("Revenue : Rs. " + totalSales);
        System.out.println("Service Tax Rs. " + Utility.humanReadable((float) (totalSales*0.14)));
        System.out.println("Swachh Bharat Rs. " +  Utility.humanReadable((float) (totalSales*0.05)));
        System.out.println("Krishi Kalyan Rs. " +  Utility.humanReadable((float) (totalSales*0.05)));
    }
}
