package ui;

import java.io.IOException;
import java.util.function.Consumer;

import booking_system.Booking;
import booking_system.BookingSystem;
import core.IO;
import core.Program;
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
import ui.interfaces.OnSave;
import ui.panes.*;


public class UI extends Scene {
    public static final int COMPANY_TITLE_FONT_SIZE = 16;
    public static final double DEFAULT_SPACING = 15;

    Consumer<Theme> onThemeChange;
    OnSave<Booking> onSave;
    Pane contentPane;
    BookingSystem bookingSystem = null;

    
    /** 
     * Set the function that is executed when the user presses the make reservation button in the make reservation UI.
     * @param value The function that is executed.
     */
    public void setOnSave(OnSave<Booking> value) {
        onSave = value;
    }
    
    /** 
     * Set the function that is executed when the user changes a theme.
     * @param value The function that is executed.
     */
    public void setOnThemeChange(Consumer<Theme> value) {
        this.onThemeChange = value;
    }
    
    /** 
     * Get the function that is executed when the user presses the make reservation button in the make reservation UI.
     * @return OnSave The function that is executed.
     */
    public OnSave<Booking> getOnSave() {
        return onSave;
    }
    
    /** 
     * Get the function that is executed when the user changes a theme.
     * @return Consumer The function that is executed.
     */
    public Consumer<Theme> getOnThemeChange() {
        return onThemeChange;
    }

    /** 
     * @param input The booking system that keeps track of booking information regarding bookings.
     */
    public void setBookingSystem(BookingSystem input) {
        bookingSystem = input;
    }

    
    /** 
     * @return BookingSystem Get the booking system used by the UI.
     */
    public BookingSystem getBookingSystem() {
        return bookingSystem;
    }

    
    public UI() {
        // super needs a parameter for the root node.
        // We will set a new root in this fuction.
        super(new Label("Dummy"));
        
        Label companyLabel = new Label("BestSolutions Ltd");
        companyLabel.getStyleClass().add("company-label");

        HBox centeredCompanyLabel = new HBox(companyLabel);
        centeredCompanyLabel.setAlignment(Pos.CENTER);

        Button makeReservation = new Button("Make Booking");
        makeReservation.setPrefSize(150, 50);
        makeReservation.setOnMouseClicked((event) -> {
            setContentPane(new MakeBookingUI(this));
        });

        Button manageReservation = new Button("Manage Bookings");
        manageReservation.setPrefSize(150, 50);
        manageReservation.setOnMouseClicked((event) -> {
            setContentPane(new ManageBookingUI(this));
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            setContentPane(new AnalysisUI(this));
        });
        
        Button viewSettings = new Button("Settings");
        viewSettings.setPrefSize(150, 50);
        viewSettings.setOnMouseClicked((event) -> {
            // Read settings from file
            Settings state = new Settings();;
            try {
                state = IO.loadSettings();
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
    
        
        VBox sidebar = new VBox(centeredCompanyLabel, manageReservation, makeReservation, viewAnalysis, viewSettings, exit);
        sidebar.setSpacing(UI.DEFAULT_SPACING);
        sidebar.setPadding(new Insets(UI.DEFAULT_SPACING));
        sidebar.getStyleClass().add("sidebar");
        HBox.setHgrow(sidebar, Priority.NEVER);

        contentPane = new VBox();
        HBox.setHgrow(contentPane, Priority.SOMETIMES);
        //contentPane.setMinHeight(Program.MIN_APPLICATION_HEIGHT);
        //If contentPane is a vbox
        //contentPane.setFitToWidth(true);
        contentPane.getStyleClass().add("content-pane");
        
        HBox hbox = new HBox(contentPane);
        HBox.setHgrow(hbox, Priority.SOMETIMES);
        VBox.setVgrow(hbox, Priority.ALWAYS);

        HBox left = new HBox(sidebar);
        
        HBox wholeScene = new HBox(left, hbox);

        setContentPane(new MakeBookingUI(this));
        setRoot(wholeScene);
    }

    
    /** 
     * This function resets the content pane to a new node. The content pane is the right hand side blank area that contains most UI functions. It is changed by the buttons in the sidebar.
     * @param node Node to set the content pane to.
     */
    void setContentPane(Node node) {
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(node);
    }
}