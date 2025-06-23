#ifndef NODE_HPP
#define NODE_HPP

class SLL; // forward declaration

class Node {
    friend class SLL;  // Allow SLL to access Node's private fields
private:
    char data;
    Node* next;

public:
    Node(char inputData);  // constructor
};

#endif

#include "Node.hpp"

Node::Node(char inputData) {
    data = inputData;
    next = nullptr;
}


#ifndef SLL_HPP
#define SLL_HPP

#include "Node.hpp"

class SLL {
private:
    int size;
    Node* first;
    Node* last;

public:
    SLL();           // constructor
    void push(char); // add node at end
    char pop();      // remove node at end
    int getSize();   // returns size of list
};

#endif

#include "SLL.hpp"
#include <iostream>

SLL::SLL() {
    size = 0;
    first = nullptr;
    last = nullptr;
}

void SLL::push(char c) {
    Node* newNode = new Node(c);   // Create new node
    if (first == nullptr) {        // Empty list
        first = newNode;
        last = newNode;
    } else {
        last->next = newNode;      // Append to last node
        last = newNode;
    }
    size++;
}

char SLL::pop() {
    if (size == 0) {
        std::cerr << "List is empty\n";
        return '\0';
    }

    char data;
    if (size == 1) {
        data = first->data;
        delete first;
        first = nullptr;
        last = nullptr;
    } else {
        // Traverse to node before last
        Node* current = first;
        while (current->next != last) {
            current = current->next;
        }
        data = last->data;
        delete last;
        last = current;
        last->next = nullptr;
    }
    size--;
    return data;
}

int SLL::getSize() {
    return size;
}






#ifndef CAR_HPP
#define CAR_HPP

class Car {
private:
    int speed;    // Variable

public:
    Car();               // Constructor
    void accelerate(int); // Method
};

#endif

#include "Car.hpp"

// Default constructor
Car::Car() {
    speed = 0;
}

// Method definition
void Car::accelerate(int increment) {
    speed += increment;
}