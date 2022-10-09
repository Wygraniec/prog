#include <stdio.h>
#include <windows.h>
int zadanie1() {
	int nominator, denominator;
	
	printf("Podaj licznik: "); scanf("%i", &nominator);
	printf("Podaj mianownik: "); scanf("%i", &denominator);
	
	printf("%i / %i = %f\n", nominator, denominator, (float) nominator / denominator);
	system("pause");
	
	return 0;
}

int zadanie2() {
	int numbers[3];
	for(int i = 0; i < 3; i++) {
		printf("Podaj liczbe %i: ", ++i);
		scanf("%i", &numbers[--i]);
	}
	for(int i = 0; i < 3; i++) printf("Liczba %i: %i\n", i, numbers[i]);
	system("pause");
	
	return 0;
}

int zadanie3() {
	int number;
	printf("Podaj liczbe: ");
	scanf("%i", &number);
	printf("%i + 1 = %i\n", --number, ++number);
	system("pause");
	
	return 0;
}

int zadanie4() {
	float result = 0;
	int number;
	for(int i = 0; i < 3; i++) {
		printf("Podaj liczbe %i: ", ++i);
		scanf("%i", &number);
		result += number;
		i--;
	}
	result /= 3;
	printf("Srednia tych liczb to %f\n", result);
	system("pause");
	
	return 0;
}

int zadanie5() {
	int nominator, denominator;
	
	printf("Podaj licznik: "); scanf("%i", &nominator);
	printf("Podaj mianownik: "); scanf("%i", &denominator);
	
	printf("%i / %i = %0.2f\n", nominator, denominator, (float) nominator / denominator);
	system("pause");
	
	return 0;
}

int zadanie6() {
	int nominator, denominator;
	
	printf("Podaj licznik: "); scanf("%i", &nominator);
	printf("Podaj mianownik: "); scanf("%i", &denominator);
	
	printf("%i / %i = %e\n", nominator, denominator, (float) nominator / denominator);
	system("pause");
	
	return 0;
}


int main() {
	char wybor;
Poczatek:
	printf("Zadania ze slajdu 86\n");
	printf("Podaj numer zadania\n 1, dzielenie 2 liczb calkowitych\n 2, wczytanie 3 liczb i pokazanie ich w osobnych liniach\n 3, powiekszanie liczby o 1\n 4, srednia arytmetyczna 3 liczb\n 5, dzielenie 2 liczb calkowitych z dokladnoscia do 2 miejsc po przecinku\n 6, dzielenie 2 liczb calkowitych i podanie wyniku w notacji wykladniczej\n Podaj liczbe: "); 
	scanf("%d", &wybor);
	
	switch(wybor) {
		default:
			printf("Nieprawidlowa liczba\n");
			wybor = NULL;
			system("pause");
			system("cls");
			goto Poczatek;	
			break;	
		case 1:
			system("cls");
			zadanie1();	
			break;
		case 2:
			system("cls");
			zadanie2();	
			break;
		case 3:
			system("cls");
			zadanie3();	
			break;
		case 4:
			system("cls");
			zadanie4();	
			break;
		case 5:
			system("cls");
			zadanie5();	
			break;
		case 6:
			system("cls");
			zadanie6();		
			break;
	}
	
	
}