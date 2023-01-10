#include <stdio.h>
#include "queue.h"
#define DEBUG

void menu() {
    printf("\n");
    printf("1 - Dodaj liczbe do kolejki (Push)\n");
    printf("2 - Odczytaj wartosc z przodu kolejki\n");
    printf("3 - Usun wartosc z kolejki\n");
    printf("4 - Sprawdz czy kolejka jest pusty\n");
    printf("5 - Sprawdz czy kolejka jest pelny\n");
    printf("6 - Zamknij program\n");
    printf("\n");
}

int main() { 
#ifdef DEBUG

    int tab[] = { 10, 6, 2, 18, 5};
    moveByOne(tab);
    for(int i = 0; i < 5; i++)
        printf(" %d ", tab[i]);

#else
    int temp = 0;
    int option = 0;
    printf("Kolejka\n");
    while (true) {
        menu();
        scanf_s("%d", &option);

        switch (option) {
        case 1:
            if (!isFull()) {
                printf("Podaj wartosc: ");
                scanf_s("%d", &temp);
                add(temp);
            }
            else {
                printf("operacja niedozwolona kolejka pelna!!!\n\n");
            }

            break;

        case 2:
            if (!isEmpty()) {
                temp = first();
                printf("Odczytana wartosc: %d", temp);
            }
            else {
                printf("operacja niedozwolona STOS pusty!!!\n\n");
            }

            break;

        case 3:
            if (!isEmpty()) {
                temp = pop();
                printf("Odczytana wartosc: %d", temp);
            }
            else {
                printf("operacja niedozwolona STOS pusta!!!\n\n");
            }
            break;

        case 4:
            if (isEmpty()) {
                printf("Kolejka jest pusta.\n");
            }
            else {
                printf("Kolajka nie jest pusta.\n");
            }
            break;

        case 5:
            if (isFull()) {
                printf("Kolejka jest pelna.\n");
            }
            else {
                printf("Kolejka nie jest pelna.\n");
            }
            break;

        case 6:
            //zakonczenie programu
            return 0;

        default:
            printf("Wybierz wlasciwa opcje.\n\n");
            break;
        }
    }
#endif 
    
    return 0;
}
