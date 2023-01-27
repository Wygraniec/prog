/*
* Tu mnie nie było, ale zaadnka to se zrobię xD
*/
#include <stdio.h>
#include <algorithm>
#define SIZE 4

void wypiszTablice1D(float* tab, unsigned int size) {
    printf("\n");
    for (int i = 0; i < size; i++)
        printf(" %3.1f ", tab[i]);
    printf("\n");
}

void wypiszTablice2D(float(&tab)[SIZE][SIZE]) {
    printf("\n");
    for (unsigned int i = 0; i < SIZE; i++) {
        for (unsigned int j = 0; j < SIZE; j++)
            printf("%8.2f", tab[i][j]);
        printf("\n");
    }
    printf("\n");
}

float sredniaTab(float(&tab)[SIZE][SIZE]) {
    float suma = 0;
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            suma += tab[i][j];

    return suma / (SIZE * SIZE);
}

float mediana(float(&tab)[SIZE][SIZE]) {
    const unsigned int rozmiarTablicy = SIZE * SIZE;
    float liczby[rozmiarTablicy] = {0};
    
    for(int i = 0, l = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++) {
            liczby[l] = tab[i][j];
            l++;
        }

    std::sort(&liczby[0], &liczby[rozmiarTablicy - 1]);

    float mediana;

    if (rozmiarTablicy % 2 != 0) {
        //Nieparzysta ilość elementów - mediana to środkowa wartość
        mediana =  liczby[(rozmiarTablicy - 1) / 2];
    } else {
        //Parzysta ilość elementów - mediana to średnia arytmetyczna 2 wartości środkowych
        mediana = (liczby[rozmiarTablicy / 2 - 1] + liczby[rozmiarTablicy / 2]) / 2;
    }
    return mediana;
}

int main() {
    float liczby[SIZE][SIZE] = { 0 };

    for (unsigned int i = 0; i < SIZE; i++) {
        for (unsigned int j = 0; j < SIZE; j++) {
            printf("Podaj liczbe o indeksie %i, %i: ", i, j);
            scanf_s("%f", &liczby[i][j]);
        }
    }

    wypiszTablice2D(liczby);
    
    printf("Srednia liczb w tablicy to %f\n", sredniaTab(liczby));
    printf("Mediana wynosi %f", mediana(liczby));

    return 0;
}
