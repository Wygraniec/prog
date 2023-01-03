// Dynamiczne zarzadzanie pamiecia
/*
* malloc(rozmiar w B) -> zwraca wskaznik uniwersalny do przydzielonego obszaru, jezeli zostal zarezerwowany z powodzeniem
* calloc(iloscElementow, wielkoscElementu) -> tak jak malloc alokuje obszar, ale inicjuje wartosci 0
* realloc(wskaznik, nowyRozmiar) -> zmiana rozmiaru wczesniej przydzielonego obszaru 
* free(wskaznik) -> zwolnienie zarezerwowanego obszaru
*/

// TODO
// generator liczb pseudolosowych
// cin: iloscLiczb
// cout: tablica (i/lub zapis do pliku)

#include <stdio.h>
#include <random>
;

void openFile(FILE** file, const char* mode = "r", const char* fileName = "file.txt") {
    errno_t error = fopen_s(file, fileName, mode);
    if (error) {
#ifdef DEBUG
        printf("Blad otwarcia pliku\n");
#ifdef _WIN32
        system("pause");
#else
        printf("Nacisnij dowolny klawisz aby zakonczyc program\n");
        getchar();
#endif
#endif
        exit(1);
    }
    else {
#ifdef DEBUG
        printf("Plik o nazwie '%s' otwarty pomyslnie w trybie '%s'\n", fileName, mode);
#endif
    }
}

void wypiszTablice(int* tab, unsigned int size) {
    for (int i = 0; i < size; i++)
        printf(" %d \n", *(tab + i));
}

int main() {
    srand(time(NULL));
    
    int ileLiczb = 0;
    printf("Generator liczb pseudolosowych\n");
    printf("Ilosc liczb do losowania: "); scanf_s("%i", &ileLiczb);

    int* tab = (int*)malloc(ileLiczb * sizeof(int));

    if (rand == NULL) {
        printf("Rezerwowanie obszaru nie powiodlo sie\n");
        return 1;
    }

    for (int i = 0; i < ileLiczb; i++)
        *(tab + i) = rand();

    wypiszTablice(tab, ileLiczb);

Wybor:
    int wybor = 0;
    FILE* plik = NULL;

    printf("Czy chcesz zapisac liczby do pliku?\n");
    printf("Podaj 1, jesli tak\n");
    printf("Podaj 2, jesli nie\n");
    scanf_s("%d", &wybor);

    switch (wybor) {
    case 1:
        openFile(&plik, "w");
        for (int i = 0; i < ileLiczb; i++) 
            fprintf(plik, "%i\n", *(tab + i));
        printf("Pomyslnie zapisano do pliku\n");
        fclose(plik);
        break;
    case 2:
        break;
    default:
        printf("Podano nieprawidlowa liczbe\n\n");
        goto Wybor;
        break;
    }

    free(tab);

    return 0;
}
