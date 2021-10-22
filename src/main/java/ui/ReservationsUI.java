package ui;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReservationsUI extends SceneUI {
    public ReservationsUI(UIManager manager) {
        Label label = new Label("Reservations UI");
        Button button = new Button("Back");
        button.setOnMouseClicked((event) -> {
            manager.setScene(new MainMenuUI(manager));
        });
        VBox vbox = new VBox(label, button);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(vbox);
        hbox.setAlignment(Pos.CENTER);
        setRoot(hbox);
    }
}