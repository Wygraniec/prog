/* Notateczki
*   Dostęp sekwencyjny:
*  fputs() -> puts string
*  fgets() -> get string
*  feof() -> end of file
*   Tryb otwarcia:
*       "w" -> write; tworzy nowy plik
*       "r" -> read; odczyt z istniejącego pliku
*       "a" -> append; dodanie informacji do istniejącego pliku; tworzenie nowego
* 
* Dostęp swobodny:
*   fseek(wskaznik plikowy, (long) wartosc, poczatek (SEEK_SET; poczatek pliku || SEEK_CUR; bieżąca pozycja || SEEK_END; koniec pliku)) -> przesuniecie wskaznika o x w prawo
*  fputc() -> puts char
*  fscanf() -> scanf ale to pliku xD 
*   Tryb otwarcia:
*       "w+" -> write; tworzy nowy plik
*       "r+" -> read; odczyt z istniejącego pliku
*       "a+" -> append; dodanie informacji do istniejącego pliku; tworzenie nowego
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#ifdef _WIN32
#include <windows.h>
#endif

#define DEBUG
    
int main() {
    

    FILE* fileWrite{ NULL }, *fileRead{ NULL };
    errno_t errorFileWrite = fopen_s(&fileWrite, "task.txt", "a");
    

    if (errorFileWrite) { 
        printf("Blad otwierania pliku");
        exit(1); 
    }


#ifdef DEBUG
    char input[100];

    printf("Zdanie do zapisu: ");
    gets_s(input);
    fputs(input, fileWrite);
    fprintf(fileWrite, "\n");
    fclose(fileWrite);

    errno_t errorFileRead = fopen_s(&fileRead, "task.txt", "r");
    if (errorFileRead) {
        printf("Blad otwierania pliku");
        exit(1);
    }

    printf("Tresc pliku: \n");
    while (!feof(fileRead)) {
        char buff[100];
        fgets(buff, 100, fileRead);
        puts(buff);
    }

    fclose(fileRead);

#else 
    while(true)

#endif
    return 0;
}
