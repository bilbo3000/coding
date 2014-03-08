#include <iostream> 

using namespace std; 

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    void removeHelper(ListNode * prev, ListNode * node, int n, int &cnt) {
        if (!node) {
            return; 
        }
        
        removeHelper(node, node->next, n, cnt);
        cnt++; 
        
        if (cnt == n) { // Remove
            if (prev == NULL) {
                node = node->next; 
            }
            else {
                prev->next = node->next; 
            }
        }
    }
    
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int cnt = 0; 
        ListNode * prev = NULL; 
        removeHelper(prev, head, n, cnt); 
        
        return head; 
    }
};

int main() {
    Solution sln; 
    ListNode * head = new ListNode(1);
    ListNode * tail = head; 
    
    for (int i = 2; i <= 5; i++) {
        tail->next = new ListNode(i);
        tail = tail->next; 
    } 
    
    ListNode * result = sln.removeNthFromEnd(head, 2); 
    
    while (result) {
        cout << result->val << " "; 
        result = result->next; 
    }
    cout << endl; 
    
    return 0; 
}
