#include <stdio.h>
#include "queue.h"

private:
QUEUE_TYPE queue[QUEUE_SIZE] = { 0 };

size_t nextPushID = 0;
size_t nextPopId = 0;

//public:
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
	return 1;
}

QUEUE_TYPE push(QUEUE_TYPE val) {
	return 1;
}