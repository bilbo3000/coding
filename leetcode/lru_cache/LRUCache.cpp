#include <iostream> 
#include <map> 

using namespace std; 

typedef struct CacheNode {
	int key; 
    int val; 
    CacheNode * next; 
    CacheNode * prev; 
    CacheNode(int n, int k): val(n), key(k), next(NULL), prev(NULL){}
} CacheNode; 
    
class LRUCache{
private: 
    map<int, CacheNode*> cacheMap; 
    CacheNode * head; 
    CacheNode * tail; 
    int cap; 
    int size; 
public:
    LRUCache(int capacity) {
        cap = capacity; 
        head = NULL; 
        tail = NULL; 
        size = 0; 
    }
    
    int get(int key) {
        if (cacheMap.find(key) == cacheMap.end()) {
            return -1; 
        }
        
        CacheNode * node = cacheMap[key]; 
        int result = node->val; 
        
        if (node != head) {
            node->prev->next = node->next; 
            
            if (node->next != NULL) {
                node->next->prev = node->prev; 
            }
            else {  // At tail
                tail = node->prev; 
            }
            
            node->prev = NULL; 
            node->next = head; 
            head->prev = node; 
            head = node; 
        }
        
        return result; 
    }
    
    void set(int key, int value) {
        if (cacheMap.find(key) == cacheMap.end()) {  // New Element 
            CacheNode * newNode = new CacheNode(value, key); 
            cacheMap[key] = newNode;
            
            if (head == NULL) {
                head = newNode; 
                tail = newNode; 
            }
            else {
                newNode->next = head; 
                head->prev = newNode; 
                head = newNode; 
            } 
            
            if (size == cap) {  // Exceeds capacity, remove last one
                if (tail != NULL) { 
                	// Erase 
                	cacheMap.erase(tail->key); 
                    tail = tail->prev; 
                    if (tail != NULL) tail->next = NULL;  
                }
            }
            else {
            	size++; 
            }
        }
        else {  // Element already exist 
            CacheNode * node = cacheMap[key];
            node->val = value;  
            
            if (node != head) {
                node->prev->next = node->next; 
                
                if (node->next != NULL) {
                    node->next->prev = node->prev; 
                }
                else {  // At tail
                    tail = node->prev; 
                }
                
                node->prev = NULL; 
                node->next = head; 
                head->prev = node; 
                head = node; 
            }            
        }
    }
};

int main() {
	LRUCache cache(1); 
cache.set(2,1);
cout << cache.get(2) << endl;
cache.set(3,2);
cout << cache.get(2) << endl;
cout << cache.get(3) << endl;

	return 0; 
}
