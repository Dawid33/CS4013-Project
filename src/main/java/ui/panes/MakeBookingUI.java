package ui.panes;
import java.time.LocalDate;
import java.util.ArrayList;

import booking_system.Booking;
import booking_system.BookingFormSaveExeception;
import booking_system.Room;
import core.Program;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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
import javafx.util.Pair;
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


public class MakeBookingUI extends VBox {
    
    TextField emailTxtField;
    TextField nameTxtField;
    
    DatePicker checkIn;
    DatePicker checkOut;

    ToggleGroup bookingTypeGroup;

    ChoiceBox<String> hotelType;
    ChoiceBox<String> roomType;

    TextField occupancy;

    RadioButton standardBooking;
    RadioButton apBooking;

    Text rooms;

    ArrayList<Room> bookedRooms = new ArrayList<>();

    Text errorText = new Text();
    
    public MakeBookingUI(UI baseUI) {
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

        gp.add(nameLabel , 0, 0);
        gp.add(nameTxtField, 1, 0);
        gp.add(emailLabel, 2, 0);
        gp.add(emailTxtField, 3, 0);

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

        Separator roomSeperator = new Separator();
        roomSeperator.setPadding(new Insets(10));

        gp.add(roomSeperator, 0, 5 , 4, 1);

        Label hotelTypeLabel = new Label("Hotel");
        Label roomLabel = new Label("Room Type");
        Label occupancyLabel = new Label("Occupancy");

        hotelType = new ChoiceBox<>();
        hotelType.getItems().addAll("3 Star", "4 Star", "5 Star");
        hotelType.getSelectionModel().select(0);

        roomType = new ChoiceBox<>();
        roomType.getItems().addAll(
            "Deluxe Double", "Deluxe Twin", "Deluxe Single", "Deluxe Family",
            "Executive Double", "Executive Twin", "Executive Single",
            "Classic Double", "Classic Twin", "Classic Single"
        );
        
        occupancy = new TextField();

        // force the field to be numeric only
        occupancy.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    occupancy.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Button addRoom = new Button("Add Room");
        addRoom.setOnAction((event) -> {
            bookedRooms.add(new Room(hotelType.getValue() + ";" + roomType.getValue() + ";" + occupancy.getText()));
            StringBuilder builder = new StringBuilder();
            for(Room r : bookedRooms) {
                builder.append(r.toString() + "\n");
            }
            rooms.setText(builder.toString());
        });

        gp.add(hotelTypeLabel, 0, 6);
        gp.add(hotelType, 1, 6);
        gp.add(roomLabel, 2, 6);
        gp.add(roomType, 3, 6);

        gp.add(occupancyLabel, 0, 7);
        gp.add(occupancy, 1, 7);
        gp.add(addRoom, 3, 7);

        rooms = new Text();
        gp.add(rooms, 0, 8);

        gp.add(errorText, 0, 9);

        Button saveButton = new Button("Make Reservation");
        saveButton.setOnMouseClicked((event) -> {
            errorText.setText("Success!");
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
    
    /** 
     * @return Booking
     */
    Booking getState () {
        Booking state = new Booking();

        state.email = emailTxtField.getText();
        state.name = nameTxtField.getText();

        state.checkInDate = checkIn.getValue();
        state.checkOutDate = checkOut.getValue();

        if(apBooking.isSelected())
            state.isApPurchase = true;
        else
            state.isApPurchase = false;

        state.setRooms(bookedRooms);
        return state;
    }

    void clearState() {
        emailTxtField.clear();
        nameTxtField.clear();
        
        checkIn.setValue(null);
        checkOut.setValue(null);

        bookedRooms.clear();
        rooms.setText("");

        bookedRooms.clear();

        errorText.setText("");
    }
}