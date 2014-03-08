#include <iostream> 
#include <climits> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBSTHelper(TreeNode *node, int &prev) {
        if (!node) {
            return true; 
        }
        
        if (isValidBSTHelper(node->left, prev)) { // Explore left subtree
            if (node->val > prev) {  // Prev points to largest in left subtree
                prev = node->val; 
                return isValidBSTHelper(node->right, prev); 
            }
            else {
                return false; 
            }
        }
        else {
            return false; 
        }
    }
    
    bool isValidBST(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!root) {
            return true; 
        }
        
        int prev = INT_MIN; 
        return isValidBSTHelper(root, prev); 
    }
};

// Test driver 
int main() {
    Solution sln; 
    TreeNode * root = new TreeNode(1);
    root->left = new TreeNode(1); 
    
    if (sln.isValidBST(root)) {
        cout << "true" << endl; 
    } 
    else {
        cout << "false" << endl; 
    }
    return 0; 
}
