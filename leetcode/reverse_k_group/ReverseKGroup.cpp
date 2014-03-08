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
    ListNode *reverseKGroup(ListNode *head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == NULL) {
            return NULL; 
        }
        
        int length = 0; 
        ListNode * curr = head; 
        while (curr != NULL) {
            length++; 
            curr = curr->next; 
        }
        
        if (length < k) {
            return head; 
        }
        
        int cnt = 0; 
        curr = head;
        ListNode * prev = NULL; 
        
        while (cnt < k && curr != NULL) {
            ListNode * temp = curr->next; 
            curr->next = prev; 
            prev = curr; 
            curr = temp; 
            cnt++; 
        }
        
        head->next = reverseKGroup(curr, k); 
        return prev; 
    }
};
