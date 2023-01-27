#include <stdio.h>
#include "queue.h"
#define DEBUG
#define SIZE 5

int tab[SIZE]{ 0 };
int id = 0;

void moveByOne(int* tab) {
    int temp = tab[0];
    for (int i = 0; i < SIZE - 1; i++) {
        tab[i] = tab[i + 1];
    }
    tab[SIZE - 1] = temp;
}

int pop() {
    int temp = 0;
    if (!isEmpty) {
        temp = tab[0];
        id--;
        moveByOne(tab);
    }

	return temp;
}

void add(int num) {
    if (!isFull()) {
        tab[id] = num;
        id++;
    }
}

int first() {
    if (!isEmpty())
        return tab[id - 1];
    
    return tab[0];
}

bool isFull() { return (id == SIZE - 1) ? true : false; }

bool isEmpty() { return (id == 0) ? true : false; }
