package ui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class BaseUI extends Scene {
    ScrollPane contentPane;
    VBox sideBar;

    public BaseUI() {
        // We will set a new root in this fuction.
        super(new Label("Dummy"));
        Label companyLabel = new Label("BestSolutions");
        companyLabel.setFont(new Font(UIManager.COMPANY_TITLE_FONT_SIZE));

        Button makeReservation = new Button("Make Reservation");
        makeReservation.setPrefSize(150, 50);
        makeReservation.setOnMouseClicked((event) -> {
            contentPane.setContent(new ReservationsUI());
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            
        });

        Button viewData = new Button("Data");
        viewData.setPrefSize(150, 50);
        viewData.setOnMouseClicked((event) -> {
            
        });
    
        sideBar = new VBox(companyLabel, makeReservation, viewAnalysis, viewData);

        contentPane = new ScrollPane();
        HBox.setHgrow(contentPane, Priority.ALWAYS);;
        
        HBox hbox = new HBox(contentPane);
        HBox.setHgrow(hbox, Priority.ALWAYS);;

        HBox wholeScene = new HBox(sideBar, hbox);
        
        setRoot(wholeScene);
    }
}