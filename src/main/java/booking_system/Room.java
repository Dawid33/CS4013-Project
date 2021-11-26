package booking_system;

public class Room {
    public String name = "";
    public int occupancy = 0;

    public Room(String s) {
        String[] room = s.split(";");
        name = room[0];
        occupancy = Integer.valueOf(room[1]);
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
        return name + ";" + occupancy;
    }
}
