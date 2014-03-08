#include <iostream> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
} Node; 

class LinkedList {
private: 
    Node * head; 
    Node * tail; 
public: 
    LinkedList(); 
    ~LinkedList(); 
    void Insert(int x);
    void Reverse(); 
    void Print(); 
}; 

LinkedList::LinkedList() {
    head = NULL; 
    tail = NULL; 
}

LinkedList::~LinkedList() {
    Node * curr = head; 
    
    while (curr != NULL) {
        Node * temp = curr; 
        curr = curr->next; 
        delete temp; 
    }
    
    head = NULL; 
    tail = NULL; 
}

void LinkedList::Insert(int x) {
    Node * newNode = new Node(); 
    newNode->value = x; 
    newNode->next = NULL; 
    
    if (head == NULL) {
        head = newNode; 
        tail = newNode; 
    }
    else {
        tail->next = newNode; 
        tail = tail->next; 
    }
}

void LinkedList::Print() {
    Node * curr = head; 
    
    while (curr != NULL) {
        cout << curr->value << " "; 
        curr = curr->next; 
    }
    
    cout << endl; 
}

void LinkedList::Reverse() {
    Node * curr = head; 
    Node * prev = NULL; 
    
    if (curr == NULL) {  // Empty list 
        return; 
    }
    
    tail = head; 
    
    while (curr != NULL) {  
        Node * temp = curr->next; 
        curr->next = prev; 
        prev = curr; 
        curr = temp; 
    }
    
    head = prev; 
}

// Test driver 
int main() {
    LinkedList ll; 
    ll.Insert(3); 
    ll.Insert(1);
    ll.Insert(6);
    ll.Insert(9);
    ll.Insert(2);
    
    ll.Print(); 
    
    ll.Reverse(); 
    
    ll.Print(); 
    
    return 0; 
}
