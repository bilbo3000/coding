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
    bool hasCycle(ListNode *head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (!head) {
            return false; 
        }
        
        ListNode * slow = head; 
        ListNode * fast = head->next; 
        while (fast != NULL && fast != slow) {
            if (fast->next != NULL) {
                fast = fast->next; 
                if (fast == slow) {
                    return true; 
                }
            }
            
            fast = fast->next; 
            slow = slow->next; 
        }
        
        if (fast == NULL) {
            return false; 
        }
        else {
            return true; 
        }
    }
};
