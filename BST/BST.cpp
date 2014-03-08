#include <iostream> 
#include <cmath>
#define MAX 1000  

using namespace std; 

typedef struct Node {
    int data; 
    Node * left; 
    Node * right; 
    Node * parent; 
} Node; 

class BST {
private: 
    Node * root; 
    
public: 
    BST();  // *
    ~BST();   // *
    void Destroy(Node * n);  // *
    Node * FindMin(Node * n);  // **
    void PreOrderRecursive(Node * n);  // **
    void InOrderRecursive(Node * n);  // **
    void PostOrderRecursive(Node * n); // **
    void PreOrderIterative(); // **
    void InOrderIterative();  // **
    void PostOrderIterative();  // **
    void PostOrderTwoStack();  // **
    void Insert(int x);   // **
    Node * Search(int x);  // **
    Node * Successor(int x);  // **
    void Delete(int x); // **
    void Transplant(Node * u, Node * v);  // **
    int Height(Node * n);  // **
    void BFS();  // **
    void DFS(Node * n);  // **
    void RotateLeft(int n); 
    void RotateRight(); 
    void Print();  // **
    Node * GetRoot();  // **
    Node * CreateNode(int x);  // **
};

class Stack {
private: 
    Node * arr[MAX]; 
    int top; 
public: 
    Stack() {
        top = -1; 
    }
    
    void Push(Node * n) {
        if (top < MAX - 1) {
            top++; 
            arr[top] = n; 
        }
        else {
            cout << "Stack out of space" << endl; 
        }
    }
    
    Node * Pop() {
        if (top >= 0) {
            Node * result = arr[top]; 
            top--; 
            return result; 
        }
        else {
            cout << "Stack underflow" << endl; 
            return NULL; 
        }
    }
    
    Node * Top(){
        if (top >= 0) {
            return arr[top]; 
        }
    }
    
    bool IsEmpty() {
        if (top >= 0) {
            return false; 
        }
        else {
            return true; 
        }
    }
};

class Queue {
private: 
    Node * arr[MAX]; 
    int front; 
    int back; 
public: 
    Queue() {
        front = -1; 
        back = -1; 
    }
    
    void Enqueue(Node * n) {
        back = back + 1; 
        arr[back] = n; 
        
        if (front == -1) {
            front++; 
        }
    }
    
    Node * Dequeue() {
        if (front >= 0) {
            Node * result = arr[front]; 
            front = front + 1; 
            return result; 
        }
        
        return NULL; 
    }
    
    bool IsEmpty() {
        if (front == -1 || front > back) {
            return true; 
        }
        else {
            return false; 
        }
    }
}; 

void BST::RotateLeft(int n) {
    Node * x = Search(n); 
    
    if (x == NULL || x->right == NULL) return; 
    
    Node * y = x->right; 
    x->right = y->left; 
    
    if (y->left != NULL) {
        y->left->parent = x; 
    }
    
    if (x->parent == NULL) {
        root = y; 
        y->parent = NULL; 
    }
    else {
        y->parent = x->parent; 
        
        if (x == x->parent->left) {
            x->parent->left = y; 
        }
        else {
            x->parent->right = y; 
        }
    }
    
    y->left = x; 
    x->parent = y; 
}

void BST::Delete(int x) {
    Node * n = Search(x);
    
    if (n == NULL) {
        cout << "Item to be deleted does not exist" << endl; 
        return; 
    } 
    else {
        if (n->left == NULL && n->right == NULL) {
            Transplant(n, NULL); 
        }
        else if (n->left != NULL && n->right == NULL) {
            Transplant(n, n->left); 
        }
        else if (n->left == NULL && n->right != NULL) {
            Transplant(n, n->right); 
        }
        else {
            Node * y = FindMin(n->right);
            if (y->parent != n) {
                Transplant(y, y->right);
                y->right = n->right; 
                y->right->parent = y;  
            }
            Transplant(n, y);
            y->left = n->left; 
            y->left->parent = y;   
        }
        
        delete n;
    }
}

void BST::Transplant(Node * u, Node * v) {
    if (u == NULL) return; 
    
    if (u->parent == NULL) {
        root = v; 
        if (v != NULL) {
            v->parent = NULL; 
        }
    }
    else {
        if (v != NULL) {
            v->parent = u->parent; 
        }
        
        if (u == u->parent->left) {
            u->parent->left = v; 
        }
        else {
            u->parent->right = v; 
        }
    }
}

Node * BST::Successor(int x) {
    Node * n = Search(x);
    
    if (n == NULL) {
        return n; 
    } 
    else {
        if (n->right != NULL) {
            return FindMin(n->right); 
        }
        else {
            while (n->parent != NULL && !(n == n->parent->left)) {
                n = n->parent; 
            }
            
            return n->parent; 
        }
    }
}

void BST::BFS() {
    Queue q; 
    q.Enqueue(root);
    
    while (!q.IsEmpty()) {
        Node * curr = q.Dequeue(); 
        cout << curr->data << " "; 
        if (curr->left != NULL) q.Enqueue(curr->left); 
        if (curr->right != NULL) q.Enqueue(curr->right); 
    } 
}
 
void BST::DFS(Node * n) {
    if (n != NULL) {
        cout << n->data << " "; 
        DFS(n->left);
        DFS(n->right);  
    }
}
 
void BST::PreOrderIterative() {
    Stack s; 
    Node * curr = root; 
    
    while (curr != NULL || !s.IsEmpty()) {
        if (curr != NULL) {
            cout << curr->data << " "; 
            s.Push(curr);
            curr = curr->left;  
        }
        else {
            curr = s.Pop(); 
            curr = curr->right; 
        }
    }
}

void BST::InOrderIterative() {
    Stack s; 
    Node * curr = root; 
    
    while (curr != NULL || !s.IsEmpty()) {
        if (curr != NULL) {
            s.Push(curr);
            curr = curr->left;  
        } 
        else {
            curr = s.Pop(); 
            cout << curr->data << " "; 
            curr = curr->right;  
        }
    }
}
 
void BST::PostOrderIterative() {
    Stack s; 
    s.Push(root);
    Node * curr = NULL; 
    Node * prev = NULL; 
    
    while (!s.IsEmpty()) {
        prev = curr; 
        curr = s.Top(); 
        
        if (curr->parent == prev) {  // Moving down
            if (curr->left != NULL) {
                s.Push(curr->left); 
            } 
            else if (curr->right != NULL) {
                s.Push(curr->right); 
            }
            else {
                cout << curr->data << " "; 
                s.Pop(); 
            }
        }
        else if (curr->left == prev) {  // Moving up from left 
            if (curr->right != NULL) {
                s.Push(curr->right);
            } 
            else {
                cout << curr->data << " "; 
                s.Pop(); 
            } 
        }
        else if (curr->right == prev) {
            cout << curr->data << " "; 
            s.Pop();
        }
    } 
}
 
void BST::PostOrderTwoStack() {
    Stack s1; 
    Stack s2; 
    
    s1.Push(root); 
    
    while (!s1.IsEmpty()) {
        Node * curr = s1.Pop(); 
        s2.Push(curr);
        if(curr != NULL) {
            if (curr->left != NULL) s1.Push(curr->left);
            if (curr->right != NULL) s1.Push(curr->right);  
        } 
    } 
    
    while (!s2.IsEmpty()) {
        cout << s2.Pop()->data << " "; 
    }
}
    
Node * BST::Search(int x) {
    Node * curr = root; 
    
    while (curr != NULL) {
        if (curr->data == x) {
            return curr; 
        }
        else if (x < curr->data) {
            curr = curr->left; 
        }
        else {
            curr = curr->right; 
        }
    }
    
    return curr; 
}

void BST::Insert(int x) {
    Node * newNode = CreateNode(x); 
    
    if (root == NULL) {
        root = newNode; 
    }
    else {
        Node * prev = NULL; 
        Node * curr = root; 
        while (curr != NULL) {
            prev = curr; 
            if (x < curr->data) {
                curr = curr->left; 
            } 
            else {
                curr = curr->right; 
            }
        }
        
        if (x < prev->data) {
            prev->left = newNode; 
        }
        else {
            prev->right = newNode; 
        }
        
        newNode->parent = prev; 
    }
}

BST::BST() {
    root = NULL; 
}

BST::~BST() {
    Destroy(root); 
}

void BST::Destroy(Node * n) {
    if (n == NULL) {
        return; 
    }
    
    Destroy(n->left); 
    Destroy(n->right); 
    
    delete n; 
}

Node * BST::FindMin(Node * n) {
    Node * curr = n; 
    
    while (curr != NULL && curr->left != NULL) {
        curr = curr->left; 
    }
    
    return curr; 
}

void BST::PreOrderRecursive(Node * n) {
    if (n != NULL) {
        cout << n->data << " "; 
        PreOrderRecursive(n->left); 
        PreOrderRecursive(n->right); 
    }
}

void BST::InOrderRecursive(Node * n) {
    if (n != NULL) {
        InOrderRecursive(n->left);
        cout << n->data << " "; 
        InOrderRecursive(n->right);  
    }
}

void BST::PostOrderRecursive(Node * n) {
    if (n != NULL) {
        PostOrderRecursive(n->left);
        PostOrderRecursive(n->right);
        cout << n->data << " ";   
    }
}

int BST::Height(Node * n) {
    if (n == NULL) {
        return -1; 
    }
    else {
        return max(Height(n->left), Height(n->right)) + 1; 
    }
}

Node * BST::GetRoot() {
    return root; 
}

Node * BST::CreateNode(int x) {
    Node * newNode = new Node(); 
    newNode->data = x; 
    newNode->left = NULL; 
    newNode->right = NULL; 
    newNode->parent = NULL; 
}

void BST::Print() {
    Queue q; 
    q.Enqueue(root); 
    Node * prev = NULL; 
    Node * curr = NULL; 
    
    while (!q.IsEmpty()) {
        prev = curr; 
        curr = q.Dequeue(); 
        
        if (curr != NULL) {
            if (prev == NULL) { 
                q.Enqueue(NULL); 
            } 
            if (curr->left != NULL) q.Enqueue(curr->left);
            if (curr->right != NULL) q.Enqueue(curr->right);
            cout << curr->data << " "; 
        } 
        else {
            cout << endl; 
        }
    }
}

// Test driver 
int main() {
    BST bst; 
    bst.Insert(5); 
    bst.Insert(3);
    bst.Insert(10);
    bst.Insert(1);
    bst.Insert(4);
    bst.Insert(7);
    bst.Insert(12);
    
    bst.Print(); 
    
    cout << "Min: " << bst.FindMin(bst.GetRoot())->data << endl; 
    cout << "Height: " << bst.Height(bst.GetRoot()) << endl; 
    
    cout << bst.Search(4)->data << endl;
    cout << bst.Search(7)->data << endl; 
    if (bst.Search(100) == NULL) cout << "Not found" << endl; 
    
    bst.PreOrderRecursive(bst.GetRoot()); cout << endl; 
    bst.InOrderRecursive(bst.GetRoot()); cout << endl; 
    bst.PostOrderRecursive(bst.GetRoot()); cout << endl; 
    cout << endl; 
    
    bst.PreOrderIterative(); cout << endl;
    bst.InOrderIterative(); cout << endl;  
    bst.PostOrderTwoStack(); cout << endl; 
    bst.PostOrderIterative(); cout << endl; 
    cout << endl; 
    
    bst.BFS(); cout << endl; 
    bst.DFS(bst.GetRoot()); cout << endl; 
    
    if (bst.Successor(100) == NULL) {
        cout << "Cannot find successor for 100" << endl; 
    } 
    
    cout << bst.Successor(5)->data << endl;
    if (bst.Successor(12) == NULL) {
        cout << "Cannot find successor for 12" << endl; 
    }
    
    // bst.Delete(12);
    cout << "Rotate: " << endl; 
    bst.RotateLeft(10); 
    bst.Print();  
    return 0; 
}
