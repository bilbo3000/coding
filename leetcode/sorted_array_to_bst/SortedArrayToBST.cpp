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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        int n = num.size(); 
        if (n == 0) {
            return NULL; 
        }
        
        int mid = (n - 1) / 2; 
        TreeNode * newNode = new TreeNode(num[mid]);
        
        if ((mid - 1) >= 0) {
            vector<int> left; 
            left.assign(num.begin(), num.begin() + mid); 
            newNode->left = sortedArrayToBST(left); 
        }
        
        if (mid + 1 < n) {
            vector<int> right; 
            right.assign(num.begin() + mid + 1, num.end()); 
            newNode->right = sortedArrayToBST(right); 
        }
        
        return newNode; 
    }
    
    void Print(TreeNode * node) {
        if (node == NULL) {
            return; 
        }
        
        Print(node->left); 
        cout << node->val << " "; 
        Print(node->right); 
    }
};

int main() {
    Solution sln; 
    vector<int> num; 
    num.push_back(1);
    num.push_back(2); 
    num.push_back(3); 
    num.push_back(4); 
    
    TreeNode * result = sln.sortedArrayToBST(num);
    sln.Print(result);
     
    return 0; 
}
