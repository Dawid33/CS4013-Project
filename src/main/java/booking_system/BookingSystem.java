package booking_system;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import core.IO;

public class BookingSystem {
    ArrayList<Booking> bookings = new ArrayList<>();

    public BookingSystem() {

    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void removeBooking(Booking booking) {
        
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void addAllBookings(Collection<? extends Booking> bookings) {
        this.bookings.addAll(bookings);
    }

    public void getBookingsFromFile(File file) throws IOException{
        // Read file
        String fileContents = IO.readFile(file);
        // The fileContents variable contains the entire file as one long String
        // Loop over each line of the file by splitting it up at every new line character.
        for(String line : fileContents.split("\n")) {
            // Create csv object from the current line
            CSV rawBooking = new CSV(line);
            Booking booking = new Booking();
            try {
                // Populate booking with data from csv
                booking.fromCSV(rawBooking);
            } catch (Exception e) {
                System.out.println("Cannot parse csv file into booking object : " + e.getMessage());
                // If an exception occurs, booking is empty so we move on to the next booking.
                continue;
            }
            bookings.add(booking);
        }
    }

    public void updateBookingsInFile(File file) throws IOException {
        //FileWriter writer = new FileWriter(file);
    }

    public void printBookings() {
        for(Booking b : bookings) {
            System.out.println(b.toString());
        }
    }
}
