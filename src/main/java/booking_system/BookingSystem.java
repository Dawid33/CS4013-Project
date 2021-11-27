package booking_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import core.IO;

public class BookingSystem {
    public static int bookingIDCount = 0;
    ArrayList<Booking> bookings = new ArrayList<>();
    File bookingFile;

    /** 
     * @param file File object that represents the file that contains booking information as a CSV.
     * @throws IOException
     */
    public BookingSystem(File file) throws IOException{
        bookingFile = file;
        // Read file
        String fileContents = "";
        try {
            fileContents = IO.readFile(file);
        } catch (IOException e) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
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

        this.bookingIDCount = bookings.size();
    }

    
    /** 
     * @return ArrayList Get bookings in the booking system.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /** 
     * @param booking Remove booking from the booking system.
     */
    public void removeBooking(Booking b) {
        System.out.println("Removing booking");
        bookings.remove(b);
        try {
            updateBookingsToFile();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    /** 
     * @param booking A booking to add to the booking system.
     */
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    /** 
     * @param bookings Bookings to add into the booking system.
     */
    public void addAllBookings(Collection<? extends Booking> bookings) {
        this.bookings.addAll(bookings);
    }

    /** 
     * @param file Update bookings in the file represented by the file object.
     * @throws IOException
     */
    public void updateBookingsToFile() throws IOException {
        bookingFile.delete();
        bookingFile.createNewFile();
        FileWriter writer = new FileWriter(bookingFile);
        for(Booking b : bookings) {
            writer.append(b.toString() + "\n");
        }
        writer.close();
    }

    /**
     * Print all bookings for debug purposes.
     */
    public void printBookings() {
        for(Booking b : bookings) {
            System.out.println(b.toString());
        }
    }
}
