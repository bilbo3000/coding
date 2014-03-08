/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!head || head->next == NULL) {
            return head; 
        }
        
        ListNode * curr = head; 
        while (curr != NULL && curr->next != NULL) {
            if (curr->val == curr->next->val) {
                curr->next = curr->next->next; 
            } 
            else {
                curr = curr->next; 
            }
        }
        
        return head; 
    }
};
