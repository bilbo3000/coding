/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null; 
        }
        
        Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>(); 
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
        
        return m.get(head); 
    }
}
