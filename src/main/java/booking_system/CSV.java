package booking_system;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    
    /** 
     * @return Iterator Get iterator that iterates through elements in the CSV.
     */
    public Iterator<String> iterator() {
        return new CSVFileIterator();
    }

    
    /** 
     * @return ArrayList Get a list of CSV objects that are delimited by a new line.
     */
    public ArrayList<CSV> getSplitBy(String input) {
        ArrayList<CSV> rows = new ArrayList<>();
        for(String s : contents.split(input)) {
            rows.add(new CSV(s));
        }
        return rows;
    }

    
    /** 
     * @param str Add raw content to the CSV
     */
    public void push(String str) {
        contents = contents + str;
    }

    
    /** 
     * @return String Get the string representation of the CSV.
     */
    public String toString() {
        return contents;
    }
}