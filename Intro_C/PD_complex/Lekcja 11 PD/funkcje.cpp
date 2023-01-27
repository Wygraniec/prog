//----------------------------------------------------------------------------------------------------------------------
//Zeby wejsc w tryb debugowania trzeba zdefiniowac DEBUG (#define DEBUG) w odpowiednim pliku (main.cpp lub funkcje.cpp)
//----------------------------------------------------------------------------------------------------------------------

#include <stdio.h>
#include "funkcje.h"

void wypiszTablice(float* tab, int size) {
    printf("\n");
    for (int i = 0; i < size; i++)
        printf(" %5.2f ", *(tab + i));
    printf("\n");
}

float znajdzValMax(float* tab, int size) {
    float valMax = *tab;

    for (int i = 0; i < size; i++)
        if (valMax < *(tab + i))
            valMax = *(tab + i);

#ifdef DEBUG
    printf("valMax w funkcji: %f\n", valMax);
#endif

    return valMax;
}

float znajdzValMin(float* tab, int size) {
    float valMin = *tab;

    for (int i = 0; i < size; i++)
        if (valMin > *(tab + i))
            valMin = *(tab + i);

#ifdef DEBUG
    printf("valMin w funkcji: %f\n", valMin);
#endif
    return valMin;
}

void wypelnijTablice(float* tab, int size) {
    for (int i = 0; i < size; i++) {
        printf("Podaj element o indeksie %i: ", i);
        scanf_s("%f", tab + i);
    }
}

void zamienNajwiekszeNajmniejsze(float* tab, int size, float valMin, float valMax) {
    for (int i = 0; i < size; i++) {
        if (*(tab + i) == valMax) {
            *(tab + i) = valMin;
            continue;
        }

        if (*(tab + i) == valMin) {
            *(tab + i) = valMax;
            continue;
        }
    }
}

float srednia(float* tab, int size) {
    float suma = 0;
    for (int i = 0; i < size; i++)
        suma += *(tab + i);
    return suma / size;
}

static void swap(float* a, float* b) {
    float temp = *a;
    *a = *b;
    *b = temp;
}

void sortuj(float* tab, int size) {
    for (int i = 0; i < size; i++)
        for (int j = i; j < size; j++)
            if (*(tab + 1) > *(tab + j))
                swap(tab + 1, tab + j);
            
}


float mediana(float* tab, int size) {
    float temp[10] { 0 };

    for (int i = 0; i < size; i++)
        *(temp + i) = *(tab + i);

    sortuj(temp, 10);

    if (size % 2 != 0) {
        //Nieparzysta ilość elementów - mediana to środkowa wartość
        return *(tab + (size - 1) / 2);
    } else {
        //Parzysta ilość elementów - mediana to średnia arytmetyczna 2 wartości środkowych
        return ( * (tab + size / 2 - 1) + *(tab + size / 2)) / 2;
    }
}
