#include <stdio.h>

float wartoscBezwzgledna(float liczba) {
    return (liczba < 0) ? -1 * liczba:liczba;
}

int silniaIteracyjnie(int liczba) {
    unsigned int silnia = 1;

    for (int i = liczba; i > 0; i--) silnia *= i;

    return silnia;
}

int silniaRekurencyjnie(int liczbaDoSilni) {
    if (liczbaDoSilni == 1) return 1;
    int nastepnaLiczba = liczbaDoSilni - 1;
    return liczbaDoSilni * silniaRekurencyjnie(nastepnaLiczba);
}

void tabliczkaMnozenia(const int koniec) {
    for (int i = 1, j = 1; i <= koniec && j <= koniec; i++) {
        printf(" %7i ", i * j);
        if (i == koniec) {
            i = 0;
            j++;
            printf("\n");
        }

    }

}

int main() {
    int doSilni, maksMnozenie;
    float doWBezwzglednej;

    printf("Podaj liczbe do obliczenia wartosci bezwzglednej: "); scanf_s("%f", &doWBezwzglednej);
    printf("|%f| = %f", doWBezwzglednej, wartoscBezwzgledna(doWBezwzglednej));

    printf("\n\nPodaj liczbe do obliczenia silnii: "); scanf_s("%i", &doSilni);
    printf("%i! = %i \n", doSilni, silniaRekurencyjnie(doSilni));
    printf("%i! = %i ", doSilni, silniaIteracyjnie(doSilni));

    printf("\n\nPodaj wartosc koncowa tabliczki mnozenia: "); scanf_s("%i", &maksMnozenie);
    tabliczkaMnozenia(maksMnozenie);
}
