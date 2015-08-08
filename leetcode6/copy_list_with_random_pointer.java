/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * 
 * Deep copy a list with random pointer. 
 * The idea was to use a map to map the node in given list to the 
 * nodes in the new list. For each node in given list, first constructs
 * the next node if not exist and setup next link. Then constructs the 
 * random node if not exist and setup random link. Then move on to next 
 * node. Return the node mapped by head if exists at the end. 
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> m = new HashMap<>();
        
        RandomListNode curr = head; 

        while (curr != null) {
            if (!m.containsKey(curr)) {
                m.put(curr, new RandomListNode(curr.label));
            }
           
            if (curr.next != null) {
                if (!m.containsKey(curr.next)) {
                    m.put(curr.next, new RandomListNode(curr.next.label)); 
                }
                
                m.get(curr).next = m.get(curr.next);
            }
            
            if (curr.random != null) {
                if (!m.containsKey(curr.random)) {
                    m.put(curr.random, new RandomListNode(curr.random.label));
                }
                
                m.get(curr).random = m.get(curr.random); 
            }
            
            curr = curr.next; 
        }
        
        if (!m.containsKey(head)) {
            return null; 
        }
        
        return m.get(head);
    }
}
