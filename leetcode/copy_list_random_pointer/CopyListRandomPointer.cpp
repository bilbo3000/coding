/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        map<RandomListNode *, RandomListNode *> mapping; 
        RandomListNode * curr = head; 
        RandomListNode * newHead = NULL; 
        RandomListNode * newTail = NULL; 
        
        while (curr != NULL) {
            if (mapping.find(curr) == mapping.end()) {
                RandomListNode * newNode = new RandomListNode(curr->label); 
                mapping[curr] = newNode; 
                
                if (newTail == NULL) {
                    newHead = newNode; 
                    newTail = newNode; 
                }
                else {
                    newTail->next = newNode; 
                    newTail = newTail->next; 
                }
            }
            else {
                if (newTail == NULL) {
                    newHead = mapping[curr]; 
                    newTail = mapping[curr]; 
                }
                else {
                    newTail->next = mapping[curr]; 
                    newTail = newTail->next; 
                }
            }
            
            // Update random pointer 
            if (curr->random != NULL) {
                if (mapping.find(curr->random) == mapping.end()) {
                    RandomListNode * randNode = new RandomListNode(curr->random->label); 
                    mapping[curr->random] = randNode; 
                }
                
                newTail->random = mapping[curr->random]; 
            }
            
            curr = curr->next; 
        }
        
        return newHead; 
    }
};
