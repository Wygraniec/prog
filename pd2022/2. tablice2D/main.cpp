#include <stdio.h>
#include <windows.h>
#include "wypisywanie.cpp"
#define SIZE 4

//Zdefiniowanie włącza "tryb deweloperski"
//#define DEBUG 

void bubbleSort(float* tab, unsigned int size) {
    for (int i = 0; i < size; i++)
        for (int j = i; j < size; j++) 
            if (tab[i] > tab[j]) {
                float temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
            
#ifdef DEBUG
	printf("\nPo sortowaniu:");
	wypiszTablice1D(tab, size);
#endif      
}

static float sredniaTab(float(&tab)[SIZE][SIZE]) {
    float suma = 0;
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            suma += tab[i][j];

    return suma / (SIZE * SIZE);
}

static float mediana(float(&tab)[SIZE][SIZE]) {
    const unsigned int rozmiarTablicy = SIZE * SIZE;
    float liczby[rozmiarTablicy] = {0};
    
    for(int i = 0, l = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++) {
            liczby[l] = tab[i][j];
            l++;
        }

#ifdef DEBUG
	printf("\nPo przerzuceniu do tablicy 1D:");
	wypiszTablice1D(liczby, rozmiarTablicy);
#endif

    bubbleSort(liczby, rozmiarTablicy);

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
    float liczby[SIZE][SIZE]{ 0 };

    for (unsigned int i = 0; i < SIZE; i++) {
        for (unsigned int j = 0; j < SIZE; j++) {
            printf("Podaj liczbe o indeksie %i, %i: ", i, j);
            scanf_s("%f", &liczby[i][j]);
        }
    }
	
#ifdef DEBUG
	wypiszTablice2D(liczby);
    
    printf("Srednia liczb w tablicy to %f\n", sredniaTab(liczby));
    printf("Mediana wynosi %f\n\n", mediana(liczby));
#endif	
	
#ifndef DEBUG
	system("cls");

	int wybor;
    do{	
    	printf("Wybierz operacje:\n");    
		printf("0. Wyjscie z programu\n");	
    	printf("1. Srednia arytmetyczna liczb w tablicy\n");
    	printf("2. Mediana liczb w tablicy\n");
    	printf("3. Wyswietlenie tablicy\n"); 	
    	printf("Wybor: "); scanf_s("%i", &wybor);
    	
    	switch(wybor){
			case 0:
    			break;	
    		case 1:
    			printf("Srednia liczb w tablicy to %f\n", sredniaTab(liczby));
    			system("pause");
    			system("cls");
    			break;
    		case 2:
    			printf("Mediana wynosi %f\n", mediana(liczby));	
    			system("pause");
    			system("cls");
    			break;
    		case 3:
    			printf("\n");
    			wypiszTablice2D(liczby);
    			system("pause");
    			system("cls");
    			break;
			default:
    			printf("Nieprawidlowe polecenie");
    			system("pause");
    			system("cls");
				break;	
		}
	} while (wybor != 0);
 #endif       
 
    return 0;
}
