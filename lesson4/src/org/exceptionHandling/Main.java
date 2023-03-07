package org.exceptionHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

// TODO (fstream) << 6 random, unique numbers [1-49]

public class Main {
    /** Static method checking whether a specific number is contained within an array */
    private static boolean contains(int[] arr, int searchedValue) {
        for(int num : arr)
            if(num == searchedValue)
                return true;

        return false;
    }

    /** Static method randomizing a number within a given range */
    private static int getRandomInt(int min, int max) {
        Random randomizer = new Random();
        return randomizer.nextInt(max) + min;
    }

    private static File openFile(String path) {
        File file = new File(path);
        try {
            if(file.createNewFile())
                System.out.println("File created successfully in path: " + file.getPath());
            else
                System.out.println("File in path " + file.getPath() + " does exist and is overwritten");
        }  catch (IOException e) {
            System.out.println("There was an error opening/creating the file: " + e.getMessage());
        }
        return file;
    }

    /** Static method saving an array of ints to the file stored in a given path */
    public static void saveToFile(int[] arr, String path) {
        File file = openFile(path);

        try (
                FileWriter writer = new FileWriter(file);
                PrintWriter filePrinter = new PrintWriter(writer);
                ){
            filePrinter.println("Randomized numbers: ");
            filePrinter.println(Arrays.toString(arr));

        } catch(IOException e) {
            System.out.println("An error occurred while saving to the given file" + Arrays.toString(e.getStackTrace()));
        }

    }

    public static void main(String[] args) {
        System.out.println("An application randomizing numbers for Lotto-like game");
        int[] randomizedNumbers = new int[6];

        for(int i = 0; i < 6; i++) {
            int randNumber = getRandomInt(1, 49);
            if(contains(randomizedNumbers, randNumber)) {
                i--;
                continue;
            }
            randomizedNumbers[i] = randNumber;
        }

        saveToFile(randomizedNumbers, "src/Numbers.txt");
        System.out.println(Arrays.toString(randomizedNumbers));

    }
}