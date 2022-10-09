#include <stdio.h>
#include <math.h>
int main() {
    float a, b, c, delta;

    printf("Rozwazywanie rownan liniowych i kwadratowych\n");
    
    printf("ax^2 + bx + c\nPodaj a: "); scanf_s("%f", &a);
    printf("Podaj b: "); scanf_s("%f", &b);
    printf("Podaj c: "); scanf_s("%f", &c);

    //Funkcja jest liniowa
    if (a == 0) {
        
        if (b == 0 && c == 0) { //Nieskonczonosc rozwiazan
            printf("Rownanie ma nieskonczenie wiele rozwiazan\n");
            return 0;
        } else if (b == 0 && c != 0) { //Brak rozwiazan
            printf("Rownanie nie ma rozwiazan\n");
            return 0;
        }
    //Jesli zaden z warunkow nie jest spelniony, jest 1 rozwiazanie
        printf("Rozwiazaniem rownania jest x = %f\n", -c / b);
        return 0;
    }

    //Funkcja jest kwadratowa
    delta = pow(b, 2) - 4 * a * c;

    if (delta < 0) {
        printf("Rownanie nie ma rozwiazan\n");
    } else if (delta == 0) {
        printf("Rownanie ma jedno rozwiazane x = %f\n", -b / 2 * a);
    } else if (delta > 0) {
        printf("Rownanie ma 2 rozwiazania\n x = %f \, x = %f\n", (-b - sqrt(delta)) / 2 * a, (-b + sqrt(delta)) / 2 * a);
    }

    return 0;
}
