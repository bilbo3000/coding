#include <iostream> 
#include <vector> 

using namespace std; 

struct ListNode {
	int val; 
	ListNode * next; 
	ListNode(int x) : val(x), next(NULL) {}
}; 

class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (lists.size() == 0) {
            return NULL; 
        }
        
        if (lists.size() == 1) {
            return lists[0]; 
        }
        
        // Merge
        int mid = lists.size() / 2; 
        vector<ListNode *> list1; 
        vector<ListNode *> list2; 
        for (int i = 0; i < lists.size(); i++) {
            if (i < mid) {
                list1.push_back(lists[i]); 
            }
            else {
                list2.push_back(lists[i]); 
            }
        }
        
        ListNode * l1 = mergeKLists(list1); 
        ListNode * l2 = mergeKLists(list2);
        
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
            }
            else {
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
        
        if (l1 == NULL) {
        	if (head == NULL) {
        		head = l2; 
        	}
        	else {
            	tail->next = l2; 
            }
        }
        else {
        	if (head == NULL) {
            	head = l1; 
            }
            else {
            	tail->next = l1; 
            }
        }
        
        return head; 
    }
};

// Test driver 
int main() {
	vector<ListNode *> input; 
	input.push_back(NULL);
	input.push_back(NULL);
	  
	Solution sln; 
	sln.mergeKLists(input); 
	
	return 0; 
}