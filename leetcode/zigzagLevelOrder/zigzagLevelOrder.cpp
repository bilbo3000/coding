#include <iostream> 
#include <queue> 
#include <vector> 
#include <algorithm> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        if (!root) {
            return result; 
        }
        
        int lev1 = 1; 
        int lev2 = 0; 
        int cnt = 1; 
        queue<TreeNode *> q; 
        vector<int> nextLevel; 
        vector<int> temp; 
        temp.push_back(root->val);
        result.push_back(temp); 
        q.push(root); 
        
        while (q.size() != 0) {
            TreeNode * curr = q.front(); 
            q.pop(); 
            lev1--; 
            
            if (curr->left != NULL) {
                q.push(curr->left);
                nextLevel.push_back(curr->left->val); 
                lev2++; 
            }
            
            if (curr->right != NULL) {
                q.push(curr->right);
                nextLevel.push_back(curr->right->val); 
                lev2++; 
            }
            
            if (lev1 == 0) {
                lev1 = lev2; 
                lev2 = 0; 
                cnt++; 
                
                if (nextLevel.size() != 0) {
                    if (cnt % 2 == 0) {
                        reverse(nextLevel.begin(), nextLevel.end()); 
                    }
                    
                    result.push_back(nextLevel);
                    nextLevel.clear(); 
                }
            }
        }
        
        return result; 
    }
};

int main() {
    Solution sln; 
    /*
    TreeNode * root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);
    */
    TreeNode * root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->left->left = new TreeNode(4);
    root->left->left->left->left = new TreeNode(5);
          
    vector<vector<int> > result = sln.zigzagLevelOrder(root); 
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        
        cout << endl; 
    }
    return 0; 
}
