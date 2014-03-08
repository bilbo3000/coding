#include <iostream> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
} Node; 

class Queue {
private: 
    Node * head; 
    Node * tail; 
    
public: 
    // Constructor 
    Queue(){
        head = NULL; 
        tail = NULL; 
    }
    
    // Destructor 
    ~Queue(){
        while (head != NULL){
            Node * temp = head; 
            delete head; 
            head = temp->next; 
        }
        
        tail = NULL; 
    }
    
    // Enqueue
    void Enqueue(int x) {
        Node * newNode = new Node(); 
        newNode->value = x; 
        newNode->next = NULL; 
        
        if(head == NULL){  // Queue is empty
            head = newNode; 
            tail = newNode; 
        }
        else {
            tail->next = newNode; 
            tail = newNode; 
        }
    }
    
    // Dequeue 
    int Dequeue(){
        if(head == NULL){
            cout << "Cannot dequeue from empty list" << endl; 
            return -1; 
        }
        else{
            int result = head->value; 
            Node * temp = head; 
            delete head; 
            head = temp->next; 
            
            return result; 
        }
    }
    
    // Print 
    void PrintQueue(){
        Node * curr = head; 
        while(curr != NULL) {
            cout << curr->value << " "; 
            curr = curr->next; 
        }
        cout << endl; 
    }
}; 

// Test driver 
int main(){
    Queue q; 
    cout << q.Dequeue() << endl;  // Dequeue empty queue 
    
    q.Enqueue(11);  // Enqueue empty queue
    q.Enqueue(12); 
    q.Enqueue(13); 
    
    q.PrintQueue(); 
    
    cout << q.Dequeue() << endl; 
    
    q.PrintQueue(); 
    
    q.Dequeue(); 
    q.Dequeue(); 
    q.Dequeue(); 
     
    return 0; 
}
