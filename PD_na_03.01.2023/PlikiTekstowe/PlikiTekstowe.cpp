#include <stdio.h>
#include <stdlib.h>

#ifdef _WIN32
#include <windows.h>
#endif

#define SIZE 100
#define EOL '\n'
//#define DEBUG

void pause() {
#ifdef _WIN32
    system("pause");
    system("cls");
#else
    printf("Nacisnij dowolny klawisz aby kontynuowac dzialanie programu \n\n\n");
    getchar();
#endif
}

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
    } else {
#ifdef DEBUG
        printf("Plik o nazwie '%s' otwarty pomyslnie w trybie '%s'\n", fileName, mode);
#endif
    }
}

int main() {
    char input[SIZE]{ 0 }, c{ 0 };
    FILE* plik;

#ifdef DEBUG
    openFile(&plik, "a");  
    printf("Wpisanie tekstu od dlugosci nie wiekszej niz %d znakow i zapisanie go w pliku\n", SIZE);
    gets_s(input, SIZE);
    fputs(input, plik);
    fputs("\n", plik);
    fclose(plik);
    
    openFile(&plik, "r");
    c = fgetc(plik);
    while (c != EOF) {
        printf("%c", c);
        c = fgetc(plik);
    }
    fclose(plik);

    openFile(&plik, "r+");
    for (int i = 3; ; i++) {
        fseek(plik, -1 * i, SEEK_END);
        char c = fgetc(plik);
        if (c == EOL) {
            fseek(plik,  - 1 * i + 1, SEEK_END);
            fgets(input, i, plik);
            break;
        }
    }
    puts(input);
    fclose(plik);

#else
    while (true) {
        int wybor{ 0 };
        printf("0. Zakoncz dzialanie programu\n");
        printf("1. Wpisanie zdania i dopisanie go do pliku\n");
        printf("2. Wypisanie zawartosci pliku w konsoli\n");
        printf("3. Wypisanie ostatniej linijki z pliku w konsoli\n");
        printf("Wybor: "); scanf_s("%i", &wybor);

        switch (wybor) {
        case 0:
            exit(0);
            break;
        case 1:
            openFile(&plik, "a");
            printf("Podaj zdanie: ");
            getchar();
            gets_s(input, SIZE);
            fputs(input, plik);
            fputs("\n", plik);
            fclose(plik);
            break;
        case 2:
            openFile(&plik, "r");
            c = fgetc(plik);
            while (c != EOF) {
                printf("%c", c);
                c = fgetc(plik);
            }
            pause();
            fclose(plik);
            break;
        case 3:
            openFile(&plik, "r+");

            for (int i = 3; ; i++) {
                fseek(plik, -1 * i, SEEK_END);
                c = fgetc(plik);
                if (c == EOL) {
                    fseek(plik, -1 * i + 1, SEEK_END);
                    fgets(input, i, plik);
                    break;
                }
            }
            puts(input);
            fclose(plik);
            pause();
            break;
        default:
            printf("Podano niewlasciwe polecenie\n");
            pause();
            break;     
        }

    }
#endif


    return 0;
}
