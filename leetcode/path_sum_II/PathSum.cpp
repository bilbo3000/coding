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
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > result; 
        vector<int> path; 
        pathSumHelper(root, sum, path, result);
        
        return result; 
    }
    
    void pathSumHelper(TreeNode * node, int sum, vector<int> path, vector<vector<int> > &result) {
        if (!node) {
            return; 
        }
        
        if (!node->left && !node->right && node->val == sum) {
            path.push_back(node->val); 
            result.push_back(path); 
            return; 
        }
        
        path.push_back(node->val); 
        
        if (node->left != NULL) {
            pathSumHelper(node->left, sum - node->val, path, result); 
        }
        
        if (node->right != NULL) {
            pathSumHelper(node->right, sum - node->val, path, result); 
        }
    }
};
