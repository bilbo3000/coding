#include <iostream> 

using namespace std; 

 struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!head) {
            return NULL; 
        }
        
        if (head->next == NULL) {
            return new TreeNode(head->val); 
        }
        
        ListNode * curr1 = head; 
        ListNode * curr2 = head->next; 
        ListNode * prev = NULL; 
        
        while (curr2 != NULL && curr2->next != NULL) {
            prev = curr1; 
            curr1 = curr1->next; 
            curr2 = curr2->next->next; 
        }
        
        TreeNode * root = new TreeNode(curr1->val); 
        ListNode * head2 = curr1->next; 
        if (prev != NULL) {
            prev->next = NULL; 
        }
        else {
            head = NULL; 
        }
        
        root->left = sortedListToBST(head);
        root->right = sortedListToBST(head2);
        
        return root; 
    }
    
    void inorder(TreeNode * root) {
        if (!root) {
            return; 
        }
        
        cout << root->val << endl; 
        inorder(root->left);
        inorder(root->right);  
    }
};

int main() {
    Solution sln; 
   
    ListNode * head = new ListNode(1); 
    head->next = new ListNode(2); 
    head->next->next = new ListNode(3); 
    
    TreeNode * result = sln.sortedListToBST(head);
    
    sln.inorder(result);  
    return 0; 
}
