#include <iostream> 

using namespace std; 

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (!head || !head->next) {
            return head; 
        }
        
        ListNode * prev = NULL; 
        ListNode * curr = head; 
        ListNode * tail = NULL; 
        int cnt = 0; 
        
        // Find tail
        while (curr != NULL) {
            cnt++; 
            prev = curr; 
            curr = curr->next; 
        }

        tail = prev;  
        
        // Manipulate
        curr = head; 
        prev = NULL; 
        while (curr != NULL && cnt > 0) {
            cnt--; 
            if (curr->val >= x) {
                if (prev == NULL) {
                    head = curr->next; 
                    tail->next = curr; 
                    tail = tail->next; 
                    tail->next = NULL; 
                    curr = head; 
                }
                else {
                    prev->next = curr->next; 
                    if (prev->next == NULL) {
                        tail = prev; 
                    }
                    
                    tail->next = curr; 
                    tail = tail->next; 
                    tail->next = NULL; 
                    curr = prev->next; 
                }
            }
            else {
                prev = curr; 
                curr = curr->next; 
            }
        }
        
        return head; 
    }
};

int main() {
    Solution sln; 
    ListNode * head = new ListNode(1);
    head->next = new ListNode(2); 
    ListNode * result = sln.partition(head, 2);
    cout << result->val << endl; 
    while (result != NULL) {
        cout << result->val << " "; 
        result = result->next; 
    }  
    return 0; 
}
