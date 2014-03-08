#include <iostream> 
#include <queue> 

#define MAX 100

using namespace std;  

typedef struct Node {
    int value;  
    Node * next; 
} Node; 

class Graph {
public:
    Node * g[MAX];  // Adjacent list representation 
    bool isVisited[MAX];  // Keep track of whether a node has been visited 
    
    // Constructor 
    Graph(); 
    
    // Destructor 
    ~Graph(); 
    
    // Insert 
    void Insert(int a, int b, bool update); 
}; 

Graph::Graph() {
    for (int i = 0; i < MAX; i++) {
        g[i] = NULL; 
        isVisited[i] = NULL; 
    }
}

Graph::~Graph() {
    for (int i = 0; i < MAX; i++) {
        isVisited[i] = false; 
        
        if (g[i] != NULL) {
            Node * curr = g[i]; 
            
            while (curr != NULL) {
                Node * temp = curr; 
                curr = curr->next; 
                delete temp; 
            }
        }
    }
}

void Graph::Insert(int a, int b, bool update) {
    Node * newNode = new Node(); 
    newNode->value = b; 
    newNode->next = NULL; 
    
    if (g[a] == NULL) {
        g[a] = newNode; 
    }
    else {
        Node * curr = g[a]; 
        Node * prev = NULL; 
        
        while (curr != NULL && curr->value != b) {
            prev = curr; 
            curr = curr->next; 
        }
        
        if (curr != NULL && curr->value == b) {
            return;  // Already exist
        }
        
        prev->next = newNode; 
    }
    
    if(update) {
        Insert(b, a, false);  // Update the other node  
    }
}

// BFS
void BFS(Graph &g, int x){
    if (g.g[x] == NULL) {
        cout << "Node does not exist" << endl; 
        return;   // Node does not exist
    }
    
    queue<int> q; 
    q.push(x); 
    g.isVisited[x] = true; 
    
    while (q.size() != 0) {
        int n = q.front(); 
        q.pop(); 
        cout << n << endl; 
        
        Node * curr = g.g[n]; 
        while (curr != NULL) {
            if (!g.isVisited[curr->value]) {
                q.push(curr->value);  // Only push unvisited node
                g.isVisited[curr->value] = true; 
            }
            
            curr = curr->next;  
        }
    }
}

// dfs
void dfs(Graph &g, int x) {
    cout << x << endl; 
    g.isVisited[x] = true; 
    
    Node * curr = g.g[x]; 
    
    while (curr != NULL) {
        if (!g.isVisited[curr->value]) {
            dfs(g, curr->value); 
        }
        
        curr = curr->next; 
    }
}

// DFS
void DFS(Graph &g) {
    for (int i = 0; i < MAX; i++) {
        if (g.g[i] != NULL && !g.isVisited[i]) {
            dfs(g, i); 
        }
    }
}

// Test driver 
int main() {
    Graph g; 
    g.Insert(1, 2, true);
    g.Insert(1, 3, true); 
    g.Insert(1, 5, true);
    g.Insert(2, 3, true);
    g.Insert(3, 5, true);
    g.Insert(4, 5, true);    
    
    BFS(g, 4);
    
    cout << endl; 
    
    Graph g2; 
    g2.Insert(1, 2, true);
    g2.Insert(1, 3, true); 
    g2.Insert(1, 5, true);
    g2.Insert(2, 3, true);
    g2.Insert(3, 5, true);
    g2.Insert(4, 5, true);
    
    dfs(g2, 3); 
      
    return 0; 
}
