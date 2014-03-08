#include <iostream> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isLeftSubTreeLess(TreeNode *root, int val) {
        if (!root) {
            return true; 
        }
        
        return (root->val < val) && isLeftSubTreeLess(root->left, val) && isLeftSubTreeLess(root->right, val); 
    }
    
    bool isRightSubTreeGreater(TreeNode *root, int val) {
        if (!root) {
            return true; 
        }
        
        return (root->val > val) && isRightSubTreeGreater(root->left, val) && isRightSubTreeGreater(root->right, val); 
    }
    
    bool isValidBST(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!root) {
            return true; 
        }
        
        return isLeftSubTreeLess(root->left, root->val) && isRightSubTreeGreater(root->right, root->val) && isValidBST(root->left) && isValidBST(root->right); 
    }
};

// Test driver 
int main() {
    Solution sln; 
    TreeNode * root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(15);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(20);   
    
    if (sln.isValidBST(root)) {
        cout << "true" << endl; 
    } 
    else {
        cout << "false" << endl; 
    }
    return 0; 
}
