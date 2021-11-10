package ui;
import java.time.LocalDate;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class BookingForm {
    String email = null;
    String name = null;
    LocalDate checkInDate = null;
    LocalDate checkOutDate = null;

    boolean apPurchase = false;
    boolean standardPurchase = false;
    
    boolean deluxeDouble = false;
    boolean deluxeTwin = false;
    boolean deluxeSingle = false;
    boolean deluxeFamily = false;

    boolean executiveDouble = false;
    boolean executiveTwin = false;
    boolean executiveSingle = false;

    boolean classicDouble = false;
    boolean classicTwin = false;
    boolean classicSingle = false;

    public boolean getDeluxeDouble() {return deluxeDouble;}
    public void setDeluxeDouble(boolean value) { this.deluxeDouble = value; }

    public boolean getDeluxeTwin() {return deluxeTwin;}
    public void setDeluxeTwin(boolean value) { this.deluxeTwin = value; }

    public boolean getDeluxeSingle() {return deluxeSingle;}
    public void setDeluxeSingle(boolean value) { this.deluxeSingle = value; }

    public boolean getDeluxeFamily() {return deluxeFamily;}
    public void setDeluxeFamily(boolean value) { this.deluxeFamily = value; }

    public boolean getExecutiveDouble() {return executiveDouble;}
    public void setExecutiveDouble(boolean value) { this.executiveDouble = value; }

    public boolean getExecutiveTwin() {return executiveTwin;}
    public void setExecutiveTwin(boolean value) { this.executiveTwin = value; }

    public boolean getExecutiveSingle() {return executiveSingle;}
    public void setExecutiveSingle(boolean value) { this.executiveSingle = value; }

    public boolean getClassicDouble() {return classicDouble;}
    public void setClassicDouble(boolean value) { this.classicDouble = value; }

    public boolean getClassicTwin() {return classicTwin;}
    public void setClassicTwin(boolean value) { this.classicTwin = value; }

    public boolean getClassicSingle() {return classicSingle;}
    public void setClassicSingle(boolean value) { this.classicSingle = value; }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

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

        builder.append("Deluxe Double : " + deluxeDouble + "\n");
        builder.append("Deluxe Family : " + deluxeFamily + "\n");
        builder.append("Deluxe Single : " + deluxeSingle + "\n");
        builder.append("Deluxe Twin : " + deluxeTwin + "\n");

        builder.append("Executive Double : " + executiveDouble + "\n");
        builder.append("Executive Single : " + executiveSingle + "\n");
        builder.append("Executive Twin : " + executiveTwin + "\n");

        builder.append("Classic Double : " + classicDouble + "\n");
        builder.append("Classic Single : " + classicSingle + "\n");
        builder.append("Classic Twin : " + classicTwin + "\n");

        return builder.toString();
    }
}
