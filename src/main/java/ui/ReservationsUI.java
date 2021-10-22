package ui;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReservationsUI extends SceneUI {
    public ReservationsUI(UIManager manager) {
        Label label = new Label("Reservations UI");
        backButton.setText("Back");
        backButton.setOnMouseClicked((event) -> {
            manager.setScene(new MainMenuUI(manager));
        });

        this.contentPanel.getChildren().addAll(label);
    }
}