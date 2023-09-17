// Dynamiczne zarzadzanie pamiecia
/*
* malloc(rozmiar w B) -> zwraca wskaznik uniwersalny do przydzielonego obszaru, jezeli zostal zarezerwowany z powodzeniem
* calloc(iloscElementow, wielkoscElementu) -> tak jak malloc alokuje obszar, ale inicjuje wartosci 0
* realloc(wskaznik, nowyRozmiar) -> zmiana rozmiaru wczesniej przydzielonego obszaru
* free(wskaznik) -> zwolnienie zarezerwowanego obszaru
*/

//Kody błędów:
// 0 - wszystko git
// 1 - błąd otwarcia pliku
// 2 - błąd alokacji tablicy

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
    for (unsigned int i = 0; i < size; i++)
        printf("%d\n", *(tab + i));
}

int main() {
    srand(time(NULL));

#ifdef DEBUG
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
    printf("1, jesli tak\n");
    printf("0, jesli nie\n");
    scanf_s("%d", &wybor);

    switch (wybor) {
    case 0:
        openFile(&plik, "w");
        for (int i = 0; i < ileLiczb; i++)
            fprintf(plik, "%i\n", *(tab + i));
        printf("Pomyslnie zapisano do pliku\n");
        fclose(plik);
        break;
    case 0:
        break;
    default:
        printf("Podano nieprawidlowa liczbe\n\n");
        goto Wybor;
        break;
    }
    



    free(tab);
#else
    int ileLiczb;
    printf("Generator liczb pseudolosowych\n");
    printf("Podaj ilosc losowanych liczb: "); scanf_s("%d", &ileLiczb);
    int* tab = (int*)malloc(ileLiczb * sizeof(int));
    if (tab == NULL) exit(2);
    
    for (int i = 0; i < ileLiczb; i++)
        tab[i] = rand() % 10000;

    while (true) {
        FILE* plik = NULL;
        int wybor;
        printf("0. Zakoncz program\n");
        printf("1. Zmien ilosc liczb\n");
        printf("2. Wyswietl wylosowane liczby w konsoli\n");
        printf("3. Zapisz wylosowane liczby w pliku\n");
        printf("4. Wylosuj liczby na nowo\n");
        printf("Wybor: "); scanf_s("%i", &wybor);

        switch (wybor) {
        case 0:
            exit(0);
            break;
        case 1:
            printf("Podaj nowy rozmiar tablicy: ");
            scanf_s("%d", &ileLiczb);
            if( (int*)realloc(tab, ileLiczb * sizeof(int)) == NULL ) exit(2);
            for (int i = 0; i < ileLiczb; i++) // Dolosowywanie nowych liczb do tablicy
                tab[i] = rand();
#ifdef _WIN32
            system("pause");
            system("cls");
#endif
            break;
        case 2:
            wypiszTablice(tab, ileLiczb);
#ifdef _WIN32
            system("pause");
            system("cls");
#endif
            break;
        case 3:
            openFile(&plik, "w");
            for (int i = 0; i < ileLiczb; i++)
                fprintf(plik, "%i\n", *(tab + i));
            printf("Pomyslnie zapisano do pliku\n");
            fclose(plik);
#ifdef _WIN32
            system("pause");
            system("cls");
#endif
            break;
        case 4:
            for (int i = 0; i < ileLiczb; i++)
                tab[i] = rand() % 10000;
            printf("Wylosowano nowe liczby\n");
#ifdef _WIN32
            system("pause");
            system("cls");
#endif
            break;
        default:
            printf("Podano niepoprawne polecenie\n");
#ifdef _WIN32
            system("pause");
            system("cls");
#endif
            break;
        }

    }
    free(tab);
#endif
    return 0;
}
