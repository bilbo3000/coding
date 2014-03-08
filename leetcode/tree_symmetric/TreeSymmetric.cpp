#include <iostream> 
#include <vector> 
#include <queue> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!root) {
            return true; 
        }
        
        int lev1Dup = 1;  // Number of elements in the previous level
        int lev1 = 1; // Number of elements to be processed at current level 
        int lev2 = 0; // Number of elements have been added to the next level
        queue<TreeNode *> q; 
        vector<TreeNode *> v; 
        q.push(root); 
        
        while (q.size() != 0) {
            TreeNode * curr = q.front(); 
            q.pop(); 
            lev1--; 
            
            if (curr->left != NULL) {
                q.push(curr->left); 
                lev2++; 
            }
            v.push_back(curr->left); 

            if (curr->right != NULL) {
                q.push(curr->right); 
                lev2++; 
            }
            v.push_back(curr->right); 

            if (lev1 == 0) {
                int i = 0;
                int j = v.size() - 1; 
                
                while (i < j) {
                    if (v[i] && !v[j] || !v[i] && v[j]) {
                        return false; 
                    }
                    
                    if (v[i] && v[j] && (v[i]->val != v[j]->val)) {
                        return false; 
                    }
                    
                    i++; 
                    j--; 
                }
                
                v.clear(); 
                lev1 = lev2; 
                lev1Dup = lev2; 
                lev2 = 0; 
            } 
            
        }
        
        return true;
    }
};
// Test driver 
int main() {
    Solution sln; 
    TreeNode * root = new TreeNode(1);
    root->left = new TreeNode(2); 
    root->right = new TreeNode(2); 
    root->left->right = new TreeNode(3); 
    root->right->left = new TreeNode(3); 
     
    if (sln.isSymmetric(root)) {
        cout << "true" << endl; 
    }
    else {
        cout << "false" << endl; 
    }
    return 0; 
}
