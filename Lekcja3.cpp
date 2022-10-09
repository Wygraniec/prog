#include <cstdio>

int main() {
    int nominator, denominator;
    printf("Pobieranie liczby wymiernej i podawanie jej wartosci dziesietnej\n");
    
    printf("Podaj licznik: "); 
    scanf_s("%i", &nominator);
    
    printf("Podaj mianownik: "); 
    scanf_s("%i", &denominator);

    printf("%i / %i = %f\n", nominator, denominator, (float)nominator / denominator);
    printf("%i / %i = %0.2f\n", nominator, denominator, (float)nominator / denominator);
    printf("%i / %i = %e\n", nominator, denominator, (float)nominator / denominator);

    return 0;
}
