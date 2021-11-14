package core;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingForm {
    public String email = null;
    public String name = null;
    public LocalDate checkInDate = null;
    public LocalDate checkOutDate = null;
    boolean isApPurchase = false;
    ArrayList<Room> rooms = new ArrayList<>();

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (name != null)
            builder.append("Check in date : " + email + "\n");
        else 
            builder.append("Check in date : " + "NULL" + "\n");

        if (name != null)
            builder.append("Check in date : " + name + "\n");
        else 
            builder.append("Check in date : " + "NULL" + "\n");

        if (checkInDate != null)
            builder.append("Check in date : " + checkInDate.toString() + "\n");
        else 
            builder.append("Check in date : " + "NULL" + "\n");

        if (checkOutDate != null)
            builder.append("Check out date : " + checkOutDate.toString() + "\n");
        else 
            builder.append("Check out date : " + "NULL" + "\n");

        if(!rooms.isEmpty())
            rooms.forEach((x) -> {builder.append("Room : " + x + "\n");});

        return builder.toString();
    }

    public void fromCSV(CSV csv) throws Exception {
        java.lang.reflect.Field[] allFields = this.getClass().getFields();
        int i = 0;
        for(String s : csv) {
            if (i < allFields.length){
                try {
                    if (allFields[i].getType() == int.class) {
                        Integer x = Integer.valueOf(s);
                        allFields[i].set(this, x.intValue());
                    } else if (allFields[i].getType() == boolean.class) {
                        Boolean b = Boolean.valueOf(s);
                        allFields[i].set(this, b);
                    } else if (allFields[i].getType() == LocalDate.class) {
                        LocalDate date = LocalDate.parse(s);
                        allFields[i].set(this, date);
                    } else if (allFields[i].getType() == String.class) {
                        allFields[i].set(this, s);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }   
                i++;
            } else { //Finished parsing fields, now parsing rooms.
                rooms.add(new Room(s));
            }
        }
    }
}