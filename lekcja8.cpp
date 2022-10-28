#include <stdio.h>

#define SIZE 4

using namespace std;

void zapelnijTablice(float* tab, rozmiar) {
    for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                printf("Podaj liczbe o indeksie %i, %i: ", i, j);
                scanf_s("%f", &tab[i][j]);
            }
        }
}

void wypiszTablice(float* tab, unsigned int rozmiar){
    for (int i = 0; i < rozmiar; i++) {
        for (int j = 0; j < rozmiar; j++) {
            printf("%8.2f", tab[i][j]);
        }
        printf("\n");
    }
}

int main() {
    float liczby[SIZE][SIZE];
    zapelnijTablice(liczby, SIZE);
    
    wypiszTablice(liczby, SIZE);

    int valMin = liczby[0][0];
    int valMaks = liczby[0][0];
    unsigned int ileNajmniejszych = 0, ileNajwiekszych = 0;
    unsigned int indeksyMin[SIZE][2] = {0};
    unsigned int indeksyMaks[SIZE][2] = {0};

    //Znajdowanie najwiekszej i najmniejszej wartosci
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (valMin > liczby[i][j]) {
                valMin = liczby[i][j];
                iMin = i;
                jMin = j;
            }

            if (valMaks < liczby[i][j]) {
                valMaks = liczby[i][j];
                iMaks = i;
                jMaks = j;
            }
        }
    }

    //Znajdowanie indeksow i ilosci najmniejszych i najwiekszych wartosci
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (liczby[i][j] == valMin) {
                indeksyMin[ileNajmniejszych][0] = i;
                indeksyMin[ileNajmniejszych][1] = j;
                ileNajmniejszych++;              
            }

            if (liczby[i][j] == valMaks) {
                indeksyMin[ileNajwiekszych][0] = i;
                indeksyMin[ileNajwiekszych][1] = j;
                ileNajwiekszych++;
            }
        }
    }
    
    //Zamiana wartosci najmniejszych na najwieksze
    for (int i = 0; i < ileNajmniejszych; i++) {
        liczby[indeksyMin[i][0]][inedksyMin[i][1]] = valMaks;
    }

    //Zamiana wartosci najwiekszych na najmniejsze
    for (int i = 0; i < ileNajmniejszych; i++) {
        liczby[indeksyMaks[i][0]][inedksyMaks[i][1]] = valMin;
    }

    wypiszTablice(liczby, SIZE);
    
    return 0;
}
