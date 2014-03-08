#include <iostream> 

using namespace std; 

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == NULL || head->next == NULL) {
            return head; 
        }
        
        ListNode * curr = head; 
        ListNode * prev = NULL; 
        bool hasDeleted = false; 
        
        while (curr != NULL ) {
            if (curr->next != NULL && curr->val == curr->next->val) {
                hasDeleted = true; 
                curr->next = curr->next->next; 
            }
            else {
                if (hasDeleted) {
                    if (curr == head) {
                        head = curr->next; 
                        curr = curr->next; 
                    }
                    else {
                        prev->next = curr->next; 
                        curr = prev->next; 
                    }
                    
                    hasDeleted = false; 
                }
                else {
                    prev = curr; 
                    curr = curr->next; 
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
    head->next->next = new ListNode(1); 
    
    ListNode * result = sln.deleteDuplicates(head);
    
    while (result != NULL) {
        cout << result->val << " "; 
        result = result->next; 
    } 
    return 0; 
}
