/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode *root) {
        if (!root) {
            return true; 
        }
        
        int leftHeight = height(root->left); 
        int rightHeight = height(root->right); 
        
        if (abs(leftHeight - rightHeight) > 1) {
            return false; 
        }
        
        return isBalanced(root->left) || isBalanced(root->right); 
    }
    
    int height(TreeNode * node) {
        if (!node) {
            return -1; 
        }
        
        return max(height(node->left), height(node->right)) + 1; 
    }
};
