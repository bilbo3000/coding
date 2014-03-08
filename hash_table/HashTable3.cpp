#include<iostream> 

#define MAX 4

using namespace std; 

class HashTable {
private: 
    int arr[MAX]; 
public: 
    HashTable() {
        for (int i = 0; i < MAX; i++) {
            arr[i] = 0; 
        }
    }
    int HashFunction(int key) {
        int index = key % MAX; 
        return index; 
    }
    
    void Insert(int x) {
        int index = HashFunction(x); 
        int cnt = 0; 
        while (!(arr[index] == x || arr[index] == 0 || arr[index] == -1) && cnt < MAX) {
            index = (index + 1) % MAX; 
            cnt++; 
        }
        
        if (arr[index] == x) { // Already exist
            cout << "Item already exists. " << endl; 
            return; 
        }
        
        if (cnt == MAX) {
            cout << "Fail to insert. Hash table is full. " << endl; 
            return; 
        }
        
        arr[index] = x; 
    }
    
    int Search(int x) {
        int index = HashFunction(x);
        int cnt = 0; 
        
        while (arr[index] != x && cnt < MAX) {
            index = (index + 1) % MAX;
            cnt++; 
        }  
        
        if (cnt == MAX) {
            cout << "Cannot find the item. " << endl; 
            return -1; 
        }
        
        return index; 
    }
    
    void Delete(int x) {
        int index = HashFunction(x); 
        int cnt = 0; 
        while (arr[index] != x && cnt < MAX) {
            index = (index + 1) % MAX; 
            cnt++; 
        }
        
        if (cnt == MAX) {
            cout << "Item to be deleted does not exist" << endl; 
            return; 
        }
        
        arr[index] = -1; 
    }
    
    void Print() {
        for (int i = 0; i < MAX; i++) {
            cout << arr[i] << " "; 
        }
        cout << endl; 
    }
}; 

// Test driver
int main() {
    HashTable hashTable; 
    hashTable.Insert(4);
    hashTable.Insert(5);
    hashTable.Insert(4); 
    cout << hashTable.Search(6) << endl; 
    cout << hashTable.Search(5) << endl; 
    hashTable.Delete(6);
    hashTable.Delete(5);  
    hashTable.Print();   
    return 0; 
}
