package reservations;

public class Room {
    private String type;
    private int occupancyMin;
    private int occupancyMax;
    private int[] rates = new int[7];

    public Room(String type, int occupancyMin, int occupancyMax, int[] rates) {
        this.type = type;
        this.occupancyMin = occupancyMin;
        this.occupancyMax = occupancyMax;
        this.rates = rates;
    }

    
    /** 
     * Returns room type
     * @return String
     */
    public String getType() {
        return this.type;
    }

    
    /** 
     * Returns the minimum occupancy for the room
     * @return int
     */
    public int getOccupancyMin() {
        return this.occupancyMin;
    }

    
    /** 
     * Returns the maximum occupancy for the room
     * @return int
     */
    public int getOccupancyMax() {
        return this.occupancyMax;
    }

    
    /** 
     * Returns the rates per night of the room as an array
     * @return int[]
     */
    public int[] getRates() {
        return this.rates;
    }
}
