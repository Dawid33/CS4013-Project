package ui;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class AnalysisUI extends SceneUI {
    public AnalysisUI(UIManager manager) {
        Label label = new Label("Analysis UI");
        VBox vbox = new VBox(label);
        HBox hbox = new HBox(vbox);
        setRoot(hbox);
    }
}
