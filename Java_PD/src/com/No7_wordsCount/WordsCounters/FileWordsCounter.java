package com.No7_wordsCount.WordsCounters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class FileWordsCounter extends BaseWordsCounter {
    private File file;

    /** @param path Path to a file from which the text shall be extracted */
    public FileWordsCounter(String path) throws FileNotFoundException {
        changeSource(path);
    }
    /** @param file File from which the text shall be extracted */
    public FileWordsCounter(File file) throws FileNotFoundException {
        changeSource(file);
    }

    /** Method changing the source file to a different one
     * @param path Path to the new file
     * */
    public void changeSource(String path) throws FileNotFoundException {
        changeSource( new File(path) );
    }
    /** Method changing the source file to a different one
     * @param file New file object
     * */
    public void changeSource(File file) throws FileNotFoundException {
        if( !file.exists() )
            throw new FileNotFoundException("There is no such file");

        this.file = file;
        super.setText( getTextFromFile() );
    }

    /**
     * Reads a text file
     * @return String containing all the data from the .txt file
     * */
    private String getTextFromFile() {
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
