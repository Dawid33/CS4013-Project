import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Program extends Application {

    public static final int COMPANY_TITLE_FONT_SIZE = 20;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label companyLabel = new Label("BestSolutions");
        companyLabel.setFont(new Font(COMPANY_TITLE_FONT_SIZE));
        Button startButton = new Button("Start");
        startButton.setPrefSize(150, 50);

        VBox vbox = new VBox(companyLabel, startButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        HBox hbox = new HBox(vbox);
        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene( hbox, 480, 320 );

        primaryStage.setScene( scene );
        primaryStage.setTitle("Start Vs. Shown");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}