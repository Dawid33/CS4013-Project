
import java.util.ArrayList;



public class Room {
    public String hotelType = "";
    public String name = "";
    public int occupancy = 0;

    public static ArrayList<Integer> five_star_RTP = new ArrayList<>();  //price of different room in 5 star hotel;
    public static ArrayList<Integer> four_star_RTP = new ArrayList<>();       //price of different room in 4 star hotel;
    public static ArrayList<Integer> three_star_RTP = new ArrayList<>();      ////price of different room in 3 star hotel;

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

    public String getHotelType(){
        return hotelType;
    }

    /** check if the number of required room is available */
    public String CheckAvailability(int numOfRoom){
        if(hotelType.equals("5 star")){
            if(name.toLowerCase().equals("deluxe double")){
                if(numOfRoom < noOfRooms_5[0]){
                    noOfRooms_5[0] -= numOfRoom;
                    return "The number of room you required are available";
                }else{
                    return "The number of required rooms are not available";
                }
            }else if(name.toLowerCase().equals("deluxe Twin")){
                if(numOfRoom < noOfRooms_5[1]){
                    noOfRooms_5[1] -= numOfRoom;
                    return "The number of room you required are available";
                }else{
                    return "The number of required rooms are not available";
                }
            }else if(name.toLowerCase().equals("deluxe Single")){
                if(numOfRoom < noOfRooms_5[2]){
                    noOfRooms_5[2] -= numOfRoom;
                    return "The number of room you required are available";
                }else{
                    return "The number of required rooms are not available";
                }
            }else if(name.toLowerCase().equals("deluxe Family")){
                if(numOfRoom < noOfRooms_5[2]){
                    noOfRooms_5[2] -= numOfRoom;
                    return "The number of room you required are available";
                }else{
                    return "The number of required rooms are not available";
                }
            }

        }else if(hotelType.equals("4 star")){
            if(name.toLowerCase().equals("Executive double")){
                if(numOfRoom < noOfRooms_4[0]){
                    noOfRooms_4[0] -= numOfRoom;
                    return "The room you require is available";
                }else{
                    return "The number of required rooms are not available";
                }
            }else if(name.toLowerCase().equals("Excutive Twin")){
                if(numOfRoom < noOfRooms_4[1]){
                    noOfRooms_4[1] -= numOfRoom;
                    return "The room you require is available";
                } else{
                    return "The number of required rooms are not available";
                }
            }else if(name.toLowerCase().equals("Executive Single")){
                if(numOfRoom < noOfRooms_4[2]){
                    noOfRooms_4[2] -= numOfRoom;
                    return "The room you require is available";
                }else{
                    return "The number of required rooms are not available";
                }

            }else if(hotelType.equals("3 star")){
                if(name.toLowerCase().equals("Executive double")){
                    if(numOfRoom < noOfRooms_3[0]){
                        noOfRooms_3[0] -= numOfRoom;
                        return "The number of room you required are available";
                    }else{
                        return "The number of required rooms are not available";
                    }
                }else if(name.toLowerCase().equals("Excutive Twin")){
                    if(numOfRoom < noOfRooms_3[1]){
                        noOfRooms_3[1] -= numOfRoom;
                        return "The number of room you required are available";
                    }else{
                        return "The number of required rooms are not available";
                    }
                }else if(name.toLowerCase().equals("Executive Single")){
                    if(numOfRoom < noOfRooms_3[2]){
                        noOfRooms_3[2] -= numOfRoom;
                        return "The number of room you required are available";
                    }else{
                        return "The number of required rooms are not available";
                    }
                }
            }
        }
        return "The number of required rooms are not available";
    }
  



    /**
     * @return String Get the string representation for the room.
     */
    public String toString() {
        return name + ";" + occupancy;
    }


    public String toCSV() {
        return hotelType + ";" + name + ";" + occupancy;
    }


      /**
     * set price of rooms in 5 star hotel
     */
    public static void setPrice(int star, int roomPrice, int roomPrice1, int roomPrice2, int roomPirce3) {
        if (star == 5) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    five_star_RTP.add(roomPrice);
                } else if (i == 1) {
                    five_star_RTP.add(roomPrice1);
                } else if (i == 2) {
                    five_star_RTP.add(roomPrice2);
                } else {
                    five_star_RTP.add(roomPirce3);
                }
            }
        }
    }

    /**
     * set price of rooms in 3 or 4 star hotel
     */
    public static void setPrice1(int star, int roomPrice, int roomPrice1, int roomPrice2) {

        if (star == 4) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    four_star_RTP.add(roomPrice);
                } else if (i == 1) {
                    four_star_RTP.add(roomPrice1);
                } else {
                    four_star_RTP.add(roomPrice2);
                }
            }
        } else if (star == 3) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    three_star_RTP.add(roomPrice);
                } else if (i == 1) {
                    three_star_RTP.add(roomPrice1);
                } else {
                    three_star_RTP.add(roomPrice2);
                }
            }
        }
    }

    /**
     * print out the price of each type of room in specfic hotle
     */
    public static void getPrice(int star) {
        if (star == 5) {

            for (int price : five_star_RTP) {
                System.out.print("  " + price + "  " + "|");
            }
            System.out.println();

        } else if (star == 4) {

            for (int price : four_star_RTP) {
                System.out.print("  " + price + "  " + "|");
            }
            System.out.println();

        } else if (star == 3) {

            for (int price : three_star_RTP) {
                System.out.print("  " + price + "  " + "|");
            }

            System.out.println();

        }

    }
}