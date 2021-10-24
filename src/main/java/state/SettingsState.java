package state;

import ui.Theme;

public class SettingsState implements java.io.Serializable{
    public Theme theme;

    public SettingsState() {
        this.theme = Theme.Blue;
    }
}