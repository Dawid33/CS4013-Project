package core;

import core.exceptions.ReservationFormSaveExeception;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.*;

public class Program extends Application {
    public static final int MAX_APPLICATION_WIDTH = 804;
    
    Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        primaryStage.setWidth(804);
        primaryStage.setHeight(720);
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
        
        System.out.println(this.stage.getWidth());
        //throw new ReservationFormSaveExeception("Not implemented");
    }
}