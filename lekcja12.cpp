#include <stdio.h>
#define MAKS 100
//#define DEBUG

int dlugoscString(char* word) {
    int dlugosc = 0;

    while (*word) {
        dlugosc++;
        word++;
    }
    return dlugosc;
}

void zamienNaMale(char* word) {
    while (*word) {
        if (*word >= 'A' && *word <= 'Z') {
            *word += 'a' - 'A';
        }
        word++;
    }
}

void zamienNaWielkie(char* word) {
    while (*word) {
        if (*word >= 'a' && *word <= 'z') {
            *word -= 'a' - 'A';
        }    
        word++;
    }
}

int main() {
    char str[MAKS];

    printf("Podaj zdanie: ");
    gets_s(str);

#ifdef DEBUG
    printf("slowo: %s\n", str);

    printf("Dlugosc: %i znakow\n", dlugoscString(str));

    zamienNaWielkie(str);
    printf("W wielkich literach: %s\n", str);
    
    zamienNaMale(str);
    printf("W malych literach: %s\n", str);

#endif  

#ifndef DEBUG
    while (true) {
        int wybor{ 0 };

        printf("Wybierz akcje:\n");
        printf("1. Wyswietl slowo\n");
        printf("2. Wpisz nowe slowo\n");
        printf("2. Wypisz dlugosc slowa\n");
        printf("4. Zamien na wielkie litery\n");
        printf("5. Zamien na male litery\n");
        printf("Wybor: "); scanf_s("%i", &wybor);

        switch (wybor) {
        case 1:
            printf("Slowo: %s\n", str);
            break;

        case 2:
            printf("Podaj zdanie: ");
            getchar();
            gets_s(str);
            break;

        case 3:
            printf("Zdania ma %i znakow\n", dlugoscString(str));
            break;

        case 4:
            zamienNaWielkie(str);
            printf("Po zamianie na wielkie litery: %s\n", str);
            break;

        case 5:
            zamienNaMale(str);
            printf("Po zamianie na male litery: %s\n", str);
            break;

        default:
            printf("Bledne polecenie\n");
            break;
        }
    }
#endif

    return 0;
}
