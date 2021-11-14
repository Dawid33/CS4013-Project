package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.util.StringConverter;
import javafx.util.converter.DateTimeStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class CSV implements Iterable<String> {
    String contents = "";

    public CSV(String contents) {
        this.contents = contents;
    }

    private class CSVFileIterator implements Iterator<String> {
        private int index = 0;

        public boolean hasNext() {
            boolean exists = false;
            if (index >= contents.length() - 1)
                return false;

            for (int i = index; i < contents.length(); i++) {
                char c = contents.charAt(i);
                if (c != '\n') {
                    exists = true;
                    break;
                }
            }

            return exists;
        }

        public String next() {
            if (hasNext()) {
                String output = "";
                for (; index < contents.length(); index++) {
                    char c = contents.charAt(index);

                    if (c == '\n') {
                        if (output != "") {
                            break;
                        } else {
                            continue;
                        }
                    }

                    if (c == ',') {
                        index++;
                        break;
                    }

                    output = output + c;
                }
                return output;
            } else {
                return null;
            }
        }
    }
    
    public Iterator<String> iterator() {
        return new CSVFileIterator();
    }

    public ArrayList<CSV> getRows() {
        ArrayList<CSV> rows = new ArrayList<>();
        for(String s : contents.split("\n")) {
            rows.add(new CSV(s));
        }
        return rows;
    }
}