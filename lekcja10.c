#include <stdio.h>
#include <windows.h>
#define SIZE 10
//#define DEBUG

void wypiszTablice(float* tab, int size) {
    printf("\n");
    for (int i = 0; i < size; i++)
        printf(" %5.2f ", *(tab + i));
    printf("\n");
}

void wypelnijTablice(float* tab, int size) {
    for (int i = 0; i < size; i++)
        scanf_s("%f", tab + 1);
}

float znajdzValMax(float* tab, int size) {
    float valMax = *tab;

    for (int i = 0; i < size; i++)
        if(valMax > *(tab + i))
            valMax = *(tab + i);

#ifdef DEBUG
    printf("valMax w funkcji: %f", valMax);
#endif

    return valMax;
}

float znajdzValMin(float* tab, int size) {
    float valMin = *tab;

    for (int i = 0; i < size; i++) 
        if (valMin < *(tab + i))
            valMin = *(tab + i);

#ifdef DEBUG
    printf("valMin w funkcji: %f", valMin);
#endif
        return valMin;
}

int main() {

    float liczby[SIZE]{0};

    for (int i = 0; i < SIZE; i++) {
        printf("Podaj element o indeksie %i: ", i);
        scanf_s("%f", liczby + i);
    }

#ifdef DEBUG
    wypiszTablice(liczby, SIZE);

    printf("valMax: %f \nvalMin: %f\n", znajdzValMax(liczby, SIZE), znajdzValMin(liczby, SIZE));
#endif

    int wybor = 0;

#ifndef DEBUG
    system("cls");
    float valMax = 0, valMin = 0;
    do {
        wybor = 0;

        printf("Wybierz dzialanie: \n");
        printf("0. Zakoncz program\n");
        printf("1. Kontynuuj dzialanie programu \n");
        printf("2. Wyswietl wartosc maksymalna \n");
        printf("3. Wyswietl wartosc minimalna \n");
        printf("4. Wypilnij ponownie tablice \n");
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
            valMax = znajdzValMax(liczby, SIZE);
            printf("Wartosc maksymalna: %f\n", valMax);
            system("pause");
            system("cls");
            break;
        case 3:
            valMin = znajdzValMax(liczby, SIZE);
            printf("Wartosc minimalna: %f\n", znajdzValMin(liczby, SIZE));
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

    for (int i = 0; i < SIZE; i++) {
        if (*(liczby + i) == valMax) {
            *(liczby + i) = valMin;
            continue;
        }

        if (*(liczby + i) == valMin) {
            *(liczby + i) = valMax;
            continue;
        }
    }

    printf("\n po zamianie wartosci minimalnej z maksymalna: ");
    wypiszTablice(liczby, SIZE);

    return 0;
}
