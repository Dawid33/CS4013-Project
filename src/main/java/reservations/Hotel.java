package reservations;

import java.util.ArrayList;

public class Hotel {
    private String hotelType;
    private ArrayList<Room> roomType = new ArrayList<>();
    private int[] numRooms;
    private ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(String s) {
        this.hotelType = hotelType;
        this.roomType = roomType;
        this.numRooms = numRooms;

        for (int i = 0; i < numRooms.length; i++) {
            for (int j = 0; j < numRooms[i]; j++) {
                rooms.add(roomType.get(i));
            }
        }
    }

    
    /** 
     * Returns the name of the hotel
     * @return String
     */
    public String getHotelType() {
        return hotelType;
    }

    
    /** 
     * Returns the rooms in the hotel as an ArrayList
     * @return ArrayList<Room>
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

}
