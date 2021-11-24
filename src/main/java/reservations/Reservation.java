package reservations;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reservation {
    private int reservNum;
    private String reservName;
    private boolean ap;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private static ArrayList<Hotel> hotelList;
    private double totalCost;

    public Reservation(File file) throws FileNotFoundException {
        String s = "";
        String t = "";
        int i = 0;
        StringTokenizer token = new StringTokenizer(s, ":");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\n");
        while (scanner.hasNext()) {
            s = String.format("%s%s:", s, scanner.next());
        }
        
        scanner.close();

        for (int j = 0; j < 2; j++) {
            t = token.nextToken();
        }

        while (token.hasMoreTokens()) {
            t = token.nextToken();
            if (t.startsWith(",") == false) {
                hotelList.add(new Hotel(t));
                i = 1;
            }
            else {
                hotelList.get(hotelList.size() - 1).addRooms(hotelList.get(hotelList.size() - 1).getNumRooms(i), t);
                i++;
            }
        }


    }
}
