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
    vector<int> inorderTraversal(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<int> result; 
        if (!root) {
            return result; 
        }
        
        TreeNode * curr = root; 
        stack<TreeNode *> s; 
        while (curr != NULL || s.size() != 0) {
            if (curr != NULL) {
                s.push(curr);
                curr = curr->left; 
            }
            else {
                result.push_back(s.top()->val);
                curr = s.top()->right; 
                s.pop(); 
            }
        }
        
        return result; 
    }
};
