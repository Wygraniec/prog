#include <cstdio>
#include <math.h>

float twierdzeniePitagorasa(float przyprostokatnaX, float przyprostokatnaY) {
    float odleglosc = sqrt(pow(przyprostokatnaX, 2) + pow(przyprostokatnaY, 2));
    return odleglosc;
}

int main()
{
    float x1, y1, x2, y2;

    printf("Obliczanie odleg³osci pomiêdzy dwoma punktami w kartezjanskim ukladzie wspolrzednych\n");
    
    printf("Podaj wspolrzedna X pierwszego punktu: "); scanf_s("%f", &x1);
    printf("Podaj wspolrzedna Y pierwszego punktu: "); scanf_s("%f", &y1);
    printf("Podaj wspolrzedna X drugiego punktu: "); scanf_s("%f", &x2);
    printf("Podaj wspolrzedna Y drugiego punktu: "); scanf_s("%f", &y2);

    printf("\nOdleglosc miedzy tymi punktami wynosi %f", twierdzeniePitagorasa(x2 - x1, y2 - y1));
}
