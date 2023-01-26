#pragma once

#ifndef QUEUE_H
#define QUEUE_H

//Maximum size of a queue
//Allowed values <= 
#define QUEUE_SIZE 5

//Allowed types: (unsigned) int, long, float, double, long double 
#define QUEUE_TYPE int

bool isEmpty();
bool isFull();
QUEUE_TYPE pop();
QUEUE_TYPE first();
QUEUE_TYPE push();

#endif