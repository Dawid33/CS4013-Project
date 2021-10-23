package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.*;

public class Program extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("CS4013 Application");

        UI ui = new UI();
        ui.setOnSave(this::saveData);
        ui.getStylesheets().add("main.css");

        primaryStage.setScene(ui);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //System.out.println(javafx.scene.text.Font.getFamilies());
        launch(args);
    }

    public void saveData(ReservationFormState state) throws ReservationFormSaveExeception {
        throw new ReservationFormSaveExeception("Not implemented");
    }
}