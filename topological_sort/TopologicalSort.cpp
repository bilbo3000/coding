#include <iostream> 

#define  MAX  100 

using namespace std; 

typedef struct Node {
    int id; 
    Node * next; 
} Node; 

class Graph {
private: 
    Node * graph[MAX]; 
    bool isVisited[MAX]; 
    
public: 
    Graph(); 
    ~Graph(); 
    void Insert(int x, int y); 
    void TopologicalSort(); 
    void Print(); 
    void dfs(int x); 
};  

Graph::Graph() {
    for (int i = 0; i < MAX; i++) {
        graph[i] = NULL; 
        isVisited[i] = false; 
    }
}

Graph::~Graph() {
    for (int i = 0; i < MAX; i++) {
        isVisited[i] = false; 
        
        if (graph[i] != NULL) {
            Node * curr = graph[i]; 
            
            while (curr != NULL) {
                Node * temp = curr; 
                curr = curr->next; 
                delete temp; 
            }
        }
    }
}

void Graph::Insert(int x, int y) {
    Node * newNode = new Node(); 
    newNode->id = y; 
    newNode->next = NULL; 
    
    if (graph[x] == NULL) {
        graph[x] = newNode; 
    }
    else {
        Node * curr = graph[x]; 
        Node * prev = NULL; 
        
        while (curr != NULL) {
            prev = curr; 
            curr = curr->next; 
        }
        
        prev->next = newNode; 
    }
}

void Graph::Print() {
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL) {
            cout << "Row " << i << ":"; 
            
            Node * curr = graph[i]; 
            
            while (curr != NULL) {
                cout << curr->id << " "; 
                curr = curr->next; 
            }
            
            cout << endl; 
        }
    }
}

void Graph::TopologicalSort() {
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL) {
            dfs(i); 
        }
    }
}

void Graph::dfs(int x) {
    if (!isVisited[x]) {
        cout << x << " ";  
        isVisited[x] = true; 
        Node * curr = graph[x]; 
        
        while (curr != NULL) {
            dfs(curr->id); 
            curr = curr->next; 
        }
    }
}

// Test driver 
int main() {
   Graph g; 
   g.Insert(1, 3); 
   g.Insert(2, 3);
   g.Insert(3, 4);
   g.Insert(4, 5);
   g.Insert(3, 5);
   
   g.Print(); 
   
   g.TopologicalSort(); 
   
   return 0;  
}
