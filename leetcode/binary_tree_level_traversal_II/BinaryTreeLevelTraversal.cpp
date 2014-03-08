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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > result; 
        if (!root) {
            return result; 
        }
        
        queue<TreeNode *> q; 
        vector<int> row; 
        q.push(root); 
        int lev1 = 1; 
        int lev2 = 0; 
        
        while (q.size() != 0) {
            TreeNode * curr = q.front(); 
            q.pop(); 
            lev1--; 
            row.push_back(curr->val); 
            
            if (curr->left) {
                q.push(curr->left); 
                lev2++; 
            }
            
            if (curr->right) {
                q.push(curr->right); 
                lev2++; 
            }
            
            if (lev1 == 0) {
                lev1 = lev2; 
                lev2 = 0; 
                result.insert(result.begin(), row); 
                row.clear(); 
            }
        }
        
        return result; 
    }
};
