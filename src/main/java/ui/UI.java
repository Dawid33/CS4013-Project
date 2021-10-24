package ui;

import java.io.IOException;
import java.util.function.Consumer;

import core.Program;
import core.SettingsIO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import state.ReservationFormState;
import state.SettingsState;
import ui.interfaces.OnSave;

public class UI extends Scene {
    public static final int COMPANY_TITLE_FONT_SIZE = 16;
    public static final double DEFAULT_SPACING = 10;

    public void setOnSave(OnSave<ReservationFormState> value) {
        onSave = value;
    }

    public void setOnThemeChange(Consumer<Theme> value) {
        this.onThemeChange = value;
    }

    Consumer<Theme> onThemeChange;
    OnSave<ReservationFormState> onSave;
    Pane contentPane;
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
        makeReservation.setOnMouseClicked((event) -> {
            setContentPane(new ReservationsUI(this));
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            setContentPane(new AnalysisUI(this));
        });

        Button viewData = new Button("Data");
        viewData.setPrefSize(150, 50);
        viewData.setOnMouseClicked((event) -> {
            setContentPane(new DataUI(this));
        });

        Button viewHelp = new Button("Help");
        viewHelp.setPrefSize(150, 50);
        viewHelp.setOnMouseClicked((event) -> {
            setContentPane(new HelpUI(this));
        });    
        
        Button viewSettings = new Button("Settings");
        viewSettings.setPrefSize(150, 50);
        viewSettings.setOnMouseClicked((event) -> {
            // Read settings from file
            SettingsState state = new SettingsState();;
            try {
                state = SettingsIO.loadSettings();
            } catch (IOException e) {
                System.out.println("IOException when trying to read settings file : " + e.getMessage());
            }
            setContentPane(new SettingsUI(this, state));
        });

        Button exit = new Button("Exit");
        exit.setPrefSize(150, 50);
        exit.setOnMouseClicked((event) -> {
            System.exit(0);
        });
    
        sidebar = new VBox(centeredCompanyLabel, makeReservation, viewAnalysis, viewData, viewHelp, viewSettings, exit);
        sidebar.setSpacing(UI.DEFAULT_SPACING);
        sidebar.setPadding(new Insets(UI.DEFAULT_SPACING));
        sidebar.getStyleClass().add("sidebar");
        HBox.setHgrow(sidebar, Priority.NEVER);

        contentPane = new VBox();
        HBox.setHgrow(contentPane, Priority.SOMETIMES);;
        contentPane.setMinHeight(Program.MIN_APPLICATION_HEIGHT);
        //If contentPane is a vbox
        //contentPane.setFitToWidth(true);
        contentPane.getStyleClass().add("content-pane");
        
        HBox hbox = new HBox(contentPane);
        HBox.setHgrow(hbox, Priority.SOMETIMES);
        
        HBox wholeScene = new HBox(sidebar, hbox);

        setRoot(wholeScene);
    }

    void setContentPane(Node node) {
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(node);
    }
}