package ui;

import javax.swing.GroupLayout.Alignment;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Scene {
    Scene mainUI;

    public void setMainUI(Scene value) {
        mainUI = value;
    }

    TextField username;
    TextField password;

    public Login(Stage stage) {
        super(new Label("Dummy text"));

        GridPane gp = new GridPane();

        username = new TextField();
        password = new TextField();
        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");

        gp.add(usernameLabel, 0, 0);
        gp.add(username, 1, 0);
        gp.add(passwordLabel, 0, 1);
        gp.add(password, 1, 1);

        Button login = new Button("Login");
        login.setOnMouseClicked((event) -> {
            if () {
                
            }
            stage.setScene(mainUI);
        });

        Button register = new Button("Register");
        register.setOnMouseClicked((event) -> {

        });

        BorderPane bp = new BorderPane();
        HBox buttons = new HBox(login, register);
        VBox panel = new VBox(gp, buttons);
        bp.setCenter(panel);
        setRoot(bp);
    }
}
