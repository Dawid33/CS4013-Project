package reservations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReservationTest {
    
    /** 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String s = "";
        File file = new File("src\\main\\java\\reservations\\l4Hotels.csv");
        Reservation r = new Reservation(file);
        System.out.println(r.toString());
    }
}
