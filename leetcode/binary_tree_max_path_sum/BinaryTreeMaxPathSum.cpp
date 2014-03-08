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
    int maxPathSum(TreeNode *root) {
        int maxSum = INT_MIN; 
        
        return max(maxPathSumHelper(root, maxSum), maxSum); 
    }
    
    int maxPathSumHelper(TreeNode * root, int &maxSum) {
        if (root == NULL) {
            return 0; 
        }
        
        int leftSum = maxPathSumHelper(root->left, maxSum); 
        int rightSum = maxPathSumHelper(root->right, maxSum); 
        int returnVal = max(root->val + leftSum, root->val + rightSum);
        returnVal = max(returnVal, root->val); 
        
        maxSum = max(maxSum, leftSum + root->val + rightSum); 
        maxSum = max(maxSum, returnVal); 
        
        return returnVal; 
    }
};
