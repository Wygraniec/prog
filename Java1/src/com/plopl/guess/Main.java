package com.plopl.guess;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //Function returning random number from range [0, max]
    public static int getRandNum(int max) {
        //Creating a Random class object
        Random randomizer = new Random();
        return randomizer.nextInt(max);
    }

    public static void main(String[] args) {
        Scanner stdi = new Scanner(System.in);

        System.out.println("Jak się nazywasz?");
        String name = stdi.nextLine();
        System.out.println("Witaj " + name);

        System.out.print("Podaj ilość wylosowanych liczb: ");
        int amount = stdi.nextInt();

        System.out.print("Podaj górny zakres losowania: ");
        int max = stdi.nextInt();

        for(int i = 0; i < amount; i++) {
            System.out.println(getRandNum(max));
        }

    }
}