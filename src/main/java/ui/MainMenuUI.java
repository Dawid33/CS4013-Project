package ui;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class MainMenuUI extends SceneUI {
    public MainMenuUI(UIManager manager) {
        Label companyLabel = new Label("BestSolutions");
        companyLabel.setFont(new Font(UIManager.COMPANY_TITLE_FONT_SIZE));

        Button makeReservation = new Button("Make Reservation");
        makeReservation.setPrefSize(150, 50);
        makeReservation.setOnMouseClicked((event) -> {
            System.out.println("New Scene, reservation ui");
            manager.setScene(new ReservationsUI(manager));
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            System.out.println("New Scene, analysis ui");
            manager.setScene(new AnalysisUI(manager));
        });

        Button exit = new Button("Exit");
        exit.setPrefSize(150, 50);
        exit.setOnMouseClicked((event) -> {
            System.exit(0);
        });

        VBox vbox = new VBox(companyLabel, makeReservation, viewAnalysis, exit);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        HBox hbox = new HBox(vbox);
        hbox.setAlignment(Pos.CENTER);
        setRoot(hbox);
        
    }
}
