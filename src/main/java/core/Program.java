package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import booking_system.Booking;
import booking_system.BookingFormSaveExeception;
import booking_system.BookingSystem;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.Theme;
import ui.UI;
import ui.Login;

public class Program extends Application {
    public static final int MIN_APPLICATION_WIDTH = 1024;
    public static final int MIN_APPLICATION_HEIGHT = 720;
    public static final String RESOURCES_PATH = "src/main/resources/";
    public static final String SAVE_FILE_PATH = "settings.save";
    public static final String BOOKINGS_PATH = RESOURCES_PATH + "bookings.csv";
    public static final String ARCHIVE_PATH = RESOURCES_PATH + "archive.csv";
    public static final String USERS_PATH = RESOURCES_PATH + "users.csv";
    public static final String CSS_FOLDER_PATH = "css/";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Login login;

    UI ui = null;
    BookingSystem bookingSystem = null;

    /** 
     * 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup booking system.
        // Import bookings from file
        bookingSystem = new BookingSystem(new File(BOOKINGS_PATH), new File(ARCHIVE_PATH));
        // Add reservations to booking system.

        // Setup UI
        primaryStage.setWidth(MIN_APPLICATION_WIDTH);
        primaryStage.setHeight(MIN_APPLICATION_HEIGHT);
        primaryStage.setTitle("CS4013 Application");

        ui = new UI();
        ui.setOnSave(this::saveData);
        ui.setOnThemeChange(this::onThemeChange);
        ui.setBookingSystem(bookingSystem);

        login = new Login(primaryStage);
        login.setMainUI(ui);

        // Apply CSS.
        onThemeChange(IO.loadSettings().theme);
        
        primaryStage.setScene(ui);
        primaryStage.show();
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /** 
     * @param theme
     * @return String
     */
    public static String themeToFileName(Theme theme) {
        switch (theme) {
        case Blue:
            return "blue.css";
        case Purple:
            return "purple.css";
        case Unicorn:
            return "unicorn.css";
        }
        return "main.css";
    }

    
    /** 
     * @param theme
     */
    public void onThemeChange(Theme theme) {
        ui.getStylesheets().clear();
        ui.getStylesheets().addAll(CSS_FOLDER_PATH + "main.css", CSS_FOLDER_PATH + themeToFileName(theme));
    }

    
    /** 
     * @param newBooking
     * @return boolean
     * @throws BookingFormSaveExeception
     */
    public void saveData(Booking newBooking) throws BookingFormSaveExeception {
        StringBuilder errors = new StringBuilder();

        File f = new File(BOOKINGS_PATH);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new BookingFormSaveExeception("Found no bookings file. Could not create new file.");
            }
        }

        if(newBooking.name == "" || newBooking.name == null) {
            errors.append("Name cannot be null.");

        }

        if(newBooking.email == "" || newBooking.email == null) {
            errors.append("Email cannot be null.");
        }

        try (FileWriter fw = new FileWriter(BOOKINGS_PATH, true)) {
            fw.append(newBooking.toCSV().toString());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            throw new BookingFormSaveExeception("Cannot append booking to reservations file.");
        }

        if (!errors.toString().equals("")) {
            throw new BookingFormSaveExeception(errors.toString());
        } else {
            bookingSystem.addBooking(newBooking);
        }
    }
}