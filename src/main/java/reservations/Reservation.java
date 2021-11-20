package reservations;

import java.io.File;

public class Reservation {
    public static void main(String[] args) {
        File csv = new File("src/main/java/reservations/l4Hotels.csv");
        System.out.println(ReadHotel.inputHotelData(csv));
        
    }
}
