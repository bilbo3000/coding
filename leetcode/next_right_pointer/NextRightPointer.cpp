#include <iostream> 
#include <vector> 
#include <stack> 

using namespace std; 

struct TreeLinkNode {
    int val;
    TreeLinkNode *left, *right, *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (root == NULL) {
            return; 
        }
        
        vector<TreeLinkNode *> v; 
        v.push_back(root);
        
        while (v.size() != 0) { 
            // Build link of nodes on the stack 
            for (int i = 0; i < v.size() - 1; i++) {
                v[i]->next = v[i + 1]; 
            }
            v[v.size() - 1]->next = NULL; 
            
            // Popping elements from first stack to second stack 
            stack<TreeLinkNode *> temp; 
            
            while (v.size() != 0) {
                temp.push(v[v.size() - 1]);
                v.erase(--v.end());  
            }
            
            // Push children of elements in second stack into the first stack 
            while (temp.size() != 0) {
                if (temp.top()->left != NULL) {
                    v.push_back(temp.top()->left); 
                }
                
                if (temp.top()->right != NULL) {
                    v.push_back(temp.top()->right);  
                }
                
                temp.pop(); 
            }
        }
    }
};

int main() {
    TreeLinkNode * root = new TreeLinkNode(0);
    Solution sln; 
    sln.connect(root);
      
    return 0; 
}
