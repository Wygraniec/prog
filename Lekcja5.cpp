#include <cstdio>

void zadanie1() {
    int n, m;
    printf("Podawanie calkowitych liczb n, m i podawanie wszystkich dodatnich iloczynów n, dla ktorych n < m\n");
    printf("Podaj liczbe n: "); scanf_s("%i", &n);
    printf("Podaj liczbe m: "); scanf_s("%i", &m);

    for (int i = 1; ; i++) {
        int iloczyn;
        iloczyn = n * i;
        if (iloczyn > m) break;

        printf("%i\n\n", iloczyn);
    }

}

void zadanie2() {
    unsigned int n;
    printf("Wczytanie liczby n i podanie jej silnii\n");
    printf("Podaj n: "); scanf_s("%i", &n);
    unsigned int silnia = 1;

    for (int i = n; i > 0; i--) silnia *= i;

    printf("Silnia wynosi: %i\n", silnia);
}

bool czyPierwsza(unsigned int liczba) {
    for (int i = 2; i < liczba; i++) 
        if (liczba % i == 0) 
            return false;
    
    return true;
}

void zadanie3() {
    unsigned int n;
    printf("Wczytywanie liczby n i podanie wszystkich liczb pierwszych mniejszej od niej\n");
    printf("Podaj liczbe n: "); scanf_s("%i", &n);

    for (unsigned int i = 0; i < n; i++) 
        if (czyPierwsza(i)) 
            printf("%i\n", i);
    
}

int main() {
    zadanie1();
    zadanie2();
    zadanie3();

    return 0;
}
