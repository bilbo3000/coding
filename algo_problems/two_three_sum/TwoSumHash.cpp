#include <iostream> 

#define MAX 10

using namespace std; 

class HashTable {
private: 
    int arr[MAX]; 
    
public: 
    HashTable(); 
    ~HashTable(); 
    int HashFunc(int key); 
    void Insert(int key);
    int Search(int key); 
    int GetItem(int index); 
    void Print(); 
}; 

HashTable::HashTable() {
    for (int i = 0; i < MAX; i++) {
        arr[i] = -1000; 
    }
}

HashTable::~HashTable() {
    
}

int HashTable::HashFunc(int key) {
    return key > 0 ? key % MAX : (MAX + key) % MAX ; 
}

void HashTable::Insert(int key) {
    int index = HashFunc(key);
    
    if (arr[index] == -1000) { // Empty
        arr[index] = key; 
    } 
    else {
        int cnt = 0; 
        
        while (arr[index] != -1000 && arr[index] != key && cnt < MAX) {
            index = (index + 1) % MAX; 
            cnt++; 
        }
        
        if (arr[index] == -1) {
            arr[index] = key; 
        }
        else if (cnt == MAX) {
            cout << "No space available" << endl; 
        }
    }
}

int HashTable::Search(int key) {
    int index = HashFunc(key);
    
    int cnt = 0; 
    
    while (arr[index] != key && arr[index] != -1000 && cnt < MAX) {
        index++; 
        cnt++; 
    } 
    
    if (arr[index] == key) {  // Find, return index
        return index; 
    }
    else {
        cout << "Not found" << endl; 
        return -1; 
    }
}

int HashTable::GetItem(int index) {
    if (index >= 0 && index < MAX) {
        return arr[index]; 
    }
}

void HashTable::Print() {
    for (int i = 0; i < MAX; i++) {
        cout << "index: " << i << " key: " << arr[i] << endl; 
    }
}

void TwoSumHash(int a[], int size, int x) {
    HashTable hashTable; 
    
    for (int i = 0; i < size; i++) { 
        hashTable.Insert(x - a[i]); 
    }
    
    hashTable.Print(); 
    
    for (int i = 0; i < size; i++) {
        int index = hashTable.Search(a[i]);
        
        if(index != -1) {
            cout << "Find " << a[i] << " + " << x - a[i] << " = " << x << endl; 
            return;  
        } 
    }
    
    cout << "Counld not find two elements sum equals to " << x << endl; 
}

// Test driver 
int main() {
    int a[] = {3, 7, 4, 12, 5, 2}; 
    
    TwoSumHash(a, 6, 9);
     
    return 0; 
}
