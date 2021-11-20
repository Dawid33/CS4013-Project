package ui.panes;
import java.time.LocalDate;

import core.Booking;
import core.exceptions.BookingFormSaveExeception;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
/*
Hotel type 	Room type	     Number of Rooms	Occupancy-min	Occupancy-max	Rates						
                                                                                Mon Tue Wed Thur Fri  Sat  Sun
5-star	    Deluxe Double	 35	                1	            2	            75	75	75	80	 90   90	75
            Deluxe Twin	     25	                1	            2	            75	75	75	80	 90   90	75
            Deluxe Single	 10	                1	            2	            70	70	70	75	 80   80	65
            Deluxe Family	 10	                1	            3	            80	80	80	80	 100  100	80
4-star	    Executive Double 40	                1	            2	            70	70	70	70	 80   85	85
            Executive Twin	 32	                1	            2	            70	70	70	70	 80   85	85
            Executive Single 12	                1	            1	            65	65	65	65	 70   75	80
3-star	    Classic Double	 45	                1	            2	            65	65	70	70	 75   80	65
            Classic Twin	 45	                1	            2	            65	65	70	70	 80   85	65
            Classic Single	 10	                1	            1	            50	50	50	60	 75   75	50

*/
import ui.UI;


public class BookingUI extends VBox {
    
    TextField emailTxtField;
    TextField nameTxtField;
    
    DatePicker checkIn;
    DatePicker checkOut;

    ToggleGroup bookingTypeGroup;

    CheckBox deluxeDouble;
    CheckBox deluxeTwin;
    CheckBox deluxeSingle;
    CheckBox deluxeFamily;

    CheckBox executiveDouble;
    CheckBox executiveTwin;
    CheckBox executiveSingle;

    CheckBox classicDouble;
    CheckBox classicTwin;
    CheckBox classicSingle;

    ToggleGroup hotelTypeGroup;
    RadioButton standardBooking;
    RadioButton apBooking;

    Text errorText = new Text();
    
    public BookingUI(UI baseUI) {
        Text title = new Text("Booking Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);

        GridPane gp = new GridPane();
        gp.setHgap(4);
        gp.setVgap(4);
        
        HBox.setHgrow(gp, Priority.ALWAYS);
        
        // Line one.
        Label emailLabel = new Label("Email :");
        emailTxtField = new TextField();

        Label nameLabel = new Label("Name :");
        nameTxtField = new TextField();
        GridPane.setHgrow(emailTxtField, Priority.ALWAYS);
        GridPane.setHgrow(nameTxtField, Priority.ALWAYS);

        gp.add(emailLabel, 0, 0);
        gp.add(emailTxtField, 1, 0);
        gp.add(nameLabel, 2, 0);
        gp.add(nameTxtField, 3, 0);

        // Line two
        Label checkInLabel = new Label("Check in :");
        checkIn = new DatePicker(LocalDate.now());

        Label checkOutLabel = new Label("Check out :");
        checkOut = new DatePicker();

        GridPane.setHgrow(checkIn, Priority.ALWAYS);
        GridPane.setHgrow(checkOut, Priority.ALWAYS);

        gp.add(checkInLabel, 0, 1);
        gp.add(checkIn, 1, 1);
        gp.add(checkOutLabel, 2, 1);
        gp.add(checkOut, 3, 1);

        // Line 3 and 4
        standardBooking = new RadioButton("Standard Booking");
        apBooking = new RadioButton("Advance Purchase Booking");
        bookingTypeGroup = new ToggleGroup();
        standardBooking.setToggleGroup(bookingTypeGroup);
        standardBooking.setSelected(true);
        GridPane.setHgrow(standardBooking, Priority.ALWAYS);
        apBooking.setToggleGroup(bookingTypeGroup);
        GridPane.setHgrow(apBooking, Priority.ALWAYS);

        gp.add(standardBooking, 0, 3, 2, 1);
        gp.add(apBooking, 0, 4 , 2, 1);

        gp.add(createHotelSelection(), 0, 5, 5, 1);

        gp.add(errorText, 0, 6);

        Button saveButton = new Button("Make Reservation");
        saveButton.setOnMouseClicked((event) -> {
            try {
                baseUI.getOnSave().onSave(getState());
            } catch (BookingFormSaveExeception e) {
                errorText.setText(e.getMessage());
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setOnMouseClicked((event) -> {
            clearState();
        });
        
        Separator sep = new Separator();
        sep.setPadding(new Insets(10));

        // Maybe move clear button the left hand side so as
        // to not accidentally click clear instead of save.
        HBox bottomBar = new HBox(clearButton, saveButton);
        bottomBar.setSpacing(10);
        bottomBar.setPadding(new Insets(0, 10, 0, 0));
        bottomBar.setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(centeredTitle ,gp, sep, bottomBar);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }

    HBox createHotelSelection() {
        Label fiveStar = new Label ("5 Star Hotel");
        Label  fourStar = new Label ("4 Star Hotel");
        Label  threeStar = new Label ("3 Star Hotel");
        fiveStar.getStyleClass().add("hotel-label");
        fourStar.getStyleClass().add("hotel-label");
        threeStar.getStyleClass().add("hotel-label");

        HBox centeredFiveStar = new HBox(fiveStar);
        centeredFiveStar.setAlignment(Pos.CENTER);
        HBox centeredFourStar = new HBox(fourStar);
        centeredFourStar.setAlignment(Pos.CENTER);
        HBox centeredThreeStar = new HBox(threeStar);
        centeredThreeStar.setAlignment(Pos.CENTER);

        deluxeDouble = new CheckBox("Deluxe Double");
        deluxeTwin = new CheckBox("Deluxe Twin");
        deluxeSingle = new CheckBox("Deluxe Single");
        deluxeFamily = new CheckBox("Deluxe Family");
        VBox fiveStarCheckBoxBox = new VBox(centeredFiveStar, deluxeDouble, deluxeTwin, deluxeSingle, deluxeFamily);

        executiveDouble = new CheckBox("Executive Double");
        executiveTwin = new CheckBox("Executive Twin");
        executiveSingle = new CheckBox("Executive Single");
        VBox fourStarCheckBoxBox = new VBox(centeredFourStar, executiveDouble, executiveTwin, executiveSingle);

        classicDouble = new CheckBox("Classic Double");
        classicTwin = new CheckBox("Classic Twin");
        classicSingle = new CheckBox("Classic Single");
        VBox threeStarCheckBoxBox = new VBox(centeredThreeStar, classicDouble, classicTwin, classicSingle);

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        
        HBox finalBox = new HBox(fiveStarCheckBoxBox, spacer1, fourStarCheckBoxBox, spacer2, threeStarCheckBoxBox);
        finalBox.setAlignment(Pos.TOP_CENTER);
        finalBox.setPadding(new Insets(10, 30, 10, 30));

        GridPane.setHgrow(finalBox, Priority.ALWAYS);

        return finalBox;
    }

    Booking getState () {
        Booking state = new Booking();

        /*
        state.setEmail(emailTxtField.getText());
        state.setName(nameTxtField.getText());

        state.setCheckInDate(checkIn.getValue());
        state.setCheckOutDate(checkOut.getValue());

        state.setDeluxeDouble(deluxeDouble.isSelected());
        state.setDeluxeFamily(deluxeFamily.isSelected());
        state.setDeluxeSingle(deluxeSingle.isSelected());
        state.setDeluxeTwin(deluxeTwin.isSelected());

        state.setExecutiveDouble(executiveDouble.isSelected());
        state.setExecutiveSingle(executiveSingle.isSelected());
        state.setExecutiveTwin(executiveTwin.isSelected());

        state.setClassicDouble(classicDouble.isSelected());
        state.setClassicSingle(classicSingle.isSelected());
        state.setClassicTwin(classicTwin.isSelected());
        */
        return state;
    }

    void clearState() {
        emailTxtField.clear();
        nameTxtField.clear();
        
        checkIn.setValue(null);
        checkOut.setValue(null);

        deluxeDouble.setSelected(false);
        deluxeFamily.setSelected(false);
        deluxeSingle.setSelected(false);
        deluxeTwin.setSelected(false);

        executiveDouble.setSelected(false);
        executiveSingle.setSelected(false);
        executiveTwin.setSelected(false);

        classicDouble.setSelected(false);
        classicSingle.setSelected(false);
        classicTwin.setSelected(false);

        errorText.setText("");
    }
}