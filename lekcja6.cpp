#include <stdio.h>

float wartoscBezwzgledna(float liczba) {
    return (liczba < 0) ? -1 * liczba:liczba;
}

unsigned long long silniaIteracyjnie(int liczba) {
    unsigned int silnia = 1;

    for (int i = liczba; i > 0; i--) silnia *= i;

    return silnia;
}

unsigned long long silniaRekurencyjnie(unsigned int liczba) {
    if (liczba == 0) return 1;
    int nastepnaLiczba = liczba - 1;
    return liczba * silniaRekurencyjnie(nastepnaLiczba);
}

void tabliczkaMnozenia(const unsigned int koniec) {
    for (int i = 1, j = 1; i <= koniec && j <= koniec; i++) {
        printf(" %5i ", i * j);
        if (i == koniec) {
            i = 0;
            j++;
            printf("\n");
        }

    }

}

int main() {
    unsigned int doSilni, maksMnozenie;
    float modul;

    printf("Podaj liczbe do obliczenia wartosci bezwzglednej: "); scanf("%f", &modul);
    printf("|%f| = %f", modul, wartoscBezwzgledna(modul));

    printf("\n\nPodaj liczbe do obliczenia silnii: "); scanf("%i", &doSilni);
    printf("%i! = %i \nmetoda rekurencyjna \n", doSilni, silniaRekurencyjnie(doSilni));
    printf("\n%i! = %i \nmetoda iteracyjna \n", doSilni, silniaIteracyjnie(doSilni));

    printf("\nPodaj wartosc koncowa tabliczki mnozenia: "); scanf("%i", &maksMnozenie);
    tabliczkaMnozenia(maksMnozenie);
}
