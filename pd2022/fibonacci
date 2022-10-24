#include <stdio.h>
#include <windows.h>

unsigned int fibonacci(int liczba) {
	if(liczba == 0)
		return 0;
	if(liczba == 1)
		return 1;
	
	return fibonacci(liczba - 1) + fibonacci(liczba - 2);
}

int main() {
	int ktoraLiczba;
		
	while (1) {
		printf("Podawanie liczby x z ciagu Fibonacciego\nPodaj liczbe: "); scanf("%i", &ktoraLiczba);
		if(ktoraLiczba >= 0)
			printf("%i liczba z ciagu Fibonacciego to %i\n", ktoraLiczba, fibonacci(ktoraLiczba));
		else
			printf("Nie mozna obliczyc ujemnej liczby z ciagu xD\n");
		system("pause");
		system("cls");	
	}
}
