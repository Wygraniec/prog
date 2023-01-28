#pragma once

#ifndef QUEUE_H

#define QUEUE_H

// Maximum size of the queue in elements 
// It's size in bytes is QUEUE_SIZE * sizeof(QUEUE_TYPE)
#define QUEUE_SIZE 5

// Type of elements in the queue
// Allowed types: (unsigned) int, long, float, double, long double 
#define QUEUE_TYPE float

// Checks if the queue is empty
bool isEmpty();

// Checks if the queue is full
bool isFull();

// Deletes first element of the queue and returns it
QUEUE_TYPE pop();

// Returns the first element of the queue (without removing)
QUEUE_TYPE first();

// Adds new element to the queue
void push(QUEUE_TYPE);

#endif