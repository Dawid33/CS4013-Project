package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ui.Settings;


public class SettingsIO {
    public static Settings loadSettings() throws IOException {
        Settings state = new Settings();

        try (FileInputStream fIn = new FileInputStream(Program.SAVE_FILE_PATH)) {
            ObjectInputStream in = new ObjectInputStream(fIn);
            try {
                state = (Settings)in.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception.");
            } catch (IOException e) {

            } finally {
                in.close();
                fIn.close();
            }
        } catch (FileNotFoundException e) {
            saveSettings(state);
            return state;
        }
        return state;
    }

    public static void saveSettings(Settings state) throws IOException {
        File settingsFile = new File(Program.SAVE_FILE_PATH);

        if (settingsFile.exists()) {
            if (!settingsFile.delete()) {
                throw new IOException("Cannot delete save file.");
            } else {
                settingsFile.createNewFile();
            }
        } else {
            settingsFile.createNewFile();
        }

        FileOutputStream fOut = new FileOutputStream(settingsFile);
        ObjectOutputStream out = new ObjectOutputStream(fOut);
        out.writeObject(state);
        out.close();
        fOut.close();
    }
}
