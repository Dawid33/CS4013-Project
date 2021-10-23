package ui;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UIManager {
    public static final int COMPANY_TITLE_FONT_SIZE = 20;
    public static final Color BACKGROUND_COLOR = new Color(1, 0, 0, 0);
    Stage stage;
    Scene current_scene;

    public Scene getScene() {
        return current_scene;
    }

    public UIManager(int x, int y) {
        current_scene = new BaseUI();
    }

    public void setScene(Scene value) {
        stage.setScene(value);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
