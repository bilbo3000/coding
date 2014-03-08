#include <iostream> 
#include <queue> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * parent; 
    Node * left; 
    Node * right; 
} Node; 

class BST {
private: 
    Node * root; 
    
public: 
    BST(); 
    ~BST(); 
    void Destroy(Node * n); 
    void Insert(int x);
    void RotateLeft(int x);
    void RotateRight(int x);   
    void Print(); 
}; 

// Constructor 
BST::BST() {
    root = NULL; 
}

// Destructor 
BST::~BST() {
    Destroy(root); 
} 

// Destroy
void BST::Destroy(Node * n) {
    if (n->left != NULL) Destroy(n->left); 
    if (n->right != NULL) Destroy(n->right); 
    delete n; 
}

// Insert 
void BST::Insert(int x) {
    Node * newNode = new Node(); 
    newNode->value = x; 
    newNode->left = NULL; 
    newNode->right = NULL; 
    newNode->parent = NULL; 
    
    if (root == NULL) {
        root = newNode; 
    }
    else {
        Node * curr = root; 
        Node * prev = NULL; 
        
        while (curr != NULL) {
            prev = curr; 
            
            if (x < curr->value) {
                curr = curr->left; 
            }
            else {
                curr = curr->right; 
            }
        }
        
        if (x < prev->value) {
            prev->left = newNode; 
        }
        else {
            prev->right = newNode; 
        }
        
        newNode->parent = prev; 
    }
}

// Print 
void BST::Print() {
    queue<Node *> q; 
    Node * newLineNode = new Node(); 
    newLineNode->value = -1; 
    Node * curr = newLineNode;  
    Node * prev = NULL; 
    
    q.push(root);
    
    while (q.size() != 0) {
        prev = curr; 
        curr = q.front(); 
        q.pop();
        
        if (curr->value == -1) {
            cout << endl; 
        }
        else {
            cout << curr->value << " "; 
            if (prev->value == -1) q.push(newLineNode);
            if (curr->left != NULL) q.push(curr->left); 
            if (curr->right != NULL) q.push(curr->right);    
        }
    }  
}

// Rotate left 
void BST::RotateLeft(int x) {
    Node * curr = root; 
    
    while (curr != NULL && curr->value != x) {
        if (x < curr->value) {
            curr = curr->left; 
        }
        else {
            curr = curr->right; 
        }
    }
    
    if (curr == NULL) {  // Node does not exist
        return; 
    }
    else {  // Find x, rotate left
        Node * y = curr->right;
    
        // Update curr->right 
        curr->right = y->left; 
        if (y->left != NULL) {
            y->left->parent = curr; 
        }
        
        // Move y
        y->parent = curr->parent; 
        if (root == curr) {
            root = y; 
        }
        else if (curr == curr->parent->left) {
            curr->parent->left = y; 
        }
        else {
            curr->parent->right = y; 
        }
        
        // Update y->left 
        y->left = curr; 
        curr->parent = y; 
    }
}

void BST::RotateRight(int x) {
    Node * curr = root; 
    
    while (curr != NULL && curr->value != x) {
        if (x < curr->value) {
            curr = curr->left; 
        }
        else {
            curr = curr->right; 
        }
    }
    
    if (curr == NULL) {
        return; 
    }
    else {
        Node * y = curr->left; 
       
        // Update curr->left
        curr->left = y->right; 
        if (y->right != NULL) {
            y->right->parent = curr; 
        }
        
        // Promote y
        y->parent = curr->parent; 
        if (curr == root) {
            root = y; 
        }
        else if (curr == curr->parent->left) {
            curr->parent->left = y; 
        }
        else {
            curr->parent->right = y; 
        }
        
        // Update y->right
        y->right = curr; 
        curr->parent = y; 
    }
}

// Test driver 
int main() {
    BST t; 
    t.Insert(7); 
    t.Insert(4);
    t.Insert(11);
    t.Insert(9);
    t.Insert(18);
    t.Insert(14);
    t.Insert(19);
    t.Insert(17);
    t.Insert(22);
    
    t.RotateLeft(11);
    t.Print(); 
     
    t.RotateRight(18); 
    t.Print(); 
    
    return 0; 
}
