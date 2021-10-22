package ui;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class AnalysisUI extends SceneUI {
    public AnalysisUI(UIManager manager) {
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
