package ui;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class UIManager {
    public static final int COMPANY_TITLE_FONT_SIZE = 20;
    public static final Color BACKGROUND_COLOR = new Color(1, 0, 0, 0);
    Stage stage;
    Scene current_scene;

    public Scene getScene() {
        return current_scene;
    }

    public UIManager(int x, int y) {
        current_scene = new MainMenuUI(this);
    }

    public void setScene(Scene value) {
        stage.setScene(value);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
