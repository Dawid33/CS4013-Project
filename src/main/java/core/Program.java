package core;

import core.exceptions.ReservationFormSaveExeception;
import javafx.application.Application;
import javafx.stage.Stage;
import state.ReservationFormState;
import ui.*;

public class Program extends Application {
    public static final int MIN_APPLICATION_WIDTH = 1024;
    public static final int MIN_APPLICATION_HEIGHT = 720;
    public static final String SAVE_FILE_PATH = "./settings.save";

    Stage stage = null;
    UI ui = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        primaryStage.setWidth(MIN_APPLICATION_WIDTH);
        primaryStage.setHeight(MIN_APPLICATION_HEIGHT);
        primaryStage.setTitle("CS4013 Application");

        ui = new UI();
        ui.setOnSave(this::saveData);
        ui.setOnThemeChange(this::onThemeChange);
        // Apply CSS.
        onThemeChange(SettingsIO.loadSettings().theme);

        primaryStage.setScene(ui);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //System.out.println(javafx.scene.text.Font.getFamilies());
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
        ui.getStylesheets().addAll("main.css", themeToFileName(theme));
    }

    public void saveData(ReservationFormState state) throws ReservationFormSaveExeception {
        throw new ReservationFormSaveExeception("Not implemented");
    }
}