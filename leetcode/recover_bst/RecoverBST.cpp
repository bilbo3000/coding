#include <iostream> 
#include <vector> 
#include <stack> 

using namespace std; 

 struct TreeNode {
 	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    void recoverTree(TreeNode *root) {
        if (root == NULL) {
            return; 
        }
        
        vector<int> inorder; 
        stack<TreeNode *> s; 
        TreeNode * curr = root; 
        
        while (curr != NULL || s.size() != 0) {
            if (curr == NULL) {
                curr = s.top(); 
                s.pop(); 
                inorder.push_back(curr->val); 
                curr = curr->right; 
            }
            else {
                s.push(curr); 
                curr = curr->left; 
            }
        }
        
        int a = 0; 
        int b = 0; 
        for (int i = 0; i < inorder.size(); i++) {
            if ((i == 0 && inorder[i] > inorder[i + 1]) || 
                (i < inorder.size() - 1 && inorder[i] > inorder[i + 1] && inorder[i - 1] < inorder[i + 1])) {
                a = inorder[i]; 
            }
            else if ((i == inorder.size() - 1 && inorder[i] < inorder[i - 1]) || 
                (i > 0 && inorder[i] < inorder[i - 1] && inorder[i - 1] < inorder[i + 1])) {
                b = inorder[i]; 
            }
        }
        
        curr = root; 
        
        while (curr != NULL || s.size() != 0) {
            if (curr == NULL) {
                curr = s.top(); 
                s.pop(); 
                if (curr->val == a) {
                    curr->val = b; 
                } 
                else if (curr->val == b) {
                    curr->val = a; 
                }
                
                curr = curr->right; 
            }
            else {
                s.push(curr); 
                curr = curr->left; 
            }
        }
    }
};

int main() {
	Solution sln; 
	TreeNode * root = new TreeNode(3); 
	root->left = new TreeNode(2);
	root->left->left = new TreeNode(1); 
	root->left->right = new TreeNode(4); 
	root->right = new TreeNode(5);
	
	sln.recoverTree(root); 
	
 	 	TreeNode * curr = root; 
	stack<TreeNode *> s; 
	
	while (curr != NULL || s.size() != 0) {
		if (curr == NULL) {
			curr = s.top(); 
			s.pop(); 
			cout << curr->val << endl; 
			curr = curr->right; 
		}
		else {
			s.push(curr);
			curr = curr->left;  
		}
	}
	return 0; 
}
