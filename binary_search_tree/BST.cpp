#include <iostream> 
#include <algorithm>
#include <stack>
#include <queue> 

using namespace std; 

typedef struct Node {
    int value; 
    Node * left; 
    Node * right; 
    Node * p; 
} Node; 

class BST{
private: 
    Node * root; 
    
public: 
    // Constructor 
    BST(){
        root = NULL; 
    }
    
    // Destructor 
    ~BST(){
        Destory(root); 
    }
    
    Node * GetRoot(){
        return root; 
    }
    
    // Insert 
    void Insert(int x){
        Node * newNode = new Node(); 
        newNode->value = x; 
        newNode->left = NULL; 
        newNode->right = NULL; 
        newNode->p = NULL; 
        
        if(root == NULL) {  // BST is empty 
            root = newNode;
            return; 
        }
        else{  // BST is not empty 
            Node * curr = root; 
            Node * prev = NULL; 
            
            while (curr != NULL){
                prev = curr; 
                if (x < curr->value) {
                    curr = curr->left; 
                }
                else{
                    curr = curr->right; 
                }
            }
            
            newNode->p = prev; 
            
            if(x < prev->value){
                prev->left = newNode; 
            }
            else{
                prev->right = newNode; 
            }
        }
    }
    
    // Search 
    Node * Search(Node * n){
        if (n == NULL){  // BST is empty 
            cout << "Cannot search empty BST" << endl; 
            return NULL; 
        }
        else {
            Node * curr = n; 
            
            while (curr != NULL){
                if (curr->value == n->value){  // Find
                    return curr; 
                }
                else if(n->value < curr->value) {
                    curr = curr->left; 
                }
                else{
                    curr = curr->right; 
                }
            }
            
            cout << "Item does not exist" << endl; 
            return NULL; 
        }
    }
    
    // Get height
    int GetHeight(Node * n){
        if (n == NULL) {  // Empty
            return -1; 
        }
        else{
            return max(GetHeight(n->left), GetHeight(n->right)) + 1; 
        }
    }
    
    // Destroy, post order 
    void Destory(Node * n) {
        if (n == NULL) {
            return; 
        }
        else {
            Destory(n->left); 
            Destory(n->right); 
            delete n; 
        }
    }
    
    // * Traversals * 
    // Pre-order recursive
    void PreOrderRecursive(Node * n){
        if (n == NULL) {
            return; 
        }
        else{
            cout << n->value << " "; 
            PreOrderRecursive(n->left); 
            PreOrderRecursive(n->right); 
        }
    }
    
    // In-order recursive 
    void InOrderRecursive(Node * n) {
        if (n == NULL) {
            return;    
        }
        else{
            InOrderRecursive(n->left); 
            cout << n->value << " "; 
            InOrderRecursive(n->right); 
        }
    }
    
    // Post-order recursive 
    void PostOrderRecursive(Node * n){
        if(n == NULL) {
            return; 
        }
        else{
            PostOrderRecursive(n->left);
            PostOrderRecursive(n->right); 
            cout << n->value << " ";  
        }
    }
    
    // Pre-order iterative
    void PreOrderIterative(Node * root){ 
        if (root == NULL) {
            return; 
        }
        
        stack<Node *> s;
        s.push(root); 
        
        while(s.size() != 0) {
            Node * curr = s.top(); 
            s.pop(); 
            cout << curr->value << " "; 
            if (curr->right != NULL) s.push(curr->right);
            if (curr->left != NULL) s.push(curr->left);  
        }
    }
    
    // In-order iterative
    void InOrderIterative(Node * root) {
        stack<Node *> s; 
        Node * curr = root; 
        while (curr != NULL || s.size() != 0) {
            if (curr != NULL) {
                s.push(curr); 
                curr = curr->left; 
            }
            else{
                curr = s.top(); 
                s.pop(); 
                cout << curr->value << " "; 
                curr = curr->right; 
            }
        }
    }
    
    // Post-order two pointers 
    void PostOrderTwoPointers(Node * root){
        if (root == NULL) return;  // Empty tree 
        
        Node * curr = NULL;  // The node being analyzing (top of stack)
        Node * prev = NULL;  // The node was being analying previously
        stack<Node *> s; 
        
        s.push(root);  // Root to be processed
        
        while(s.size() != 0) {  // While there are still nodes to be processed
            prev = curr; 
            curr = s.top(); 
            
            if (curr->p == prev) {  // 1. Moving down
                if (curr->left != NULL) {  // If left avaliable, process left next
                    s.push(curr->left); 
                }
                else if (curr->right != NULL) {  // If no left, but right available, process right next
                    s.push(curr->right); 
                }
                else {  // Leaf node, done with curr 
                    curr = s.top(); 
                    s.pop(); 
                    cout << curr->value << " "; 
                }
            }
            else if (curr->left == prev) {  // 2. Moving up from left, means done with left
                if (curr->right != NULL) {  // If right avaliable, process right next
                    s.push(curr->right); 
                }
                else{  // No right, done with current
                    curr = s.top(); 
                    s.pop(); 
                    cout << curr->value << " "; 
                }
            }
            else if (curr->right == prev) {  // 3. Moving up from right 
                curr = s.top(); 
                s.pop(); 
                cout << curr->value << " ";  // Done with curr
            }
        } 
    }
    
    // post-order two stacks
    void PostOrderTwoStacks(Node * root) {
        Node * curr = NULL; 
        stack<Node *> s1; 
        stack<Node *> s2; 
        
        s1.push(root);
        
        while(s1.size() != 0) {
            curr = s1.top(); 
            s1.pop(); 
            s2.push(curr);
            if (curr->left != NULL) s1.push(curr->left);
            if (curr->right != NULL) s1.push(curr->right);    
        } 
        
        while (s2.size() != 0) {
            curr = s2.top(); 
            s2.pop(); 
            cout << curr->value << " "; 
        }
    }
    
    // Find minimum in the substree from given node 
    Node * FindMin(Node * n) {
        if (n == NULL) return NULL; 
        Node * curr = n; 
        
        while(curr->left != NULL) {
            curr = curr->left; 
        }
        
        return curr; 
    }
    
    // Transplant u with v
    void Transplant(Node * u, Node * v) {
        if (u == NULL) return; 
        
        if (u->p == NULL) {  // u is root
            root = v; 
        }
        else{
            if (u == u->p->left) {  // u is left child
                u->p->left = v; 
            }
            else { // u is right child 
                u->p->right = v; 
            }
        }

        if (v != NULL) v->p = u->p; 
    }
    
    // * Delete *     
    void Delete(Node * n) {
        if (n == NULL) {
            return; 
        }
        
        if(n->right == NULL) {  // No right, transplant from left 
            Transplant(n, n->left); 
        }
        else if(n->left == NULL) {  // No left, transplant from right
            Transplant(n, n->right); 
        }
        else {  // Both left and right exist
            Node * min = FindMin(n->right);   // Find minimum element from the right subtree
            
            // 1. Promote min's subodinate
            Transplant(min, min->right); 
            
            // 2. Promote min to replace the node
            min->right = n->right; 
            min->left = n->left; 
            Transplant(n, min); 
        }
    }
    
    // Successor, smallest element greater than x
    Node * Successor(Node * n) {
        if(n == NULL) {
            cout << "Cannot find successor in empty tree" << endl; 
            return NULL; 
        }
        
        if(n->right != NULL) {
            return FindMin(n->right); 
        }
        else {
            Node * curr = n; 
            while (curr->p != NULL && curr != curr->p->left) {
                curr = curr->p; 
            }
            
            if (curr->p == NULL) {  // No such element exist
                cout << "No successor exist" << endl; 
                return NULL;  
            }else {
                return curr->p; 
            }
            
        }
    }
    
    // Print BST level by level
    // Idea is to put a newline marker before each level
    void PrintByLevel(Node * n){
        if (n == NULL) return; 
        
        queue<Node *> q; 
        Node * flag = new Node(); 
        flag->value = -1; 
        Node * curr = n; 
        Node * prev = NULL; 
        
        q.push(curr); 
        q.push(flag); 
        
        while(q.size() != 0) {
            prev = curr; 
            curr = q.front(); 
            q.pop(); 
            
            if (curr->value == -1) {
                cout << endl; 
            }
            else {
                cout << curr->value << " ";  // Print current value
                
                if(prev->value == -1) {  // Need to place another newline
                    q.push(flag); 
                }
                
                if (curr->left != NULL) q.push(curr->left); 
                if (curr->right != NULL) q.push(curr->right); 
            }
        }
    }
}; 

// Test driver 
int main(){
    BST bst; 
    
    // Insert 
    bst.Insert(5); 
    bst.Insert(3); 
    bst.Insert(10); 
    bst.Insert(1); 
    bst.Insert(4); 
    bst.Insert(7); 
    bst.Insert(12); 
    
    cout << bst.GetHeight(bst.GetRoot()) << endl;  // Get height
    bst.PrintByLevel(bst.GetRoot()); // Print level by level 
    
    // Traversal 
    cout << "Pre-order traversal: " << endl; 
    bst.PreOrderRecursive(bst.GetRoot()); 
    cout << endl; 
    bst.PreOrderIterative(bst.GetRoot()); 
    cout << endl; 
    
    cout << "In-order traversal: " << endl; 
    bst.InOrderRecursive(bst.GetRoot()); 
    cout << endl; 
    bst.InOrderRecursive(bst.GetRoot());
    cout << endl;  
    
    cout << "Post-order traversal: " << endl; 
    bst.PostOrderRecursive(bst.GetRoot()); 
    cout << endl; 
    bst.PostOrderTwoPointers(bst.GetRoot());
    cout << endl; 
    bst.PostOrderTwoStacks(bst.GetRoot());  
    cout << endl; 
    
    // Delete 
    bst.Delete(bst.Search(bst.GetRoot()));
    bst.PrintByLevel(bst.GetRoot()); 
    
    // Successor
    cout << bst.Successor(bst.GetRoot())->value << endl;  
    
    return 0; 
}
