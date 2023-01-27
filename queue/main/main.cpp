#include <stdio.h>
#include "queue.h"

// If the system being used is windows, then Windows.h lib is included and system() function is used
// else (system is linux or macos) in place of system("cls") there is printf("\n\n")
#ifdef _WIN32
    #include <Windows.h>
    void printMenu() {
        system("pause");
        system("cls");

        printf("0. Zakoncz program\n");
        printf("1. Dodaj liczbe do kolejki (push)\n");
        printf("2. Odczytaj pierwsza wartosc z kolejki (front)\n");
        printf("3. Usun pierwsza wartosc z kolejki (pop)\n");
        printf("4. Sprawdz, czy kolejka jest pusta\n");
        printf("5. Sprawdz, czy kolejka jest pelna\n");
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

// Returns true if defined queue type is an integer and false if it's a floating point number
inline bool isTypeInt() { return (4.5 == (QUEUE_TYPE)4.5) ? false : true; }

inline void printApropriateFormat(QUEUE_TYPE val) {
    if (isTypeInt())
        printf("%ll", val);
    else
        printf("%f", val);
}

int main() {

    while (true) {
        int selection = 0;
        printMenu();
        scanf_s("%d", &selection);

        switch (selection) {
        case 0:
            printf("Wylaczanie programu...\n");
            exit(0);
            break;

        case 1:
            //Add value
            break;

        case 2:
            //Check first value
            break;

        case 3:
            //Delete first value and return it
            break;

        case 4:
            //Check if empty
            if (isEmpty()) {
                printf("Kolejka jest pusta\n");
            } else {
                printf("Kolejka nie jest pusta\n");
            }
            break;

        case 5:
            //Check if full
            if (isFull()) {
                printf("Kolejka jest pelna\n");
            } else {
                printf("Kolejka nie jest pelna\n");
            }
            break;

        default:
            printf("Niepoprawny wybor\n");
            break;

        }



    }

    return 0;
}
