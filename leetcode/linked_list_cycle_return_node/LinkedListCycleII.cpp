#include <iostream> 
#include <map> 

using namespace std; 

 struct ListNode {
 	int val;
 	ListNode *next;
 	ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == NULL) {
            return NULL; 
        }
        
        ListNode * curr = head; 
        ListNode * prev = NULL; 
        map<ListNode *, ListNode *> history; 
        
        while (curr != NULL) {
            if (history.find(curr) != history.end()) {
                break; 
            }
            
            history[curr] = prev; 
            prev = curr; 
            curr = curr->next; 
        }
        
        if (!curr) {
            return NULL; 
        }
        
        while (true) {
            if (history[curr] != prev) {
                break;  
            }
            
            prev = curr; 
            curr = curr->next; 
        }
        
        return curr; 
    }
};

int main() {
	Solution sln; 
	
	return 0; 
}
