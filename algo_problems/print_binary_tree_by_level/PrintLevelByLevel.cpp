#include <iostream> 
#include <queue> 

using namespace std; 

typedef struct Node {
    int val; 
    Node * left; 
    Node * right; 
    Node() : val(0), left(NULL), right(NULL) {}
    Node(int n) : val(n), left(NULL), right(NULL) {}
} Node; 

void PrintLevelByLevel(Node * root) {
    if (!root) {
        return; 
    }
    
    queue<Node *> q; 
    int lev1 = 1; 
    int lev2 = 0; 
    q.push(root);
    
    while (q.size() != 0) {
        Node * curr = q.front(); 
        cout << curr->val << " "; 
        q.pop(); 
        lev1--; 
        
        if (curr->left != NULL) {
            q.push(curr->left);
            lev2++;  
        }
        
        if (curr->right != NULL) {
            q.push(curr->right); 
            lev2++; 
        }
        
        if (lev1 == 0) {
            cout << endl; 
            lev1 = lev2; 
            lev2 = 0; 
        }
    } 
}

int main() {
    Node * root = new Node(1);
    root->left = new Node(2); 
    root->right = new Node(3); 
    root->left->left = new Node(4); 
    root->left->right = new Node(5); 
    
    PrintLevelByLevel(root); 
     
    return 0; 
}
