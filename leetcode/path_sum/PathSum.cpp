#include <iostream> 

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:    
    bool hasPathSum(TreeNode *root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!root) {
            return false; 
        }
        
        if (root->left == NULL && root->right == NULL) {
            if (root->val == sum) {
                return true; 
            }
            else {
                return false; 
            }
        }
        
        int remain = sum - root->val; 
                
        return hasPathSum(root->left, remain) || hasPathSum(root->right, remain);
    }
};

int main() {
    Solution sln; 
    int sum = 6; 
    TreeNode * root = new TreeNode(1); 
    root->left = new TreeNode(2); 
    root->left->left = new TreeNode(3); 
    root->left->left->left = new TreeNode(4); 
    root->left->left->left->left = new TreeNode(5); 
    
    if (sln.hasPathSum(root, sum)) {
        cout << "true" << endl; 
    }
    else {
        cout << "false" << endl; 
    }
    return 0; 
}
