#pragma once

#ifndef QUEUE_H
#define QUEUE_H

//Maximum size of a queue in elements ( in bytes it is QUEUE_SIZE * sizeof(QUEUE_TYPE) )
#define QUEUE_SIZE 5

//Type of elements in queue
//Allowed types: (unsigned) int, long, float, double, long double 
#define QUEUE_TYPE int

bool isEmpty();
bool isFull();
QUEUE_TYPE pop();
QUEUE_TYPE first();
QUEUE_TYPE push();

#endif