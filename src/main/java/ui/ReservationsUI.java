package ui;
import java.time.LocalDate;

import core.ReservationFormState;
import core.exceptions.ReservationFormSaveExeception;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ReservationsUI extends VBox {

    DatePicker checkIn;
    DatePicker checkOut;

    public ReservationsUI(UI baseUI) {
        
        GridPane gp = new GridPane();
        gp.setHgap(4);
        gp.setVgap(4);
        
        HBox.setHgrow(gp, Priority.ALWAYS);
        
        // Line one.
        Label emailLabel = new Label("Email :");
        TextField emailTxtField = new TextField();

        Label nameLabel = new Label("Name :");
        TextField nameTxtField = new TextField();
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
        RadioButton standardReservation = new RadioButton("Standard Reservation");
        RadioButton apReservation = new RadioButton("Advance Purchase Reservation");
        ToggleGroup group = new ToggleGroup();
        standardReservation.setToggleGroup(group);
        standardReservation.setSelected(true);
        GridPane.setHgrow(standardReservation, Priority.ALWAYS);
        apReservation.setToggleGroup(group);
        GridPane.setHgrow(apReservation, Priority.ALWAYS);

        gp.add(standardReservation, 0, 3, 2, 1);
        gp.add(apReservation, 0, 4 , 2, 1);


        Button saveButton = new Button("Save");
        saveButton.setOnMouseClicked((event) -> {
            try {
                baseUI.onSave.onSave(generateState());
            } catch (ReservationFormSaveExeception e) {
                System.out.println(e.getMessage());
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

        getChildren().addAll(gp, sep, bottomBar);
        setMargin(gp, new Insets(20));
    }

    ReservationFormState generateState () {
        //TODO
        return new ReservationFormState();
    }

    void clearState() {
        //TODO
    }
}