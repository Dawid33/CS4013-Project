package ui;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReservationsUI extends SceneUI {
    public ReservationsUI(UIManager manager) {
        Label label = new Label("Reservations UI");
        VBox vbox = new VBox(label);
        HBox hbox = new HBox(vbox);
        setRoot(hbox);
    }
}