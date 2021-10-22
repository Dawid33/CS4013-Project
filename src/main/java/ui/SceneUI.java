package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class SceneUI extends Scene {
    private static Parent buildDefault() {
        return new Label("Hello?");
    }
    public SceneUI() {
        super(buildDefault());
    }
}