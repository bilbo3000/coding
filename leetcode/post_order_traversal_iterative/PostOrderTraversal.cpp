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
    vector<int> postorderTraversal(TreeNode *root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<int> result; 
        if (!root) {
            return result; 
        }
        
        stack<TreeNode *> q1; 
        stack<TreeNode *> q2; 
        q1.push(root); 
        
        while (q1.size() != 0) {
            TreeNode * curr = q1.top(); 
            q1.pop(); 
            q2.push(curr);
            if (curr->left != NULL) {
                q1.push(curr->left); 
            }
            
            if (curr->right != NULL) {
                q1.push(curr->right); 
            }
        }
        
        while (q2.size() != 0) {
            result.push_back(q2.top()->val); 
            q2.pop(); 
        }
        
        return result; 
    }
};
