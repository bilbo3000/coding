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
    vector<TreeNode *> generateTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        vector<int> v; 
        for (int i = 1; i <= n; i++) {
            v.push_back(i); 
        }
        
        return helper(v);  
    }
    
    vector<TreeNode *> helper(vector<int> v) {
        vector<TreeNode *> result; 
        if (v.size() == 0) {
            result.push_back(NULL); 
            return result; 
        }
        
        if (v.size() == 1) {
            TreeNode * node = new TreeNode(v[0]);
            result.push_back(node); 
            return result; 
        }
        
        for (int i = 0; i < v.size(); i++) {
            vector<int> left(v.begin(), v.begin() + i); 
            vector<int> right(v.begin() + i + 1, v.end()); 
            
            vector<TreeNode *> leftResult = helper(left);  
            vector<TreeNode *> rightResult = helper(right); 
            
            if (leftResult.size() != 0 && rightResult.size() == 0) {
                for (int l = 0; l < leftResult.size(); l++) {
                    TreeNode * node = new TreeNode(v[i]); 
                    node->left = leftResult[l]; 
                    result.push_back(node); 
                }
            }
            else if(leftResult.size() == 0 && rightResult.size() != 0) {
                for (int r = 0; r < rightResult.size(); r++) {
                    TreeNode * node = new TreeNode(v[i]); 
                    node->right = rightResult[r]; 
                    result.push_back(node); 
                }
            }
            else {
                for (int l = 0; l < leftResult.size(); l++) {
                    for (int r = 0; r < rightResult.size(); r++) {
                        TreeNode * node = new TreeNode(v[i]); 
                        node->left = leftResult[l]; 
                        node->right = rightResult[r]; 
                        result.push_back(node); 
                    }
                }
            }
        }
        
        return result; 
    }
};
