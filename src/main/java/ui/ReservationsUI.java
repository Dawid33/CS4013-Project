package ui;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ReservationsUI extends GridPane {

    public ReservationsUI() {        
        Label emailLabel = new Label("Email :");
        TextField txtFieldEmail = new TextField();
        GridPane.setHgrow(txtFieldEmail, Priority.ALWAYS);

        HBox.setHgrow(this, Priority.ALWAYS);

        this.add(emailLabel, 0, 0); this.add(txtFieldEmail, 1, 0);
    }
}