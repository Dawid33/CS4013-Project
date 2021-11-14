package core;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    public String email = null;
    public String name = null;
    public LocalDate checkInDate = null;
    public LocalDate checkOutDate = null;
    public boolean isApPurchase = false;
    public boolean isStandardPurchase = false;
    ArrayList<Room> rooms = new ArrayList<>();

    public Booking() {}
    public Booking(CSV csv) throws Exception {
        fromCSV(csv);
    }

    public CSV toCSV() {
        StringBuilder builder = new StringBuilder();

        if (name != null)
            builder.append(email + ",");
        else 
            builder.append("NULL,");

        if (name != null)
            builder.append(name + ",");
        else 
            builder.append("NULL,");

        if (checkInDate != null)
            builder.append(checkInDate.toString() + ",");
        else 
            builder.append("NULL,");

        if (checkOutDate != null)
            builder.append(checkOutDate.toString() + ",");
        else 
            builder.append("NULL,");

        if(!rooms.isEmpty())
            rooms.forEach((x) -> {builder.append(x + ",");});

        return new CSV(builder.toString().substring(0, builder.length() - 1));
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
                        Boolean b = Boolean.valueOf(s.toLowerCase());
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

/*
Testing code.

try {
    CSV file = new CSV(IO.readFile(new File(RESOURCES_PATH + DUMMY_DATA_PATH + "reservations.csv")));
    ArrayList<Booking> reservations= new ArrayList<>();
    for(CSV s : file.getRows()) {
        reservations.add(new Booking(s));
    }

    for (Booking f : reservations) {
        System.out.println(f.toCSV().toString());
    }

} catch (IOException e ) {
    System.out.println(e.getMessage());
    System.exit(1);
} catch (Exception e) {
    System.out.println(e.getMessage());
    System.exit(1);
}
*/