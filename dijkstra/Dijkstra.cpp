#include <iostream> 
#include <queue> 
#include <vector> 
#include <set> 

#define  MAX  100

using namespace std; 

typedef struct Node {
    int id; 
    int weight; 
    int parent; 
    int distance; 
    Node * next; 
} Node; 

class Graph {
private: 
    Node * graph[MAX]; 
    bool isVisited[MAX]; 
    int currDistance[MAX]; 
    set<int> nVertices; 
    
public: 
    // Constructor 
    Graph();
    
    // Destructor 
    ~Graph(); 
    
    // Insert
    void Insert(int x, int y, int weight, bool update);  
    
    // Print
    void Print(); 
    
    // Print adjacent list 
    void PrintAdj(); 
    
    // Print the shortest distance of each node
    void PrintShortestDistance(); 
    
    void PrintShortestPath(int x); 
    
    // Dijkstra to compute single source shortest path 
    void ShortestPath(int x); 
    
    void UpdateDistance(int parent, int x, int d); 
    
    int ExtractMin();
}; 

Graph::Graph() {    
    for (int i = 0; i < MAX; i++) {
        graph[i] = NULL; 
        isVisited[i] = false; 
        currDistance[i] = 1000; 
    }
}

Graph::~Graph() {
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL) {
            Node * curr = graph[i]; 
            while (curr != NULL) {
                Node * temp = curr; 
                curr = curr->next; 
                delete temp; 
            }
        }
    }
    
    nVertices.clear(); 
}

void Graph::Insert(int x, int y, int weight, bool update) {
    Node * newNode = new Node(); 
    newNode->id = y; 
    newNode->weight = weight; 
    newNode->parent = -1; 
    newNode->distance = 1000; 
    newNode->next = NULL; 
    
    if (graph[x] == NULL) {
        graph[x] = newNode; 
        nVertices.insert(x);
    }
    else{
        Node * curr = graph[x]; 
        Node * prev = NULL; 
        while (curr != NULL && curr->id != y) {
            prev = curr; 
            curr = curr->next; 
        }
        
        // Do not insert if node already exist 
        if (curr == NULL) {  
            prev->next = newNode; 
        }
    }
    
    if (update) { 
        Insert(y, x, weight, false); 
    }
}

void Graph::Print() {
    cout << "Number of vertices: " << nVertices.size() << endl; 
    queue<int> q;   
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL && !isVisited[i]) {
            q.push(i); 
            isVisited[i] = true; 
            
            while (q.size() != 0) {
                int temp = q.front(); 
                q.pop(); 
                
                cout << temp << " "; 
                
                Node * curr = graph[temp]; 
                while (curr != NULL) {
                    if (!isVisited[curr->id]) {
                        q.push(curr->id); 
                        isVisited[curr->id] = true; 
                    }
                    curr = curr->next; 
                }
            }
        }
    }
    
    cout << endl; 
}

void Graph::PrintShortestDistance() {
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL) {
            cout << "Node: " << i << " distance: " << currDistance[i] << "|"; 
            PrintShortestPath(i); 
            cout << endl; 
        }
    }
}

void Graph::PrintShortestPath(int x) {
    if (x != -1) {
        cout << x << " "; 
        Node * curr = graph[x]; 
        
        if (curr != NULL) {
            Node * curr2 = graph[curr->id]; 
            
            while (curr2 != NULL && curr2->id != x) {
                curr2 = curr2->next; 
            }
            
            if (curr2 != NULL) {
                PrintShortestPath(curr2->parent); 
            }
        }
    } 
}

void Graph::PrintAdj() {
    for (int i = 0; i < MAX; i++) {
        if (graph[i] != NULL) {
        cout << "i: " << i << " ";
            Node * curr = graph[i]; 
            while (curr != NULL) { 
                cout << curr->id << " "; 
                curr = curr->next; 
            }
            cout << endl; 
        }
    }
}

// Update distance for given node x to be d iff it is smaller
void Graph::UpdateDistance(int parent, int x, int d) {
    Node * curr = graph[x]; 
    
    while (curr != NULL) {  // Loop through all adjacent nodes
        int adjId = curr->id; 
        Node * curr2 = graph[adjId]; 
        
        while (curr2 != NULL) {  // Loop adjacent nodes of current adj node
            if (curr2->id == x && d < curr2->distance) {
                curr2->distance = d;  // Update distance 
                currDistance[x] = d;
                curr2->parent = parent;  // Update parent 
            }
            
            curr2 = curr2->next; 
        }
        
        curr = curr->next; 
    }
}

// Extract the id of the node with smallest distance
int Graph::ExtractMin() {
    set<int>::iterator minIt = nVertices.begin(); 
    int minDistance = currDistance[*minIt]; 

    for(set<int>::iterator it = nVertices.begin(); it != nVertices.end(); it++) {
        if (currDistance[*it] < minDistance) {
            minIt = it; 
            minDistance = currDistance[*it]; 
        }
    }
    
    int result = *minIt; 
    nVertices.erase(minIt); 
    
    return result; 
}

void Graph::ShortestPath(int x) {
    vector<int> v;  // Store the node id which distance has been set 
    UpdateDistance(-1, x, 0);  // Update source code  

    while (nVertices.size() != 0) {  // Still some nodes to be processed 
        int minIndex = ExtractMin(); 
        int minDistance = currDistance[minIndex]; 
        
        Node * curr = graph[minIndex]; 
        
        while(curr != NULL) {
            if (nVertices.find(curr->id) != nVertices.end()) { 
                UpdateDistance(minIndex, curr->id, minDistance + curr->weight); 
            }
            
            curr = curr->next; 
        }
    }
}

// Test driver 
int main() {
    Graph graph; 
    
    graph.Insert(1, 2, 3, true);
    graph.Insert(1, 3, 2, true);
    graph.Insert(1, 4, 5, true); 
    graph.Insert(2, 4, 1, true);
    graph.Insert(2, 5, 4, true); 
    graph.Insert(5, 4, 3, true);
    graph.Insert(4, 3, 2, true);
    graph.Insert(3, 6, 1, true);
    graph.Insert(6, 5, 2, true);    
        
    graph.Print(); 
    
    graph.ShortestPath(1); 
    
    graph.PrintShortestDistance(); 
    
    
    return 0; 
}
