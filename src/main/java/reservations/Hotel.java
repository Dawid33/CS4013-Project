package reservations;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Hotel {
    private String hotelType;
    private int[] numRooms;
    private ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(String s) {
        StringTokenizer t = new StringTokenizer(s, ",");
        Room r = new Room();
        int[] rates = new int[7];

        this.hotelType = t.nextToken();
        r.setType(t.nextToken());
        numRooms[0] = Integer.parseInt(t.nextToken());
        r.setOccupancyMin(Integer.parseInt(t.nextToken()));
        r.setOccupancyMax(Integer.parseInt(t.nextToken()));

        for (int i = 0; i < rates.length; i++) {
            rates[i] = Integer.parseInt(t.nextToken());
        }

        r.setRates(rates);

        for (int i = 0; i < numRooms[0]; i++) {
            rooms.add(r);
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

    public int getNumRooms(int index) {
        return numRooms[index];
    }

    public void addRooms(int num, String str) {
        Room r = new Room();
        StringTokenizer t = new StringTokenizer(str, ",");
        String s = "";
        int[] rates = new int[7];

        s = t.nextToken();
        r.setType(t.nextToken());
        numRooms[num] = Integer.parseInt(t.nextToken());
        r.setOccupancyMin(Integer.parseInt(t.nextToken()));
        r.setOccupancyMax(Integer.parseInt(t.nextToken()));

        for (int i = 0; i < rates.length; i++) {
            rates[i] = Integer.parseInt(t.nextToken());
        }

        r.setRates(rates);

        for (int i = 0; i < numRooms[num]; i++) {
            rooms.add(r);
        }

    }

}
