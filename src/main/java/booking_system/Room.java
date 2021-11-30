package booking_system;

import java.util.ArrayList;

import javafx.beans.binding.IntegerExpression;

public class Room {
    public String hotelType = "";
    public String name = "";
    public int occupancy = 0;

    // the number of room available in each type of rooms in 5 star hotel
    public int[] noOfRooms_5 = new int[4]; // e.g {35,25,10,10}
    public int[] noOfRooms_4 = new int[3];
    public int[] noOfRooms_3 = new int[3];

    public Room(String s) {
        String[] room = s.split(";");
        hotelType = room[0];
        name = room[1];
        occupancy = Integer.valueOf(room[2]);
    }

    public String getName() {
        return name;
    }

    public int getOccupancy() {
        return occupancy;
    }

    /** check if the number of required room is available */
    public String CheckAvailability(int numOfRoom){
        if(hotelType.equals("5 star")){
            if(name.toLowerCase().equals("deluxe double")){
                if(numOfRoom < noOfRooms_5[0]){
                    noOfRooms_5[0] -= numOfRoom;
                    return "The number of room you required are available";
                }
            }else if(name.toLowerCase().equals("deluxe Twin")){
                if(numOfRoom < noOfRooms_5[1]){
                    noOfRooms_5[1] -= numOfRoom;
                    returnF"The number of room you required are available";
                }
            }else if(name.toLowerCase().equals("deluxe Single")){
                if(numOfRoom < noOfRooms_5[2]){
                    noOfRooms_5[2] -= numOfRoom;
                    returnF"The number of room you required are available";
                }
            }else if(name.toLowerCase().equals("deluxe Family")){
                if(numOfRoom < noOfRooms_5[2]){
                    noOfRooms_5[2] -= numOfRoom;
                    returnF"The number of room you required are available";
                }
            }

        }else if(hotelType.equals("4 star")){
            if(name.toLowerCase().equals("Executive double")){
                if(numOfRoom < noOfRooms_4[0]){
                    noOfRooms_4[0] -= numOfRoom;
                    return "The room you require is available";
                }
            }else if(name.toLowerCase().equals("Excutive Twin")){
                if(numOfRoom < noOfRooms_4[1]){
                    noOfRooms_4[1] -= numOfRoom;
                    return "The room you require is available";
                }
            }else if(name.toLowerCase().equals("Executive Single")){
                if(numOfRoom < noOfRooms_4[2]){
                    noOfRooms_4[2] -= numOfRoom;
                    return "The room you require is available";
                }
            }
        }else if(hotelType.equals("3 star")){
            if(name.toLowerCase().equals("Executive double")){
                if(numOfRoom < noOfRooms_3[0]){
                    noOfRooms_3[0] -= numOfRoom;
                    return "The number of room you required are available";;
                    }
                }else if(name.toLowerCase().equals("Excutive Twin")){
                    if(numOfRoom < noOfRooms_3[1]){
                        noOfRooms_3[1] -= numOfRoom;
                        return "The number of room you required are available";
                    }
                }else if(name.toLowerCase().equals("Executive Single")){
                    if(numOfRoom < noOfRooms_3[2]){
                        noOfRooms_3[2] -= numOfRoom;
                        return "The number of room you required are available";
                    }
                }else{
                    return "The number of required rooms are not available";
                }
            }
        }
            
        
        }
    

    /**
     * @return String Get the string representation for the room.
     */
    public String toString() {
        return hotelType + ", " + name + ", " + occupancy;
    }

    public String toCSV() {
        return hotelType + ";" + name + ";" + occupancy;
    }
}
