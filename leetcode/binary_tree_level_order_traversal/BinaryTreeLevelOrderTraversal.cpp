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
    vector<vector<int> > levelOrder(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        if (!root) {
            return result; 
        }
        
        TreeNode * prev = NULL; 
        TreeNode * curr = NULL; 
        queue<TreeNode *> q; 
        q.push(root);
        
        while (q.size() != 0) {
            prev = curr; 
            curr = q.front();
            q.pop(); 
            
            if (prev == NULL) {
                q.push(NULL);
                vector<int> temp; 
                result.push_back(temp); 
            }
            
            if (curr != NULL) {
                result[result.size() - 1].push_back(curr->val);
                if (curr->left != NULL) {
                    q.push(curr->left); 
                }
                
                if (curr->right != NULL) {
                    q.push(curr->right); 
                }
            }
        }
        
        return result; 
    }
};
