class Solution {
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (preorder.size() == 0 || inorder.size() == 0) {
            return NULL; 
        }
        
        map<int, int> mapping; 
        for (int i = 0; i < inorder.size(); i++) {
            mapping[inorder[i]] = i; 
        }
        
        return helper(preorder, inorder, 0, inorder.size() - 1, 0, preorder.size() - 1, mapping); 
    }
    
    TreeNode * helper(vector<int> &preorder, vector<int> &inorder, int a, int b, int c, int d, map<int, int> &mapping) {
        if (a > b || c > d) {
            return NULL; 
        }
        
        int rootVal = preorder[c]; 
        int i = mapping[rootVal];
        TreeNode * node = new TreeNode(rootVal); 
        node->left = helper(preorder, inorder, a, i - 1, c + 1, i - a + c, mapping); 
        node->right = helper(preorder, inorder, i + 1, b, d - b + i + 1, d, mapping); 
        
        return node; 
    }
};
