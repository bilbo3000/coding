#include <iostream> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * next; 
    Node * back; 
} Node;
 
class DoublyLinkedList{
private: 
    Node * head; 
    Node * tail; 

public: 
    // Constructor 
    DoublyLinkedList(){
        head = NULL; 
        tail = NULL; 
    }
    
    // Destructor 
    ~DoublyLinkedList(){
        Node * curr = head; 
        
        while(curr != NULL){
            Node * temp = curr; 
            delete curr; 
            curr = temp->next; 
        }
        
        tail = NULL; 
    }
    
    // Insert
    void Insert(int x){
        Node * newNode = new Node(); 
        newNode->value = x; 
        newNode->next = NULL; 
        newNode->back = NULL; 
        
        if(head == NULL) {  // Insert into empty list 
            head = newNode; 
            tail = newNode; 
        }
        else{  // List is not empty
            if(newNode->value < head->value){  // Insert at the beginning
                newNode->next = head; 
                head->back = newNode; 
                head = newNode; 
            }
            else{  // Insert somewhere in the middle 
                Node * curr = head; 
                Node * prev = NULL; 
                
                while (curr != NULL && curr->value < newNode->value){
                    prev = curr; 
                    curr = curr->next; 
                }
                
                if(curr == NULL){  // Insert at the end
                    prev->next = newNode; 
                    newNode->back = prev; 
                    tail = newNode; 
                }
                else{  // Somewhere in the middle 
                    prev->next = newNode; 
                    newNode->back = prev; 
                    
                    curr->back = newNode; 
                    newNode->next = curr; 
                }
            }
        }
    }
    
    // Delete
    void Delete(int x){
        if(head == NULL){
            cout << "Cannot delete from empty list" << endl; 
            return; 
        }
        else{  // Not empty
            if (head->value == x){  // Delete the first item
                Node * temp = head; 
                head = head->next; 
                head->back = NULL; 
                temp->next = NULL; 
                delete temp; 
            }
            else{
                Node * curr = head; 
                Node * prev = NULL; 
                
                while(curr != NULL && curr->value != x){
                    prev = curr; 
                    curr = curr->next; 
                }
                
                if(curr == NULL){  // Doesn't exist
                    cout << "Item to be delete does not exist" << endl; 
                    return; 
                }
                else{  // Somewhere in the middle  
                    if (curr->next == NULL){  // Delete last item
                        prev->next = NULL; 
                        tail = prev;
                        curr->back = NULL;  
                        delete curr; 
                    }
                    else {  // Delete somewhere in the middle 
                        prev->next = curr->next;
                        curr->next->back = prev; 
                        curr->next = NULL; 
                        curr->back = NULL; 
                        delete curr; 
                    }
                    
                }
            }
        }
    }
    
    // Search 
    int Search(int x){
        if (head == NULL){
            cout << "Cannot search empty list" << endl; 
            return -1; 
        }
        else{
            Node * curr = head; 
            
            while(curr != NULL && curr->value != x){
                curr = curr->next; 
            }
            
            if(curr == NULL){
                cout << "Item does not exist" << endl; 
                return -1; 
            }
            else{
                return curr->value; 
            }
        }
    }
    
    // Print list
    void PrintList(){
        Node * curr = head; 
        while(curr != NULL) {
            cout << curr->value << " "; 
            curr = curr->next; 
        }
        cout << endl; 
    }
    
    // Print list in reverse order
    void PrintListReverse(){
        Node * curr = tail; 
        while(curr != NULL){
            cout << curr->value << " "; 
            curr = curr->back; 
        }
        cout << endl; 
    }
}; 

// Test driver
int main(){
    DoublyLinkedList ll; 
    cout << ll.Search(11) << endl;  // Search empty list
    ll.Insert(11);  // Insert into empty list 
    ll.Insert(5);  // Insert at the beginning
    ll.Insert(100);  // Insert at the end
    ll.Insert(50);  // Insert in the middle
    cout << ll.Search(51) << endl;  // Search item doesn't exist
    cout << ll.Search(50) << endl; 
    
    ll.PrintList(); 
    ll.PrintListReverse(); 
    
    DoublyLinkedList ll2; 
    ll2.Delete(11);  // Delete from empty list 
    ll2.Insert(11); 
    ll2.Insert(12); 
    ll2.Insert(13);
    ll2.Delete(12);  // Delete from the middle
    
    ll2.PrintList(); 
    ll2.PrintListReverse();  
    
}
