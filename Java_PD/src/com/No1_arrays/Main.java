package com.No1_arrays;
import java.util.Scanner;
public class Main {
    static Boolean debug = false;
    public static void printMenu() {
        System.out.println();
        System.out.println("Obsługa tablicy 2D");
        System.out.println("0. Zakończ działanie programu");
        System.out.println("1. Wypisz tablicę");
        System.out.println("2. Wyświetl konkretny element tablicy");
        System.out.println("3. Podaj nową wartość konkretnego elementu tablicy");
        System.out.println("4. Wyświetl najmniejszą wartość w tablicy");
        System.out.println("5. Wyświetl największą wartość w tablicy");
        System.out.println("6. Wyświetl średnią liczb w tablicy");
        System.out.println("7. Wyświetl medianę liczb w tablicy");
        System.out.println();
    }
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.print("Podaj wymiary tablicy (w formacie rozmiarX rozmiarY): ");
        int sizeX = stdin.nextInt();
        int sizeY = stdin.nextInt();

        if(sizeX <= 0 || sizeY <= 0) System.exit(1);

        Array2D<Integer> arr = new Array2D<>(sizeX, sizeY);
        
        for(int rowID = 0; rowID < arr.getSizeX(); rowID++)
            for(int colID = 0; colID < arr.getSizeY(); colID++) {
                System.out.print("Podaj liczbę na indeks [" + rowID + ", " + colID + "]: ");
                arr.setValue(rowID, colID, stdin.nextInt());
            }

        if(debug) {
            arr.print();
            System.out.println("Największa wartość: " + arr.maxVal());
            System.out.println("Najmniejsza wartość: " + arr.minVal());
            System.out.println("Średnia liczb w tablicy: " + arr.average());
            System.out.println("Mediana liczb w tablicy: " + arr.median());
        } else {
            while (true) {
                printMenu();
                System.out.print("Wybór: ");
                int selection = stdin.nextInt();

                int x, y;

                switch (selection) {
                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        arr.print();
                        break;

                    case 2:
                        System.out.print("Podaj indeks x elementu: ");
                        x = stdin.nextInt();

                        System.out.print("Podaj indeks y elementu: ");
                        y = stdin.nextInt();

                        if (x < 0 || x >= arr.getSizeX() || y < 0 || y >= arr.getSizeY()) {
                            System.out.println("Podano niepoprawny indeks elementu");
                            break;
                        } else System.out.println("Wartość na wpisanym indeksie to " + arr.get(x, y));
                        break;

                    case 3:
                        System.out.print("Podaj indeks x elementu: ");
                        x = stdin.nextInt();

                        System.out.print("Podaj indeks y elementu: ");
                        y = stdin.nextInt();

                        if (x < 0 || x >= arr.getSizeX() || y < 0 || y >= arr.getSizeY()) {
                            System.out.println("Podano niepoprawny indeks elementu");
                            break;
                        }

                        System.out.println("Podaj nową wartość elementu: ");
                        int val = stdin.nextInt();
                        arr.setValue(x, y, val);
                        break;

                    case 4:
                        System.out.println("Najmniejsza wartość: " + arr.minVal());
                        break;

                    case 5:
                        System.out.println("Największa wartość: " + arr.maxVal());
                        break;

                    case 6:
                        System.out.println("Średnia liczb w tablicy: " + arr.average());
                        break;

                    case 7:
                        System.out.println("Mediana liczb w tablicy: " + arr.median());
                        break;

                }
            }
        }
    }
}