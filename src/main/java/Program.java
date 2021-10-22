import javafx.application.Application;
import javafx.stage.Stage;
import ui.*;

public class Program extends Application {
    public static UIManager uiManager;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("CS4013 Application");
        primaryStage.setScene(Program.uiManager.getScene());
        Program.uiManager.setStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Program.uiManager = new UIManager(800, 600);
        // Init ui functions.

        launch(args);
    }
}