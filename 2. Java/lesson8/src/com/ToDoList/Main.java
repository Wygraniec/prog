package com.ToDoList;

import java.util.Scanner;

public class Main {
    private static void printMenu(){
        System.out.println("0. Zakończ program");
        System.out.println("1. Wypisz zadania");
        System.out.println("2. Dodaj zadanie");
        System.out.println("3. Usuń zadanie");
        System.out.println("4. Wyczyść listę zadań");
    }

    /**
     * Processes the input from console for the user to add a new task to the list
     * @param list Tasks list to which the task will be added
     * */
    private static void addTask(Tasks list) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Podaj nazwę zadania: ");
        String name = stdin.nextLine();

        System.out.print("Podaj opis zadania: ");
        String desc = stdin.nextLine();

        list.add( new Task(name, desc) );
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Tasks toDoList = new Tasks();

        while(true) {
            System.out.println("Lista zadań do wykonania");

            printMenu();
            System.out.print("Wybór: ");
            int selection = stdin.nextInt();
            stdin.nextLine(); // Clearing buffer

            switch(selection) {
                case 0 -> System.exit(0);
                case 1 -> {
                    System.out.println("Chcesz wyświetlić indeksy zadań? (1 - tak; 0 - nie)");
                    int ids = stdin.nextInt();

                    if(ids == 0) toDoList.print(false);
                    else if (ids == 1) toDoList.print(true);
                    else System.out.println();
                }
                case 2 -> addTask(toDoList);
                case 3 -> {
                    toDoList.print(true);

                    System.out.print("Podaj ID zadania, które chcesz usunąć: ");
                    int id = stdin.nextInt();

                    toDoList.remove(id);
                }
                case 4 -> toDoList.clear();
                default -> System.out.println("Podano błędną liczbę");
            }
        }

    }
}