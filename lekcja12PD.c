//Opis funkcji
/*
dlugoscString(word) --> Zwraca ilość znaków w łańcuchu;
argumenty:
(char*) word - łańcuch znaków

zamienNaMale(word) --> Zamienia wszystkie litery w łańcuchu na małe
argumenty:
(char*) word - łańcuch znaków

zamienNaWielkie(word) --> Zamienia wszystkie litery w łańcuchu na wielkie
argumenty:
(char*) word - łańcuch znaków

zamienNaWielkie(word) --> Zamienia wszystkie litery w łańcuchu na wielkie
argumenty:
(char*) word - łańcuch znaków

znajdz(word, character, indeksPoczatkowy = 0) --> Zwraca indeks pierwszego wystapienia znaku w tablicy albo -1, jeśli nie ma takiego znaku
argumenty:
(char*) word - łańcuch znaków
(char) character - znak do znalezienia

pierwszeLiteryWielkie(word) --> Zamienia pierwsze litery w zdaniach na wielkie (w oparciu o znajdowanie spacji)
argumenty:
(char*) word - łańcuch znaków

isPart(tab, character) --> sprawdza, czy dany znak jest częścią innej tablicy i zwraca odpowiednio true albo false
argumenty:
(char*) tab - tablica znaków do przeszukania
(char) character - poszukwany znak

ileSamoglosek(word) --> Zwraca ilość samogłosek w łańcuchu
argumenty:
(char*) word - łańcuch znaków

ileSpolglosek(word) --> Zwraca ilość spółgłosek w łańcuchu
argumenty:
(char*) word - łańcuch znaków

iloscSlow(word) --> Zwraca ilość słów w zdaniu (ilość spacji +1)
argumenty:
(char*) word - łańcuch znaków
*/

#include <stdio.h>
#define MAKS 100

#ifdef _WIN32
#include <windows.h>
#endif

//#define DEBUG

char samogloski[] = { 'a','A', 'e','E', 'i','I', 'o','O', 'u','U', 'y','Y' };

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

int znajdz(char* word, char character) {
    for (int i = 0; *(word + i); i++)
        if (*(word + i) == character)
            return i;

    return -1;
}

bool isPart(char* tab, char character) {
    while (*tab) {
        if (*tab == character)
            return true;
        tab++;
    }

    return false;
}

int ileSamoglosek(char* word) {
    int counter = 0;
    while (*word) {
        if (isPart(samogloski, *word))
            counter++;
        word++;
    }
    return counter;
}

int ileSpolglosek(char* word) {
    int counter = 0;
    while (*word) {
        if (!isPart(samogloski, *word) && *word != ' ')
            counter++;
        word++;
    }
    return counter;
}

int iloscSlow(char* word) {
    int counter = 0;
    while (*word) {
        if (*word == ' ')
            counter++;
        word++;
    }
    return counter + 1;
}

int main() {
    char c; //Bufor, żeby IntelliSense się nie denerwował na "ignorowaną wartość zwrotną" getchar();
#ifdef DEBUG
    char zdanie[] = "Ala ma kota.";
#else
    char zdanie[MAKS];
    printf("Podaj zdanie: ");
    gets_s(zdanie);
#endif

#ifdef DEBUG
    printf("Slowo: %s\n", zdanie);

    printf("Dlugosc: %i znakow\n", dlugoscString(zdanie));
    printf("Samoglosek: %i\n", ileSamoglosek(zdanie));
    printf("Spolglosek: %i\n", ileSpolglosek(zdanie));
    printf("Slow: %i\n", iloscSlow(zdanie));

    zamienNaWielkie(zdanie);
    printf("W wielkich literach: %s\n", zdanie);

    zamienNaMale(zdanie);
    printf("W malych literach: %s\n", zdanie);

    int pos = znajdz(zdanie, 'z');
    if (pos == -1) printf("Nie znaleziono znaku\n");
    else printf("Znak znaleziono na pozycji %i\n", pos);

#else

    while (true) {
        int wybor{ 0 }, pos{ 0 };

        printf("Wybierz akcje:\n");
        printf("0. Zamknij program\n");
        printf("1. Wyswietl slowo\n");
        printf("2. Wpisz nowe slowo\n");
        printf("3. Wypisz dlugosc slowa\n");
        printf("4. Zamien na wielkie litery\n");
        printf("5. Zamien na male litery\n");
        printf("6. Policz samogloski\n");
        printf("7. Policz spolgloski\n");
        printf("8. Policz slowa\n");
        printf("9. Znajdz znak w ciagu\n");
        printf("Wybor: "); scanf_s("%i", &wybor);

        switch (wybor) {
        case 0:
            return 0;
            break;

        case 1:
            printf("Slowo: %s\n", zdanie);
            break;

        case 2:
            printf("Podaj zdanie: ");
            c = getchar();
            gets_s(zdanie);
            break;

        case 3:
            printf("Zdania ma %i znakow\n", dlugoscString(zdanie));
            break;

        case 4:
            zamienNaWielkie(zdanie);
            printf("Po zamianie na wielkie litery: %s\n", zdanie);
            break;

        case 5:
            zamienNaMale(zdanie);
            printf("Po zamianie na male litery: %s\n", zdanie);
            break;

        case 6:
            printf("Zdanie ma: %i samoglosek\n", ileSamoglosek(zdanie));
            break;

        case 7:
            printf("Zdanie ma: %i spolglosek\n", ileSpolglosek(zdanie));
            break;

        case 8:
            printf("Zdanie ma: %i slow\n", iloscSlow(zdanie));
            break;

        case 9:
            char szukanyZnak;
            printf("Podaj znak do wyszukania: ");
            c = getchar();
            scanf_s("%c", &szukanyZnak);

            pos = znajdz(zdanie, szukanyZnak);
            if (pos == -1) 
                printf("Nie znaleziono znaku\n");
            else 
                printf("Znak jest %i znakiem w ciagu\n", pos + 1);

            break;

        default:
            printf("Bledne polecenie\n");
            break;
        }

#ifdef _WIN32
        system("pause");
        system("cls");
#else
        printf("\n\n");
#endif
    }
#endif

    return 0;
}
