#include <iostream> 
#include <stack> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    void flatten(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!root) {
            return; 
        }
        
        stack<TreeNode *> s; 
        s.push(root);  
        TreeNode * curr = NULL; 
        TreeNode * prev = NULL; 
        
        while (curr != NULL || s.size() != 0) {
            if (curr != NULL) {
                if (curr->right != NULL) {
                    s.push(curr->right); 
                }
                
                prev = curr; 
                TreeNode * temp = curr->left; 
                curr->right = curr->left; 
                curr->left = NULL; 
                curr = temp; 
            }
            else {
                curr = s.top(); 
                s.pop();
                
                if (prev != NULL) {
                    prev->right = curr; 
                } 
            }
            
        }
    }
    
    void inorder(TreeNode * root) {
        if (!root) {
            return; 
        }
        
        cout << root->val << " "; 
        inorder(root->left);
        inorder(root->right);  
    } 
};

int main() {
    Solution sln; 
    TreeNode * root = new TreeNode(1);
    /*
    root->left = new TreeNode(2); 
    root->left->left = new TreeNode(3); 
    */
    root->right = new TreeNode(2); 
     
    sln.flatten(root); 
    
    sln.inorder(root); 
    return 0; 
}
