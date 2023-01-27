#include <stdio.h>
#define SIZE 4

void wypiszTablice(float(&tab)[SIZE][SIZE]) {
    printf("\n");
    for (unsigned int i = 0; i < SIZE; i++) {
        for (unsigned int j = 0; j < SIZE; j++)
            printf("%8.2f", tab[i][j]);
        printf("\n");
    }
    printf("\n");
}

int main() {
    float liczby[SIZE][SIZE] = {0};
    
    for (unsigned int i = 0; i < SIZE; i++) {
        for (unsigned int j = 0; j < SIZE; j++) {
            printf("Podaj liczbe o indeksie %i, %i: ", i, j);
            scanf_s("%f", &liczby[i][j]);
        }
    }

    wypiszTablice(liczby);

    float valMin = liczby[0][0];
    float valMaks = liczby[0][0];

    //Znajdowanie najwiekszej i najmniejszej wartosci
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (valMin > liczby[i][j]) 
                valMin = liczby[i][j];
            
            if (valMaks < liczby[i][j])
                valMaks = liczby[i][j];
            
        }
    }
    
    printf("Najmniejsza wartosc to %2.2f\nNajwieksza wartosc to %2.2f\n", valMin, valMaks);

    //Zamiana wartosci najwiekszych z najmniejszymi i vice versa
    for (int i = 0; i < SIZE; i++) 
        for (int j = 0; j < SIZE; j++) {
            if (liczby[i][j] == valMin) {
                liczby[i][j] = valMaks;
                continue;
            }

            if (liczby[i][j] == valMaks) {
                liczby[i][j] = valMin;
                continue;
            }
        }
    
    wypiszTablice(liczby);

    return 0;
}
