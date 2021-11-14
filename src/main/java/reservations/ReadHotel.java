package reservations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadHotel {
    public static String inputHotelData(File csv) {
        try {
            String s = "";
            String t = "";
            Scanner scanner = new Scanner(csv);
            scanner.useDelimiter(",");
            
            while (scanner.hasNext()) {
                t = scanner.next();
                if (t != "") {
                    s = String.format("%s%s:", s, t);
                }
            }
            scanner.close();

            
            return s;
        }
        catch (FileNotFoundException e) {
            return "File not read.";
        }
    }
}
