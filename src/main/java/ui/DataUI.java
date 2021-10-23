package ui;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class DataUI extends HBox {
    public DataUI() {
        Label label = new Label("Data UI");
        getChildren().add(label);
    }
}
