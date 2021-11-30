package booking_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import core.IO;

public class BookingSystem {
    ArrayList<Booking> bookings = new ArrayList<>();
    ArrayList<Booking> bookingsArchive = new ArrayList<>();
    File bookingFile;
    File bookingArchive;

    /** 
     * @param bookingFile File object that represents the file that contains booking information as a CSV.
     * @param bookingArchive File object that represents the file that contains booking archive information as a CSV.
     * @throws IOException
     */
    public BookingSystem(File bookingFile, File bookingArchive) throws IOException{
        this.bookingFile = bookingFile;
        this.bookingArchive = bookingArchive;
        bookings = readFileIntoArray(bookingFile);
        bookingsArchive = readFileIntoArray(bookingArchive);
    }

    private ArrayList<Booking> readFileIntoArray(File file) throws IOException{
        ArrayList<Booking> bookings = new ArrayList<>();
        // Read file
        String fileContents = "";
        try {
            System.out.println(file.getAbsolutePath());
            fileContents = IO.readFile(file);
        } catch (IOException e) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    throw e2;
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
        return bookings;
    }

    
    /** 
     * @return ArrayList Get bookings in the booking system.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    
    public ArrayList<Booking> getBookingsArchives() {
        return bookingsArchive;
    }

    /** 
     * @param booking Remove booking from the booking system.
     */
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        bookingsArchive.add(booking);
        try {
            updateArchiveToFile();
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

    public void updateArchiveToFile() throws IOException{
        bookingArchive.delete();
        bookingArchive.createNewFile();
        FileWriter writer = new FileWriter(bookingArchive);
        for(Booking b : bookingsArchive) {
            writer.append(b.toString());
        }
        writer.close();
    }

    public void purgeOldBookingsFromArchive() throws IOException{
        ArrayList<Booking> toDelete = new ArrayList<>();
        for(Booking b : bookingsArchive) {
            if (b.creationDate.isBefore(b.checkInDate.minusYears(7))) {
                toDelete.add(b);
            }
        }
        if(!toDelete.isEmpty()) {
            System.out.print("Has updated archive");
            bookingsArchive.removeAll(toDelete);
            updateArchiveToFile();
        }
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
