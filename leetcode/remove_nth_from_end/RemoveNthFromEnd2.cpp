#include <iostream> 

using namespace std; 
struct ListNode {
	int val;
 	ListNode *next;
 	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void removeHelper(ListNode * &head, ListNode * prev, ListNode * node, int n, int &cnt) { 
        if (node == NULL) {
            cnt++; 
            return; 
        }
        else {
            removeHelper(head, node, node->next, n, cnt); 

            if (cnt == n) {  // remove
                if (prev == NULL) {
                    head = node->next; 
                }
                else {
                    prev->next = node->next; 
                }
            }
            cnt++; 
            return; 
        }
    }
    
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!head) {
            return NULL; 
        }
        
        int cnt = 0; 
        
        removeHelper(head, NULL, head, n, cnt); 
        
        return head; 
    }
};

int main() {
	Solution sln; 
	ListNode * head; 
	head = new ListNode(1);
	head->next = new ListNode(2);  
	
	ListNode * result = sln.removeNthFromEnd(head, 1); 
	
	while (result) {
		cout << result->val << " "; 
		result = result->next; 
	}
	
	cout << endl; 
	
	return 0; 
}
