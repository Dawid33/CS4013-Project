package ui;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class AnalysisUI extends HBox {
    public AnalysisUI(UI baseUI) {
        Label label = new Label("Analysis UI");
        getChildren().add(label);
    }
}
