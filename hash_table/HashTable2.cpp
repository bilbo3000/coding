#include <iostream> 

#define MAX 13

using namespace std; 

typedef struct Record {
    int key; 
    string value; 
} Record; 

class HashTable {
private: 
    Record * arr[MAX]; 
    
public: 
    HashTable() {
        for (int i = 0; i < MAX; i++) {
            arr[i] = NULL; 
        }
    }
    
    ~HashTable() {
        for (int i = 0; i < MAX; i++) {
            if (arr[i] != NULL) {
                delete arr[i]; 
            }
        }
    }
    
    int HashFunc(int key) {
        return key % MAX; 
    }
    
    int GetKey(string s) {
        int key = 0;
        
        for (int i = 0; i < s.size(); i++) {
            key = key + s[i] - 'a' + 1; 
        }
        
        return key; 
    }
    
    bool Insert(string s) {
        int key = GetKey(s);
        Record * r = new Record(); 
        r->key = key; 
        r->value = s; 
        
        int index = HashFunc(key);
        
        if (arr[index] == NULL) {
            arr[index] = r; 
            return true; 
        }  
        else {
            
            int cnt = 0; 
            while (arr[index] != NULL && arr[index]->key != key && cnt < MAX) {
                index = (index + 1) % MAX; 
                cnt++; 
            }
            
            if (arr[index] == NULL) {
                arr[index] = r; 
                return true; 
            }
            
            else if (arr[index]->key == key) {
                return true;  // Already exists
            }
            
            return false; 
        }
    }
    
    int Search(string s) {
        int key = GetKey(s);
        int index = HashFunc(key);
        int cnt = 0; 
        
        while (arr[index] != NULL && arr[index]->key != key && cnt < MAX) {
            index = (index + 1) % MAX; 
            cnt++; 
        }  
        
        if (arr[index] == NULL) {
            return -1; 
        }
        
        if (arr[index]->key == key) {
            return index; 
        }
        
        return -1; 
    }
    
    void Print() {
        for (int i = 0; i < MAX; i++) {
            if (arr[i] != NULL) { 
                cout << i << "," << arr[i]->key << "," << arr[i]->value << endl; 
            }
        }
    }
}; 

// Test driver 
int main() {
    HashTable hashTable; 
    hashTable.Insert("a"); 
    hashTable.Insert("fool");
    hashTable.Insert("and");
    hashTable.Insert("his");
    hashTable.Insert("money");
    hashTable.Insert("are");
    hashTable.Insert("soon");
    hashTable.Insert("parted");
    
    hashTable.Print(); 
    
    cout << hashTable.Search("parted") << endl; 
    
    cout << hashTable.Search("hello") << endl;  
    return 0; 
}
