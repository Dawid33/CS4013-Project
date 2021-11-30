package analytics;

import java.util.ArrayList;

import booking_system.Booking;
import booking_system.BookingSystem;

public class Analytics {

    public static Integer getTotalProfit(ArrayList<Booking> bookings) {
        Integer totalProfit = 0;
        for (Booking b : bookings) {
            totalProfit += b.totalCost;
        }
        return totalProfit;
    }

    public static Integer getProfitAverage(ArrayList<Booking> bookings) {
        Integer profitAverage = getTotalProfit(bookings) / bookings.size();
        return profitAverage;
    } 
}
//