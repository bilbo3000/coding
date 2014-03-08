#include <iostream> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
} Node; 

class OrderedLinkedList{
private: 
    Node * head; 
    Node * tail; 
public: 
    // Constructor
    OrderedLinkedList(){
        head = NULL; 
        tail = NULL; 
    }
    
    // Destructor 
    ~OrderedLinkedList(){
        while(head != NULL){
            Node * temp = head->next; 
            delete head; 
            head = temp; 
        }
        
        tail = NULL; 
    }
    
    // Insert item
    void Insert(int x){
        Node * newNode = new Node(); 
        newNode->value = x; 
        newNode->next = NULL; 
        
        if(head == NULL){ // List is empty
            head = newNode; 
            tail = newNode; 
        }
        else{  // List is not empty
            if (newNode->value < head->value){  // Insert at the beginning
                newNode->next = head; 
                head = newNode; 
            }
            else {
                Node * prev = NULL; 
                Node * curr = head; 
                
                while(curr != NULL && curr->value < newNode->value){
                    prev = curr; 
                    curr = curr->next; 
                }
                
                if (curr == NULL){  // Insert at the end
                    prev->next = newNode; 
                    tail = newNode; 
                }
                else{  // Insert somewhere in the middle 
                    prev->next = newNode; 
                    newNode->next = curr; 
                }
            }
        }
    }
    
    // Delete item
    void Delete(int x){
        if (head == NULL){  // List is empty
            cout << "Cannot delete from empty list" << endl; 
            return; 
        }
        
        if(head->value == x){  // Delete first item
            Node * temp = head; 
            head = head->next; 
            delete temp; 
        }
        else{
            Node * prev = NULL; 
            Node * curr = head; 
            
            while(curr != NULL && curr->value != x){
                prev = curr; 
                curr = curr->next; 
            }
            
            if(curr == NULL){  // Doesn't exist
                cout << "Item to be deleted does not exist" << endl; 
                return; 
            }
            else{
                prev->next = curr->next;
                if (curr->next == NULL){
                    tail = prev;
                }
                delete curr; 
            }
        }
    }
    
    // Search 
    int Search(int x){
        Node * curr = head; 
        
        while(curr != NULL && curr->value != x){
            curr = curr->next; 
        }
        
        if (curr == NULL){
            cout << "Item does not exist" << endl; 
            return -1; 
        }
        else{
            return curr->value; 
        }
    }
    
    // Print list 
    void PrintList(){
        Node * curr = head; 
        while(curr != NULL){
            cout << curr->value << " "; 
            curr = curr->next; 
        }
        cout << endl; 
    }
}; 

// Test driver 
int main(){
    OrderedLinkedList ll; 
    ll.Insert(11);  // Insert into empty list 
    ll.Insert(5);   // Insert at the beginning
    ll.Insert(100);  // Insert at the end 
    ll.Insert(50);   // Insert somethere in the middle 
    
    ll.PrintList(); 
    
    OrderedLinkedList ll2; 
    ll2.Delete(1); // Delete from empty list
    ll2.Insert(1); 
    ll2.Delete(2); // Delete non-exist item
    ll2.Insert(2); 
    ll2.Delete(1); 
    
    ll2.PrintList(); 
    
    OrderedLinkedList ll3; 
    cout << ll3.Search(11) << endl;  // search empty list
    ll3.Insert(11); 
    ll3.Insert(12); 
    cout << ll3.Search(12) << endl; 
    
}
