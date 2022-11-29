//----------------------------------------------------------------------------------------------------------------------
//Zeby wejsc w tryb debugowania trzeba zdefiniowac DEBUG (#define DEBUG) w odpowiednim pliku (main.cpp lub funkcje.cpp)
//----------------------------------------------------------------------------------------------------------------------

#include <stdio.h>
#include <windows.h>
#include "funkcje.h"
#define SIZE 10

int main() {

    float liczby[SIZE]{ 0 };

    wypelnijTablice(liczby, SIZE);

#ifdef DEBUG
    wypiszTablice(liczby, SIZE);

    printf("valMax: %f \nvalMin: %f\n", znajdzValMax(liczby, SIZE), znajdzValMin(liczby, SIZE));
    zamienNajwiekszeNajmniejsze(liczby, SIZE, znajdzValMin(liczby, SIZE), znajdzValMax(liczby, SIZE));
#endif

    float valMax = znajdzValMax(liczby, SIZE), valMin = znajdzValMin(liczby, SIZE);
    int wybor = 0;

#ifndef DEBUG
    system("cls");

    do {
        wybor = 0;

        printf("Wybierz dzialanie: \n");
        printf("0. Zakoncz program \n");
        printf("1. Wypisz tablice \n");
        printf("2. Wyswietl wartosc maksymalna \n");
        printf("3. Wyswietl wartosc minimalna \n");
        printf("4. Wypelnij ponownie tablice \n");
        printf("5. Zamien miejscami najwieksze elementy z najmniejszymi \n");
        printf("6. Oblicz srednia liczb w tablicy \n");
        printf("7. Oblicz mediane liczb w tablicy \n");
        printf("Wybor: "); scanf_s("%i", &wybor);

        switch (wybor) {
        case 0:
            break;
        case 1:
            wypiszTablice(liczby, SIZE);
            system("pause");
            system("cls");
            break;
        case 2:
            printf("Wartosc maksymalna: %f\n", valMax);
            system("pause");
            system("cls");
            break;
        case 3:
            printf("Wartosc minimalna: %f\n", valMin);
            system("pause");
            system("cls");
            break;
        case 4:
            wypelnijTablice(liczby, SIZE);
            system("pause");
            valMax = znajdzValMax(liczby, SIZE);
            valMin = znajdzValMin(liczby, SIZE);
            system("cls");
            break;

        case 5:
            zamienNajwiekszeNajmniejsze(liczby, SIZE, valMin, valMax);
            printf("\nTablica po zamianie:");
            wypiszTablice(liczby, SIZE);
            system("pause");
            system("cls");
            break;

        case 6:
            printf("\nSrednia liczb w tablicy: %f\n", srednia(liczby, SIZE));
            system("pause");
            system("cls");
            break;

        case 7:
            printf("\nMediana liczb w tablicy: %f\n", mediana(liczby, SIZE));
            system("pause");
            system("cls");
            break;

        default:
            printf("Podano nieprawidlowe polecenie\n");
            system("pause");
            system("cls");
            break;
        }
    } while (wybor != 0);
#endif

    return 0;
}
