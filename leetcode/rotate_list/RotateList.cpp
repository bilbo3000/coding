#include <iostream> 

using namespace std; 

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (!head) {
            return NULL; 
        }
        
        ListNode * curr = head; 
        int len = 0; 
        while (curr) {
            len++; 
            curr = curr->next; 
        }
        
        k = k % len; 
        if (k == 0) {
            return head; 
        }
        
        ListNode * prev = NULL; 
        curr = head; 
        int cnt = 0; 
        helper(curr, prev, head, cnt, k); 
        
        return head; 
    }
     
    void helper(ListNode * curr, ListNode* prev, ListNode* &head, int &n, int k) {
        if (!curr) {
            return; 
        }
        
        helper(curr->next, curr, head, n, k); 
        n++; 
        if (n == k) {
        	if (prev != NULL) {
            	prev->next = NULL; 
            }
            ListNode * temp = curr; 
            while (temp->next != NULL) {
                temp = temp->next; 
            }
            temp->next = head; 
            head = curr; 
        }
    }
};

int main() {
	Solution sln; 
	ListNode * head = new ListNode(1);
	head->next = new ListNode(2);  
	ListNode * result = sln.rotateRight(head, 1);
	
	cout << result->val << endl; 
	cout << result->next->val << endl; 
	return 0; 
}
