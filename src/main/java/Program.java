import com.sun.tools.javac.Main;

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
        Scene scene = new BaseUI();
        primaryStage.setScene(scene);
        scene.getStylesheets().add("main.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}