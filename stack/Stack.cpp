#include <iostream> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
} Node; 

class Stack {
private: 
    Node * top; 
public: 
    // Constructor 
    Stack(){
        top = NULL; 
    }
    
    // Destructor 
    ~Stack() {
        Node * temp; 
        
        while(top != NULL){
            temp = top; 
            delete top; 
            top = temp->next; 
        }
    }
    
    // Push 
    void Push(int x){
        Node * newNode = new Node(); 
        newNode->value = x; 
        newNode->next = NULL; 
       
        newNode->next = top; 
        top = newNode; 
    }
    
    // Pop
    int Pop(){
        if(top == NULL){
            cout << "Cannot pop from empty stack" << endl;
            return -1;  
        }
        else{
            int result = top->value; 
            Node * temp = top; 
            delete top; 
            top = temp->next; 
            
            return result; 
        }
    }
    
    // Print 
    void PrintStack(){
        Node * curr = top; 
        while (curr != NULL){
            cout << curr->value << endl; 
            curr = curr->next; 
        }
    }

};

// Test driver 
int main(){
    Stack s; 
    s.PrintStack();   // Print empty stack 
    
    s.Push(11); 
    s.Push(12); 
    s.Push(13); 
    s.PrintStack(); 
    
    cout << s.Pop() << endl; 
    cout << endl; 
    s.PrintStack(); 
    
    s.Pop(); 
    s.Pop(); 
    s.Pop();  // Pop empty stack
    
    return 0; 
}
