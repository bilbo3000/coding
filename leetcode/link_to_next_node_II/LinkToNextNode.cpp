#include <iostream> 
#include <vector> 
#include <queue> 

using namespace std; 

struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
    void connect(TreeLinkNode *root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (!root) {
            return; 
        }
        
        queue<TreeLinkNode *> q; 
        root->next = NULL; 
        q.push(root); 
        vector<TreeLinkNode *> v; 
        int lev1 = 1; 
        int lev2 = 0; 
        
        while (q.size() != 0) {
            TreeLinkNode * curr = q.front(); 
            q.pop(); 
            lev1--; 
             
            if (curr->left != NULL) {
                q.push(curr->left); 
                v.push_back(curr->left); 
                lev2++; 
            }
            
            if (curr->right != NULL) {
                q.push(curr->right); 
                v.push_back(curr->right); 
                lev2++; 
            }
            
            if (lev1 == 0) { 
                lev1 = lev2; 
                lev2 = 0;
                
                int vsize = v.size(); 
                
                for (int i = 0; i < vsize - 1; i++) {
                    v[i]->next = v[i + 1]; 
                }
                
                 
                if (v.size() > 0) {
                    v[v.size() - 1]->next = NULL;    
                }
                
            	v.clear();
            }
        }
    }
};

int main() {
	Solution sln; 
	TreeLinkNode * node = new TreeLinkNode(0); 
	sln.connect(node); 
	return 0; 
}
