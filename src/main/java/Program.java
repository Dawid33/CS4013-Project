import javafx.application.Application;
import javafx.stage.Stage;
import ui.*;

public class Program extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIManager ui = new UIManager(primaryStage, 800, 600);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}