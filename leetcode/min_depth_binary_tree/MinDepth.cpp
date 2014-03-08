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
    int minDepth(TreeNode *root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (!root) {
            return 0; 
        }
        
        if (root->left == NULL && root->right == NULL) {
            return 1; 
        }
        
        if (root->left == NULL || root->right == NULL) {
            if (!root->left) {
                return minDepth(root->right) + 1; 
            }
            else {
                return minDepth(root->left) + 1; 
            }
        }
        
        return min(minDepth(root->left), minDepth(root->right)) + 1; 
    }
};
