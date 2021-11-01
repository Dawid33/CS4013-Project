package state;
import java.time.LocalDate;

// I know this kind of class is frowned upon in Java.
// I don't care.
public class BookingFormState {
    public enum BookingType {
        Standard, APs
    }

    public String email;
    public String name;
    public LocalDate checkInDate;
    public LocalDate checkOutDate;
    public String rooms[];
    public BookingType type;

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (name != null) {
            builder.append(name);
            builder.append(", ");
        }
        if (email != null) {
            builder.append(email);
            builder.append(", ");
        }
        if (checkInDate != null) {
            builder.append(checkInDate.toString());
            builder.append(", ");
        }
        if (checkOutDate != null) {
            builder.append(checkOutDate.toString());
            builder.append(", ");
        }

        return builder.toString();
    }
}
