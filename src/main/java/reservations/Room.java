package reservations;

import java.util.StringTokenizer;

public class Room {
    private String type;
    private int occupancyMin;
    private int occupancyMax;
    private int[] rates = new int[7];
    
    /** 
     * Returns room type
     * @return String
     */
    public String getType() {
        return this.type;
    }

    public void setType(String s) {
        this.type = s;
    }

    
    /** 
     * Returns the minimum occupancy for the room
     * @return int
     */
    public int getOccupancyMin() {
        return this.occupancyMin;
    }

    public void setOccupancyMin(int i) {
        this.occupancyMin = i;
    }

    
    /** 
     * Returns the maximum occupancy for the room
     * @return int
     */
    public int getOccupancyMax() {
        return this.occupancyMax;
    }

    public void setOccupancyMax(int i) {
        this.occupancyMax = i;
    }

    
    /** 
     * Returns the rates per night of the room as an array
     * @return int[]
     */
    public int[] getRates() {
        return this.rates;
    }

    public void setRates(int[] rates) {
        this.rates = rates;
    }
}
