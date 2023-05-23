package com.No7_wordsCount.WordsCounters;

import java.io.*;

public class FileWordsCounter extends BaseWordsCounter {
    private File file;

    public FileWordsCounter(String path){ this( new File(path) ); }
    public FileWordsCounter(File file) {
        this.file = file;

        super.text = getTextFromFile();
        super.calculateCount();
    }

    /** Method changing the source file to a different one
     * @param path Path to the new file
     * */
    public void changeSource(String path) { changeSource( new File(path) ); }
    /** Method changing the source file to a different one
     * @param file New file object
     * */
    public void changeSource(File file) {
        this.file = file;
        getTextFromFile();
        super.calculateCount();
    }

    /** Returns a String containing the whole text from a text file */
    private String getTextFromFile() {
        String text = "";
        try( FileInputStream inputStream = new FileInputStream(file); ) {
            byte[] bytes = new byte[ inputStream.available() ];
            inputStream.read(bytes);
            text = new String(bytes);
        } catch (IOException e) {
            System.out.println("There was an error reading from a file");
            e.printStackTrace();
        }
        return text;
    }
}
