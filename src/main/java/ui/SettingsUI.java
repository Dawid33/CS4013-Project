package ui;

import core.SettingsIO;
import state.SettingsState;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SettingsUI extends VBox {
    public SettingsUI(UI baseUI, SettingsState state) {
        Text title = new Text("Settings Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);

        RadioButton defaultTheme = new RadioButton("Default");
        RadioButton purpleTheme = new RadioButton("Purple");
        RadioButton unicornTheme = new RadioButton("Unicorn");
        purpleTheme.setUserData(Theme.Purple);
        defaultTheme.setUserData(Theme.Blue);
        unicornTheme.setUserData(Theme.Unicorn);
        ToggleGroup group = new ToggleGroup();
        switch(state.theme) {
            case Blue: defaultTheme.setSelected(true);
                                break;
            case Purple: purpleTheme.setSelected(true);
                                break;
            case Unicorn: unicornTheme.setSelected(true);
                                break;
        }
        defaultTheme.setToggleGroup(group);
        purpleTheme.setToggleGroup(group);
        unicornTheme.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    Theme selectedTheme = (Theme)group.getSelectedToggle().getUserData();
                    baseUI.onThemeChange.accept(selectedTheme);
                    state.theme = selectedTheme;

                    try {
                        SettingsIO.saveSettings(state);
                    } catch (IOException e) {
                        System.out.println("IOException when trying save settings file : " + e.getMessage());
                    }
                }
            } 
        });
        
        getChildren().addAll(centeredTitle, defaultTheme, purpleTheme, unicornTheme);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}
