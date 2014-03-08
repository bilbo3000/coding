#include <iostream> 

using namespace std; 

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if (head == NULL) {
            return NULL; 
        }
        
        if (m == n) {
            return head; 
        }
        
        int cnt = 1; 
        ListNode * ALeft;
        ListNode * ARight; 
        ListNode * BLeft; 
        ListNode * BRight; 
        ListNode * curr = head; 
        ListNode * prev = NULL; 
        
        while (curr != NULL && cnt < m) {
            prev = curr; 
            curr = curr->next; 
            cnt++; 
        }
        
        ALeft = prev; 
        ARight = curr; 
        prev = NULL; 
        ListNode * temp = NULL; 
        
        while (curr != NULL && cnt <= n) {
            temp = curr->next; 
            curr->next = prev; 
            prev = curr; 
            curr = temp; 
            cnt++; 
        }
        
        BRight = curr; 
        BLeft = prev; 
        
        if (ALeft != NULL) {
            ALeft->next = BLeft; 
        }
        else {
            head = BLeft; 
        }
        
        if (ARight != NULL) {
            ARight->next = BRight; 
        }
        
        return head; 
    }
};

int main() {
    Solution sln; 
    ListNode * head = NULL; 
    for (int i = 5; i >= 1; i--) {
        ListNode * temp = new ListNode(i);
        temp->next = head; 
        head = temp;  
    }
    
    ListNode * result = sln.reverseBetween(head, 2, 4);
    
    while (result != NULL) {
        cout << result->val << " "; 
        result = result->next; 
    }
    
    return 0; 
}
