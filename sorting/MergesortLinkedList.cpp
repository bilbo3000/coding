#include <iostream> 
#include <cmath> 
#include <stdlib.h>
#include <fstream>

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
} Node; 

void Mergesort(Node * &a, int size); 
void Merge(Node * &b, Node * &c, Node * &a); 
void PrintList(Node * a);


// Test driver 
int main() {
    string inputFilePath = "data.txt"; 
    ifstream inputFileStream(inputFilePath.c_str()); 
    string line; 
    Node * head = NULL; 
    Node * tail = NULL; 
    int size = 0; 
    
    while(getline(inputFileStream, line)) {
        size++; 
        int value = atoi(line.c_str()); 
        Node * newNode = new Node(); 
        newNode->value = value; 
        newNode->next = NULL; 
        
        if (head == NULL) {  // First node
            head = newNode; 
            tail = head; 
        }
        else {  // Insert at the end 
            tail->next = newNode; 
            tail = tail->next; 
        }
    }
    
    PrintList(head); 
    
    Mergesort(head, size);
    
    PrintList(head);  
    
    return 0; 
}

// Merge sort 
void Mergesort(Node * &a, int size) {
    if (size > 1) {
        int size_b = floor(size / 2);
        int size_c = size - size_b; 
        
        Node * b; 
        Node * c; 
        Node * curr = a; 
        Node * prev = NULL; 
        
        for (int i = 0; i < size_b; i++) {
            prev = curr; 
            curr = curr->next;  
        } 
        
        prev->next = NULL; 
        b = a; 
        c = curr; 
        a = NULL;
        
        // Merge sort each half         
        Mergesort(b, size_b);
        Mergesort(c, size_c);
        
        // Merge 
        Merge(b, c, a); 
    }  
}

// Merge in merge sort 
void Merge(Node * &b, Node * &c, Node * &a) { 
    Node * i = b;  // Tail of b
    Node * j = c;  // Tail of c
    Node * k = a;  // Tail of a
    
    while (i != NULL && j != NULL) { 
        if (i->value < j->value) { // b -> a
            if (k == NULL) {
                a = i; 
                k = i; 
            }
            else {
                k->next = i; 
                k = k->next; 
            }
            
            i = i->next; 
            k->next = NULL; 
        }
        else {  // c -> a
            if (k == NULL) {
                a = j; 
                k = j; 
            }
            else {
                k->next = j; 
                k = k->next; 
            }
            
            j = j->next; 
            k->next = NULL; 
        }
    }
    
    if (i == NULL) {  // Done with b, copy rest of c
        k->next = j; 
    }
    else {  // Done with c, copy rest of b
        k->next = i;
    }
} 

// Print linked list 
void PrintList(Node * a) {
    Node * curr = a; 
    
    while (curr != NULL) {
        cout << curr->value << " "; 
        curr = curr->next; 
    }
    
    cout << endl; 
}
