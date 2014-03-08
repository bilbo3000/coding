#include <iostream> 

#define  MAX    1000

using namespace std; 

typedef struct Node {
	int value; 
	bool isVisited; 
	Node * next; 
} Node; 

class Graph{
private: 
	Node* g[MAX];  

public: 
	// Constructor 
	Graph() { 
		for (int i = 0; i < MAX; i++){
			g[i] = NULL; 
		}
	}

	// Destructor 
	~Graph() {
		for (int i = 0; i < MAX; i++){
			if (g[i] != NULL){
				Node * curr = g[i]; 
				while(curr != NULL){
					Node * temp = curr->next; 
					delete curr; 
					curr = temp; 
				}
			}
		}
	}

	// Check if graph is empty
	bool IsEmpty(){
		for(int i = 0; i < MAX; i++){
			if(g[i] != NULL) {
				return false; 
			}
		}

		return true; 
	}

	// Insert an edge and a node 
	void Insert(int x, int y){
	    InsertNode(x, y);
	    InsertNode(y, x);  
	}
	
	void InsertNode(int x, int y){
		Node * newNode = new Node(); 
		newNode->value = y; 
		newNode->isVisited = false; 
		newNode->next = NULL;  
	
	    if (g[x] == NULL) { // Insert into empty list 
	        g[x] = newNode; 
	    }
	    else {
	        Node * curr = g[x];
		    Node * prev = NULL; 
		    while(curr != NULL && curr->value != y){
			    prev = curr; 
			    curr = curr->next; 
		    }
            if (curr == NULL) {
		        prev->next = newNode; 
		    }
		}
	}
	
	// Print the adjancent list representation of the graph 
	bool PrintGraph(){
	    for(int i = 0; i < MAX; i++){
	        if(g[i] != NULL){
	            Node * curr = g[i]; 
	            cout << "Node " << i << "-->"; 
	            while (curr != NULL){
	                cout << curr->value << " "; 
	                curr = curr->next; 
	            }
	            cout << endl; 
	        }    
	    }
	}
	
}; 

// Test driver 
int main(){
    Graph g; 
    g.Insert(1, 2);
    g.Insert(1, 2);  // Insert the same edge twice
    g.Insert(1, 5);
    g.Insert(2, 5);
    g.Insert(2, 4);
    g.Insert(2, 3);
    g.Insert(3, 4);
    g.Insert(4, 5);
    
    g.PrintGraph(); 
    return 0; 
}
