package core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;

import core.exceptions.BookingFormSaveExeception;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.*;

public class Program extends Application {
    public static final int MIN_APPLICATION_WIDTH = 1024;
    public static final int MIN_APPLICATION_HEIGHT = 720;
    public static final String RESOURCES_PATH = "src/main/resources/";
    public static final String SAVE_FILE_PATH = "settings.save";
    public static final String CSS_FOLDER_PATH = "css/";
    public static final String DUMMY_DATA_PATH = "dummy/";

    UI ui = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(MIN_APPLICATION_WIDTH);
        primaryStage.setHeight(MIN_APPLICATION_HEIGHT);
        primaryStage.setTitle("CS4013 Application");

        ui = new UI();
        ui.setOnSave(this::saveData);
        ui.setOnThemeChange(this::onThemeChange);
        // Apply CSS.
        onThemeChange(IO.loadSettings().theme);

        primaryStage.setScene(ui);
        primaryStage.show();
    }

    public static void main(String[] args) {

        CSV file = new CSV("email,name,2002-10-22,2002-10-22,type;2, my type;100");
        BookingForm form = new BookingForm();
        try {
            form.fromCSV(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(form.toString());

        launch(args);
    }

    public static String themeToFileName (Theme theme) {
        switch(theme) {
            case Blue: return "blue.css";
            case Purple: return "purple.css";
            case Unicorn: return "unicorn.css";
        }
        return "main.css";
    }

    public void onThemeChange(Theme theme) {
        ui.getStylesheets().clear();
        ui.getStylesheets().addAll(CSS_FOLDER_PATH + "main.css", CSS_FOLDER_PATH + themeToFileName(theme));
    }

    public void saveData(BookingForm state) throws BookingFormSaveExeception {
        throw new BookingFormSaveExeception("This is my error.");
    }
}