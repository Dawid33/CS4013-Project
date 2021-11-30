package booking_system;
import java.time.LocalDate;
import java.util.ArrayList;

import core.Program;

public class Booking {
    public String email = null;
    public String name = null;
    public LocalDate checkInDate = null;
    public LocalDate checkOutDate = null;
    public LocalDate creationDate = LocalDate.now();
    public boolean isApPurchase = false;
    public int numberOfRooms = 0;
    public int totalCost = 0;
    ArrayList<Room> rooms = new ArrayList<>();

    public String getTotalProfit() {return "hello";}

    /** 
     * @return String Get the email fo the client who booked this booking.
     */
    public String getEmail() { return email; }
    
    /**
     * @return String Get the name of the client who booked this booking.
     */
    public String getName() { return name; }
    
    /** 
     * @return LocalDate Get the checkin date of the booking
     */
    public LocalDate getCheckInDate() { return checkInDate; }
    
    /** 
     * @return LocalDate Get the checkout date of the booking.
     */
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public LocalDate getCreationDate() { return creationDate; }
    
    /** 
     * @return String Returns "Yes" if the booking is an advanced purchase, "No" if it is not.
     */
    public String getIsApPurchase() {
        if (isApPurchase){
            totalCost *= 0.95;      //advance purchase 5% off;
            return "Yes";
        }else{
            return "No";  
        }      
    }
    
    /** 
     * @return int Gets the number of rooms booked by this booking.
     */
    public int getNumberOfRooms() { return numberOfRooms; }
    
    /** 
     * @return int Gets the total cost of the booking
     */
    public int getTotalCost() { return totalCost; }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /** 
     * @param room Add room to the booking.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    
    
    /** 
     * @return String Print the Booking as a string for debug purposes.
     */
    public String toString() {
        return this.toCSV().toString();
    }
 
    /** 
     * @return CSV Create a CSV object from the booking.
     */
    public CSV toCSV() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ",");
        builder.append(email + ",");
        builder.append(checkInDate.format(Program.formatter) + ",");
        builder.append(checkOutDate.format(Program.formatter) +  ",");
        builder.append(creationDate.format(Program.formatter) +  ",");
        builder.append(isApPurchase + ",");
        builder.append(numberOfRooms + ",");
        builder.append(totalCost);
        for(Room room : rooms) {
            builder.append("," + room.toCSV());
        }
        builder.append("\n");
        return new CSV(builder.toString());
    }

    
    /** 
     * @param csv CSV object to convert into booking.
     * @throws Exception Exception if the conversion failed.
     */
    public void fromCSV(CSV csv) throws Exception {
        java.lang.reflect.Field[] allFields = this.getClass().getFields();
        int i = 0;
        ArrayList<String> list = csv.toArray();
        if (list.size() < allFields.length) {
            throw new Exception("Not enough items in CSV populate booking object.");
        }
        for(String s : list) {
            if (i < allFields.length){
                try {
                    if (allFields[i].getType() == int.class) {
                        Integer x = Integer.valueOf(s);
                        allFields[i].set(this, x.intValue());
                    } else if (allFields[i].getType() == boolean.class) {
                        Boolean b = Boolean.valueOf(s);
                        allFields[i].set(this, b);
                    } else if (allFields[i].getType() == LocalDate.class) {
                        LocalDate date = LocalDate.parse(s, Program.formatter);
                        
                        allFields[i].set(this, date);
                    } else if (allFields[i].getType() == String.class) {
                        allFields[i].set(this, s);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }   
                i++;
            } else { //Finished parsing fields, now parsing rooms.
                rooms.add(new Room(s));
            }
        }
        numberOfRooms = rooms.size();
    }
}