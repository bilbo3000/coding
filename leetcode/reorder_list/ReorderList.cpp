#include <iostream> 

using namespace std;
 
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void reorderList(ListNode *head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (!head || !head->next) {
            return; 
        }
        
        ListNode * prev = NULL; 
        ListNode * curr = head; 
        while (curr->next != NULL) {
            prev = curr; 
            curr = curr->next; 
        }
        
        if (prev != NULL) {
            prev->next = NULL; 
        }
        
        ListNode * next = head->next; 
        head->next = curr; 
        curr->next = next; 
        
        reorderList(curr->next); 
    }
};

int main() {
	Solution sln; 
	ListNode * head = new ListNode(1); 
	head->next = new ListNode(2);
	head->next->next = new ListNode(3); 
	head->next->next->next = new ListNode(4); 
	 
	sln.reorderList(head); 
	
	while (head) {
		cout << head->val << endl; 
		head = head->next; 
	}
	return 0; 
}
