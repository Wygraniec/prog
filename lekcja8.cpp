// >> Wartoœci ddo tablicy 4x4
// << Wyœwietlenie w formie tabelki

#include <stdio.h>

#define maksTab 4

using namespace std;

int main()
{
    float liczby[maksTab][maksTab];

    for (int i = 0; i < maksTab; i++) {
        for (int j = 0; j < maksTab; j++) {
            printf("Podaj liczbe o indeksie %i, %i: ", i, j);
            scanf_s("%f", &liczby[i][j]);
        }
    }

    for (int i = 0; i < maksTab; i++) {
        for (int j = 0; j < maksTab; j++) {
            printf("%8.2f", liczby[i][j]);
        }
        printf("\n");
    }

    printf("Po zamianie najwiekszego elementu z najmniejszym (jezeli byl tylko 1 taki): \n");

    int valMin = liczby[0][0];
    int valMaks = liczby[0][0];

    /*
    //Znajdowanie najwiekszej i najmniejszej wartosci
    for (int i = 0; i < maksTab; i++) {
        for (int j = 0; j < maksTab; j++) {
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

    //Zamiana wartosci
    float tempVal = liczby[iMaks][jMaks];
    liczby[iMaks][jMaks] = liczby[iMin][jMin];
    liczby[iMin][jMin] = tempVal;

    for (int i = 0; i < maksTab; i++) {
        for (int j = 0; j < maksTab; j++) {
            printf("%8.2f", liczby[i][j]);
        }
        printf("\n");
    }
    */

    

    return 0;
}
