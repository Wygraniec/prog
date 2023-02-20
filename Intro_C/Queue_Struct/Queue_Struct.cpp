#include <stdio.h>

// If the system being used is windows, then Windows.h lib is included and system() function is used
// else in place of system("cls") there is printf("\n\n")
#ifdef _WIN32
#include <Windows.h>
inline void printMenu() {
    // Pause programme and waiting for any key to be continued
    printf("\n");
    system("pause");
    printf("\n");

    // Clear the terminal windows
    system("cls");

    // Print the menu
    printf("0. Zakoncz program\n");
    printf("1. Dodaj liczbe do kolejki (push)\n");
    printf("2. Odczytaj pierwsza wartosc z kolejki (front)\n");
    printf("3. Usun pierwsza wartosc z kolejki (pop)\n");
    printf("4. Sprawdz, czy kolejka jest pusta\n");
    printf("5. Sprawdz, czy kolejka jest pelna\n");
    printf("Wybor: ");
}
#else 
inline void printMenu() {
    printf("\n\n\n");

    printf("0. Zakoncz program\n");
    printf("1. Dodaj liczbe do kolejki (push)\n");
    printf("2. Odczytaj pierwsza wartosc z kolejki (front)\n");
    printf("3. Usun pierwsza wartosc z kolejki (pop)\n");
    printf("4. Sprawdz, czy stos jest pusty\n");
    printf("5. Sprawdz, czy stos jest pelny\n");
    printf("Wybor: ");
}
#endif

//Definition of queue
#ifndef QUEUE
#define QUEUE

// Maximum size of the queue in elements 
// It's size in bytes is QUEUE_SIZE * sizeof(QUEUE_TYPE)
#define QUEUE_SIZE 5

struct Queue {
    int arr[QUEUE_SIZE] = { 0 };

    //Index where push() function will be executed
    size_t nextPushID = 0;

    //Index of the next element on which pop() and first() functions will be executed
    size_t nextPopID = 0;

    //Counter of elements currently stored in the queue
    unsigned int elementsCounter = 0;

};

// Checks if the queue is empty
bool queue_isEmpty(Queue* queue) { return (queue->elementsCounter == 0) ? true : false; }

// Checks if the queue is full
bool queue_isFull(Queue* queue) { return (queue->elementsCounter == QUEUE_SIZE) ? true : false; }

// Deletes first element of the queue and returns it
int queue_pop(Queue* queue) {
    int temp = queue->arr[queue->nextPopID];;
    queue->nextPopID++;

    if (queue->nextPopID >= 5)
        queue->nextPopID = 0;

    queue->elementsCounter--;

    return temp;
}

// Returns the first element of the queue (without removing it)
int queue_first(Queue* queue) {
    return queue->arr[queue->nextPopID];
}

// Adds new element to the queue
void queue_push(Queue* queue, int val) {
    queue->arr[queue->nextPushID] = val;
    queue->nextPushID++;

    if (queue->nextPushID >= 5)
        queue->nextPushID = 0;

    queue->elementsCounter++;
}

#endif

int main() {
    Queue kolejka;

    while (true) {
        int selection = 0;
        int inputNum = 0;
        printMenu();
        scanf_s("%d", &selection);

        switch (selection) {
        case 0:
            printf("Wylaczanie programu...\n");
            exit(0);
            break;

        case 1:
            //Add new value
            if (queue_isFull(&kolejka)) {
                printf("Nie mozna dodac nowej wartosci\nKolejka jest pelna");
                break;
            }

            printf("Podaj wartosc: ");
            scanf_s("%d", & inputNum);
            queue_push(&kolejka, inputNum);

            break;

        case 2:
            //Check first value
            if (queue_isEmpty(&kolejka)) {
                printf("Nie mozna odczytac wartosci\nKolejka jest pusta");
                break;
            }

            printf("Pierwsza wartosc: %d", queue_first(&kolejka));

            break;

        case 3:
            //Delete first value and return it
            if (queue_isEmpty(&kolejka)) {
                printf("Nie mozna odczytac wartosci\nKolejka jest pusta");
                break;
            }

            printf("Usunieta wartosc: %d", queue_pop(&kolejka));

            break;

        case 4:
            //Check if empty
            if (queue_isEmpty(&kolejka))
                printf("Kolejka jest pusta");
            else
                printf("Kolejka nie jest pusta");

            break;

        case 5:
            //Check if full
            if (queue_isFull(&kolejka))
                printf("Kolejka jest pelna");
            else
                printf("Kolejka nie jest pelna");

            break;

        default:
            printf("Niepoprawny wybor\n");
            break;

        }

    }

    return 0;
}