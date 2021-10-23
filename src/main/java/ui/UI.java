package ui;

import core.ReservationFormState;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UI extends Scene {
    public static final int COMPANY_TITLE_FONT_SIZE = 16;

    public void setOnSave(OnSave<ReservationFormState> value) {
        onSave = value;
    }

    protected OnSave<ReservationFormState> onSave;
    ScrollPane contentPane;
    VBox sidebar;

    public UI() {
        // We will set a new root in this fuction.
        super(new Label("Dummy"));
        Label companyLabel = new Label("BestSolutions Ltd");
        companyLabel.getStyleClass().add("company-label");

        HBox centeredCompanyLabel = new HBox(companyLabel);
        centeredCompanyLabel.setAlignment(Pos.CENTER);

        Button makeReservation = new Button("Make Reservation");
        makeReservation.setPrefSize(150, 50);
        makeReservation.getStyleClass().add("sidebar-button");
        //makeReservation.setPadding(new Insets(10, 10, 10, 10));
        makeReservation.setOnMouseClicked((event) -> {
            contentPane.setContent(new ReservationsUI(this));
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            contentPane.setContent(new AnalysisUI(this));
        });

        Button viewData = new Button("Data");
        viewData.setPrefSize(150, 50);
        viewData.setOnMouseClicked((event) -> {
            contentPane.setContent(new DataUI(this));
        });

        Button exit = new Button("Exit");
        exit.setPrefSize(150, 50);
        exit.setOnMouseClicked((event) -> {
            System.exit(0);
        });
    
        sidebar = new VBox(centeredCompanyLabel, makeReservation, viewAnalysis, viewData, exit);
        sidebar.setSpacing(10);
        sidebar.setPadding(new Insets(10));        

        contentPane = new ScrollPane();
        HBox.setHgrow(contentPane, Priority.ALWAYS);;
        contentPane.setFitToWidth(true);

        HBox hbox = new HBox(contentPane);
        HBox.setHgrow(hbox, Priority.SOMETIMES);

        HBox wholeScene = new HBox(sidebar, hbox);

        setRoot(wholeScene);
    }
}