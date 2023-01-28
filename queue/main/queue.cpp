#include <stdio.h>
#include "queue.h"

QUEUE_TYPE queue[QUEUE_SIZE] = { 0 };
	
// Index where push function will be executed
size_t nextPushID = 0;

// Index of the next element on which pop() function will be executed
size_t nextPopID = 0;

// Counter of elements currently stored in the queue
unsigned int elementsCounter = 0;

bool isEmpty() { return (elementsCounter == 0) ? true : false; }

bool isFull() { return (elementsCounter == QUEUE_SIZE) ? true : false; }

QUEUE_TYPE pop() {
	QUEUE_TYPE temp = queue[nextPopID];;
	nextPopID++;

	if (nextPopID >= 5)
		nextPopID = 0;

	elementsCounter--;

	return temp;
}

QUEUE_TYPE first() { return queue[nextPopID]; }

void push(QUEUE_TYPE val) {
	queue[nextPushID] = val;
	nextPushID++;

	if (nextPushID >= 5)
		nextPushID = 0;

	elementsCounter++;
}
