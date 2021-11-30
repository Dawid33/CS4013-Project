package booking_system;

public class Room {
    public String hotelType = "";
    public String name = "";
    public int occupancy = 0;

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
