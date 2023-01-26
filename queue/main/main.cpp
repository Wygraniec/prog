#include <stdio.h>
#include "queue.h"

#define DEBUG

#ifdef DEBUG
#include <iostream>
using namespace std;
#endif

#ifdef _WIN32
    #include <Windows.h>
    void printMenu() {
        system("pause");
        system("cls");

        printf("0. Zakoncz program\n");
        printf("1. Dodaj liczbe do kolejki (push)\n");
        printf("2. Odczytaj pierwsza wartosc z kolejki (front)\n");
        printf("3. Usun pierwsza wartosc z kolejki (pop)\n");
        printf("4. Sprawdz, czy stos jest pusty\n");
        printf("5. Sprawdz, czy stos jest pelny\n");
        printf("Wybor: ");
    }
#else 
    void printMenu() {
    printf("\n\n\n");

    printf("0. Zakoncz program\n");
    printf("1. Dodaj liczbe do kolejki (push)\n");
    printf("2. Odczytaj pierwsza wartosc z kolejki (front)\n");
    printf("3. Usun pierwsza wartosc z kolejki (pop)\n");
    printf("4. Sprawdz, czy stos jest pusty\n");
    printf("5. Sprawdz, czy stos jest pelny\n");
    printf("Wybor: ");
    }
#endif

int main() {
    cout << MAX_SID_SIZE;

    return 0;
}
