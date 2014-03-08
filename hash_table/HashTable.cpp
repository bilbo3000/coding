#include <utility>
#include <string> 
#include <iostream>

#define  MAX  1000

using namespace std; 

typedef struct Record{
    int key; 
    string value; 
}Record; 

class HashTable{
private: 
	Record* hashTable[MAX];  // hash table of pointers, can be NULL
	
	// Hash function 
	int h(int key){
		return key % MAX; 
}

public: 
    // Constructor 
    HashTable(){
        for (int i = 0; i < MAX; i++){
            hashTable[i] = NULL; 
        }
    }
    
	// Insert function 
	bool Insert(Record * r){
		int index = h(r->key); 
		int counter = 0; 
		while(hashTable[index] != NULL && counter < MAX){
			if (hashTable[index]->key == r->key) {
                return true; 
            }

            index++; 
			counter++; 
        }

        if(hashTable[index] == NULL){
	        hashTable[index] = r; 
	        return true; 
        }

        return false; 
    }

    // Search function 
    string Search(int key){
	    int index = h(key); 
	    int counter = 0; 
 
	    while (hashTable[index] != NULL && hashTable[index]->key != key && counter < MAX){
		    index++; 
		    counter++; 
        }

        if (hashTable[index] != NULL && hashTable[index]->key == key){
	        return hashTable[index]->value; 
        }
        else{
	        return "";  // Cannot return NULL for return type string 
        }
    }
    
    // Remove Function 
    bool Remove(int key){
        int index = h(key); 
        int counter = 0; 
        
        while(hashTable[index] != NULL && hashTable[index]->key != key && counter < MAX){
            index++; 
            counter++; 
        }
        
        if (hashTable[index] != NULL && hashTable[index]->key == key){
            delete hashTable[index]; 
            hashTable[index] == NULL; 
            return true; 
        }
        else{
            return false; 
        }
    }
}; 

// Testing
int main(){
    HashTable hashTable; 
    
    Record * r1 = new Record(); 
    r1->key = 1; 
    r1->value = "record A"; 
    hashTable.Insert(r1); 
    
    Record * r2 = new Record(); 
    r2->key = 5; 
    r2->value = "record B";
    hashTable.Insert(r2);
    
    cout << hashTable.Search(1) << endl; 
    cout << hashTable.Search(3) << endl;  // Not exist 
    cout << hashTable.Search(5) << endl; 
    
    hashTable.Remove(1); 
    cout << hashTable.Search(1) << endl; 
}

