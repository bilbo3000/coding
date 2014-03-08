#include <iostream> 

using namespace std; 

struct ListNode {
 	int val;
 	ListNode *next;
 	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *insertionSortList(ListNode *head) {
        if (!head || head->next == NULL) {
            return head;
        }
        
        ListNode * prev = head; 
        ListNode * curr = head->next; 
        
        while (curr != NULL) {
            ListNode * temp = head; 
            ListNode * tempPrev = NULL; 
            
            while (temp != curr && temp->val < curr->val) {
                tempPrev = temp; 
                temp = temp->next; 
            }
            
            if (temp == curr) {
                prev = curr; 
                curr = curr->next; 
            }
            else {
                if (tempPrev == NULL) {
                    prev->next = curr->next; 
                    curr->next = temp; 
                    head = curr; 
                    curr = prev->next; 
                }
                else {
                    prev->next = curr->next; 
                    curr->next = temp; 
                    tempPrev->next = curr; 
                    curr = prev->next; 
                }
            }
        }
        
        return head; 
    }
};

int main() { 
	Solution sln; 
	ListNode * head = new ListNode(2); 
	head->next = new ListNode(1); 

	ListNode * result = sln.insertionSortList(head);
	while (result != NULL) {
		cout << result->val << " "; 
		result = result->next; 
	} 
	return 0; 
}
