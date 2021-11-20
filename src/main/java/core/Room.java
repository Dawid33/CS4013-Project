package core;

public class Room {
    public String roomType = "";
    public int occupancy = 0;

    public Room(String s) {
        String[] data = s.split(";");
        roomType = data[0];
        occupancy = Integer.valueOf(data[1]);
    }

    public String toString() {
        return roomType + ";" + occupancy;
    }
}
