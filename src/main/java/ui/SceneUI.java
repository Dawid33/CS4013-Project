package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SceneUI extends Scene {
    public VBox wholeScene;
    public VBox contentPanel;
    public Button backButton;

    public SceneUI() {
        // We will set a new root in this fuction.
        super(new Label("Dummy"));

        backButton = new Button("Exit");
        backButton.setPrefSize(150, 50);
        backButton.setOnMouseClicked((event) -> {
            System.exit(0);
        });

        // Default layout for each scene.
        contentPanel = new VBox();
        HBox hbox = new HBox(contentPanel);
        hbox.setAlignment(Pos.CENTER);

        VBox centering = new VBox(hbox);
        centering.setAlignment(Pos.CENTER);

        wholeScene = new VBox(backButton, centering);
        VBox.setVgrow(centering, Priority.ALWAYS);

        setRoot(wholeScene);
    }
}