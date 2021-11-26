package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ui.Settings;


public class IO {
    
    /** 
     * This function loads a settings object from the default Program.SAVE_FILE_PATH. The file has to be a deserializable version of the object.
     * @return Settings The settings object that has been loaded
     * @throws IOException An IO excetion that signifies problems with reading/writing the save file.
     */
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

    
    /** 
     * This function serializes a settings object into the default file path specified by Program.SAVE_FILE_PATH.
     * @param state The settings object to be saved into a file.
     * @throws IOException An IO excetion that signifies problems with reading/writing the save file.
     */
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

    
    /** 
     * Read contents of a file into a string.
     * @param file The file to be read.
     * @return String The contents of the string
     * @throws IOException The 
     */
    public static String readFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                builder.append(currentLine + '\n');
                currentLine = reader.readLine();
            }
            return builder.toString();
        } catch (IOException e) {
            throw e;
        }
    }
}
