package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import booking_system.CSV;
import core.Program;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
            ArrayList<Credentials> users = getUsers();
            boolean loggedIn = false;
            for (Credentials user : users) {
                if (user.username.equals(username.getText()) && user.password.equals(password.getText())) {
                    loggedIn = true;
                    stage.setScene(mainUI);
                }
            }
            if (!loggedIn) {
                System.out.println("Invalid credentials");
            }
        });

        Button register = new Button("Register");
        register.setOnMouseClicked((event) -> {
            addUser(new Credentials(username.getText(), password.getText()));
            username.clear();
            password.clear();
        });

        HBox buttons = new HBox(login, register);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        VBox panel = new VBox(gp, buttons);

        HBox h = new HBox(panel);
        panel.setAlignment(Pos.CENTER);
        h.setAlignment(Pos.CENTER);

        setRoot(h);
    }

    public ArrayList<Credentials> getUsers() {
        ArrayList<Credentials> output = new ArrayList<>();
        try {
            CSV file = new CSV(core.IO.readFile(new File(Program.USERS_PATH.toURI())));
            for(CSV row : file.getSplitBy("\n")) {
                Iterator<String> iter = row.iterator();
                String username = iter.next();
                String password = iter.next();
                Credentials user = new Credentials(username, password);
                output.add(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {

        }
        return output;
    }
    
    public void addUser(Credentials user) {
        String s = "\n" + user.username + "," + user.password;
        try {
            try {
                FileWriter writer = new FileWriter(new File(Program.USERS_PATH.toURI()),true);
                writer.append(s);
                writer.close();
            } catch (URISyntaxException e) {

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
