#include <stdio.h>
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
