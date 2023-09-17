package com.No7_wordsCount;

import com.No7_wordsCount.WordsCounters.StringWordsCounter;

import java.security.InvalidKeyException;
import java.util.Scanner;

public class Main {
    /** Prints a menu with all available options to the console */
    private static void printMenu() {
        System.out.println("0. Zamknij program");
        System.out.println("1. Ustaw tekst");
        System.out.println("2. Wypisz wystąpienia wszystkich słów w tekście");
        System.out.println("3. Znajdź ilość wystąpień konkretnego wyrazu w tekście");
    }

    public static void main(String[] args) {
        var stdin = new Scanner(System.in);
        System.out.println("Liczenie wystąpień każdego wyrazu z podanym tekście");

        System.out.println("Podaj zdanie początkowe:");
        var counter = new StringWordsCounter( stdin.nextLine() );

        while(true) {
            printMenu();
            System.out.print("Wybór: ");
            int choice = stdin.nextInt();
            stdin.nextLine();

            switch(choice) {
                case 0 -> System.exit(0);

                case 1 -> {
                    System.out.println("Wpisz nowy tekst do przeszukania");

                    try {
                        counter.changeText(stdin.nextLine());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Podane zdanie nie może być puste");
                    }

                }

                case 2 -> counter.printAllWordCounts();

                case 3 -> {
                    System.out.println("Podaj słowo, którego ilość wystąpień chcesz sprawdzić: ");
                    String word = stdin.next();

                    try {
                        System.out.printf("Słowo \"%s\" wystąpiło %d razy\n", word, counter.getCountFor(word));
                    } catch (InvalidKeyException e) {
                        System.out.println("Podany wyraz nie pojawia się w tekście");
                    }
                }

                default -> System.out.println("Wybrano nieistniejącą opcję");
            }

        }



    }
}
