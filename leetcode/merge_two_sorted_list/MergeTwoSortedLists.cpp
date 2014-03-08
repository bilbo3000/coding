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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.       
        ListNode * head = NULL; 
        ListNode * tail = NULL; 
        
        while (l1 != NULL && l2 != NULL) {
            if (l1->val < l2->val) {
                if (head == NULL) {
                    head = l1; 
                    tail = l1; 
                    l1 = l1->next; 
                    tail->next = NULL; 
                }
                else {
                    tail->next = l1; 
                    tail = tail->next; 
                    l1 = l1->next; 
                    tail->next = NULL; 
                }
            }else {
                if (head == NULL) {
                    head = l2; 
                    tail = l2; 
                    l2 = l2->next; 
                    tail->next = NULL; 
                }
                else {
                    tail->next = l2; 
                    tail = tail->next; 
                    l2 = l2->next; 
                    tail->next = NULL; 
                }
            }
        }
        
        if (l1 == NULL && l2 != NULL) {
            if (head == NULL) {
                return l2; 
            }
            else {
                tail->next = l2; 
            }
        }
        else if (l1 != NULL && l2 == NULL){
            if (head == NULL) {
                return l1; 
            }
            else {
                tail->next = l1; 
            }
        }
        
        return head; 
    }
};
