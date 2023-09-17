package org.WordsCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class FileStringReader {
    public static String getStringFromFile(String path) throws IllegalArgumentException {
        File f = new File(path);
        if(!f.exists())
            throw new IllegalArgumentException("Such path doesn't exist");

        return getStringFromFile( new File(path) );
    }
    public static String getStringFromFile(File file) {
        StringBuilder text = new StringBuilder();

        try ( Scanner fileInput = new Scanner(file) ) {

            while( fileInput.hasNext() )
                text.append( fileInput.nextLine() ).append(' ');

        } catch(IOException e) {
            return "";
        }

        return text.toString();
    }


}
