package ui;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class AnalysisUI extends SceneUI {
    public AnalysisUI(UIManager manager) {
        Label label = new Label("Analysis UI");
        backButton.setText("Back");
        backButton.setOnMouseClicked((event) -> {
            manager.setScene(new MainMenuUI(manager));
        });

        this.contentPanel.getChildren().addAll(label);
    }
}
