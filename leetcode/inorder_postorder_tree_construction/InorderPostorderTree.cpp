#include <iostream> 
#include <vector> 

using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode *buildTreeHelper(vector<int> in, vector<int> post, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return NULL; 
        }
        
        int rootVal = post[postRight]; 
        
        TreeNode * root = new TreeNode(rootVal); 
        
        int i = inLeft; 
        while (i <= inRight) {
            if (in[i] == rootVal) {
                break; 
            }
            i++; 
        }
        
        int leftSize = i - inLeft; 
        int rightSize = inRight - i; 
        root->left = buildTreeHelper(in, post, inLeft, i - 1, postLeft, postLeft + leftSize - 1); 
        root->right = buildTreeHelper(in, post, i + 1, inRight, postLeft + leftSize, postLeft + (leftSize + rightSize) - 1); 
        
        return root; 
    }
    
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return buildTreeHelper(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1); 
    }
    
    void inorder(TreeNode * node) {
        if (!node) {
            return; 
        }
        
        cout << node->val << " "; 
        inorder(node->left);
        inorder(node->right);  
    }
};

int main() {
    Solution sln; 
    int in[] = {4, 2, 5, 1, 6, 3, 7};
    int post[] = {4, 5, 2, 6, 7, 3, 1};  
    vector<int> inorder(in, in + sizeof(in)/sizeof(int)); 
    vector<int> postorder(post, post + sizeof(post)/sizeof(int));   
    TreeNode * result = sln.buildTree(inorder, postorder); 
    
    sln.inorder(result); 
    
    return 0; 
}
