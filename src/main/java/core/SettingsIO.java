package core;

import state.SettingsState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SettingsIO {
    public static SettingsState loadSettings() throws IOException {
        SettingsState state = new SettingsState();
        try (FileInputStream fIn = new FileInputStream(Program.SAVE_FILE_PATH)){
            ObjectInputStream in = new ObjectInputStream(fIn);
            try {
                state = (SettingsState)in.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception.");
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

    public static void saveSettings(SettingsState state) throws IOException {
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
