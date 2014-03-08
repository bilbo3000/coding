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
    ListNode *sortList(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return head; 
        }
        
        ListNode * slow = head; 
        ListNode * fast = head->next; 
        
        while (fast != NULL) {
            fast = fast->next; 
            
            if (fast != NULL) {
                fast = fast->next; 
                slow = slow->next; 
            }
        }
        
        ListNode * temp = slow->next; 
        slow->next = NULL; 
        
        ListNode * head1 = sortList(head); 
        ListNode * head2 = sortList(temp); 
        
        ListNode * result = NULL; 
        ListNode * i = head1; 
        ListNode * j = head2; 
        ListNode * k = result; 
        
        while (i != NULL && j != NULL) {
            if (i->val < j->val) {
                if (k == NULL) {
                    result = i; 
                    k = i; 
                    i = i->next; 
                    k->next = NULL;
                }
                else {
                    k->next = i; 
                    i = i ->next; 
                    k = k->next; 
                    k->next = NULL; 
                }
            }
            else {
                if (k == NULL) {
                    result = j; 
                    k = j; 
                    j = j->next; 
                    k->next = NULL; 
                }
                else {
                    k->next = j; 
                    j = j->next; 
                    k = k->next; 
                    k->next = NULL;
                }
            }
        }
        
        if (i == NULL) {
            if (k == NULL) {
                result = j; 
            }
            else {
                k->next = j; 
            }
        }
        else {
            if (k == NULL) {
                result = i; 
            }
            else {
                k->next = i; 
            }
        }
        
        return result; 
    }
};
