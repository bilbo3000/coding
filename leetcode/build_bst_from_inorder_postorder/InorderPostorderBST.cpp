#include <iostream> 
#include <vector> 
#include <map> 

using namespace std; 

struct TreeNode {
	int val;
 	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        if (inorder.size() == 0 || postorder.size() == 0) {
            return NULL; 
        }
        
        map<int, int> mapping; 
        for (int i = 0; i < inorder.size(); i++) {
            mapping[inorder[i]] = i; 
        }
        
        return helper(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1, mapping); 
    }
    
    TreeNode * helper(vector<int> &inorder, vector<int> &postorder, int a, int b, int c, int d, map<int, int> &mapping) {
    	 
        if (a > b || c > d) {
            return NULL; 
        }
        
        int rootVal = postorder[d]; 
        TreeNode * node = new TreeNode(rootVal); 
        int i = mapping[rootVal]; 
        
        node->left = helper(inorder, postorder, a, i - 1, c, c + i - a - 1, mapping); 
        node->right = helper(inorder, postorder, i + 1, b, d - b + i, d - 1, mapping); 
        
        return node; 
    }
};

int main() {
	Solution sln; 
	// [-4,-10,3,-1,7,11,-8,2], [-4,-1,3,-10,11,-8,2,7]
	int in[] = {-4,-10,3,-1,7,11,-8,2}; 
	int post[] = {-4,-1,3,-10,11,-8,2,7}; 
	vector<int> inorder(in, in + sizeof(in) / sizeof(int)); 
	vector<int> postorder(post, post + sizeof(post) / sizeof(int)); 
	sln.buildTree(inorder, postorder); 
	return 0; 
}
