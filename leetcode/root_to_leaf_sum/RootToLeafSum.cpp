/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
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
    int sum; 
    void findSum(TreeNode * node, int num) {
        if (node == NULL) {
            return; 
        }
        
        int currValue = num * 10 + node->val; 
        
        if (node->left == NULL && node->right == NULL) {  // Leaf 
            sum = sum + currValue; 
            return; 
        }
        
        if (node->left != NULL) {
            findSum(node->left, currValue); 
        }
        
        if (node->right != NULL) {
            findSum(node->right, currValue); 
        }
    }
    
    int sumNumbers(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sum = 0; 
        
        if (root == NULL) {
            return 0; 
        }
        
        findSum(root, 0);  
        
        return sum; 
    }
};

int main() {
    Solution sln; 
    TreeNode * root = new TreeNode(0);
    root->left = new TreeNode(1);
    
    cout << sln.sumNumbers(root) << endl;   
    return 0; 
}
