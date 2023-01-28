#include <stdio.h>
#include "queue.h"

QUEUE_TYPE queue[QUEUE_SIZE] = { 0 };

size_t nextPushID = 0;
size_t nextPopID = 0;

bool isEmpty() {
	return false;
}

bool isFull() {
	return false;
}

QUEUE_TYPE pop() {
	return 1;
}

QUEUE_TYPE first() {
	return queue[nextPopID];
}

void push(QUEUE_TYPE val) {
	queue[nextPushID] = val;
	nextPushID++;
}

void printTab() {
	printf("\n");
	for (size_t i = 0; i < QUEUE_SIZE; i++)
		printf("%5d", queue[i]);
	printf("\n");
}