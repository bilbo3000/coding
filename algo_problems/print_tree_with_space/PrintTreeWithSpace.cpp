#include <iostream> 
#include <queue> 
#include <cmath> 

using namespace std; 

typedef struct Node {
    int val; 
    Node * left; 
    Node * right; 
    Node() : val(0), left(NULL), right(NULL) {}
    Node(int n) : val(n), left(NULL), right(NULL) {}
} Node; 

int TreeHeight(Node * node) {
    if (node == NULL) {
        return -1; 
    }
    
    return max(TreeHeight(node->left), TreeHeight(node->right)) + 1; 
}

void PrintTree(Node * root) {
    if (root == NULL) {
        return; 
    }
    
    int treeHeight = TreeHeight(root); 
    
    Node * prev = NULL; 
    Node * curr = NULL; 
    int level = -1; 
    queue<Node *> q; 
    q.push(root);
    
    while (q.size() != 0) {
        prev = curr; 
        curr = q.front(); 
        q.pop(); 
        
        if (curr == NULL) {  // Print new line
            cout << endl; 
        }
        else {  
            if (prev == NULL) {  // Place next newline 
                q.push(NULL); 
                level++; 
                int numOfSpace = level > 0 ? pow(2, treeHeight - 1) - pow(2, level - 1) : pow(2, treeHeight - 1); 
                for (int i = 0; i < numOfSpace; i++) {
                    cout << " " << "|"; 
                }
            }
            
            cout << curr->val << "|"; 
            
            if (curr->left != NULL) {
                q.push(curr->left); 
            }
            
            if(curr->right != NULL) {
                q.push(curr->right); 
            }
        }
    } 
}

// Test driver 
int main() {
    Node * root = new Node(1);
    root->left = new Node(2); 
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5); 
    root->right->left = new Node(6);
    root->right->right = new Node(7);  
    
    PrintTree(root);
       
    return 0; 
}
