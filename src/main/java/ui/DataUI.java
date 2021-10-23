package ui;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class DataUI extends HBox {
    public DataUI(UI baseUI) {
        Label label = new Label("Data UI");
        getChildren().add(label);
    }
}
