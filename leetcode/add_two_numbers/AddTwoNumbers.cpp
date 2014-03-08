#include <iostream> 

using namespace std; 

typedef struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
} ListNode;
 
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int digit = 0; 
        int carry = 0; 
        ListNode * results = NULL;
        ListNode * tail = NULL; 
        
        while (l1 != NULL && l2 != NULL) {
            int sum = l1->val + l2->val + carry; 
            l1 = l1->next; 
            l2 = l2->next; 
            
            digit = sum % 10; 
            carry = sum / 10; 
            
            ListNode * newNode = new ListNode(digit); 
            
            if (results == NULL) {
                results = newNode; 
                tail = newNode; 
            }
            else {
                tail->next = newNode; 
                tail = tail->next; 
            }
        }
        
        if (l1 == NULL && l2 != NULL) {  // Add rest of l2
            while (l2 != NULL) {
                int sum = l2->val + carry; 
                l2 = l2->next; 
                
                digit = sum % 10; 
                carry = sum / 10; 
                
                ListNode * newNode = new ListNode(digit); 
                    
                if (results == NULL) {
                    results = newNode; 
                    tail = newNode; 
                }
                else {
                    tail->next = newNode; 
                    tail = tail->next; 
                }
            }
        }
        
        if (l1 != NULL && l2 == NULL){  // Add rest of l1
            while (l1 != NULL) {
                int sum = l1->val + carry; 
                l1 = l1->next; 
                
                digit = sum % 10; 
                carry = sum / 10; 
                
                ListNode * newNode = new ListNode(digit); ; 
                    
                if (results == NULL) {
                    results = newNode; 
                    tail = newNode; 
                }
                else {
                    tail->next = newNode; 
                    tail = tail->next; 
                }
            }
        }
        
            if (carry != 0) {
                ListNode * newNode = new ListNode(carry); ; 
                    
                if (results == NULL) {
                    results = newNode; 
                    tail = newNode; 
                }
                else {
                    tail->next = newNode; 
                    tail = tail->next; 
                }
            }
        
        return results; 
    }
};

int main() {
    Solution sln; 
    ListNode * l1; 
    ListNode * l2; 
    
    ListNode * n11 = new ListNode(2); 
    ListNode * n12 = new ListNode(4); 
    ListNode * n13 = new ListNode(3);
    l1 = n11; 
    n11->next = n12; 
    n12->next = n13; 
    
    ListNode * n21 = new ListNode(5);
    ListNode * n22 = new ListNode(6);
    ListNode * n23 = new ListNode(4); 
    l2 = n21; 
    n21->next = n22; 
    n22->next = n23; 
    
    
     
    ListNode * result = sln.addTwoNumbers(l1, l2);
    
    while (result != NULL) {
        cout << result->val << " "; 
        result = result->next;
    }
    
    cout << endl; 
        
    return 0; 
}
