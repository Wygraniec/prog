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
