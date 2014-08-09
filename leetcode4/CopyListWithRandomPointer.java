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
        Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>(); 
        
        if (head == null) {
            return null; 
        }
        
        RandomListNode curr = head; 
        
        while (curr != null) {
            if (!m.containsKey(curr)) {
                RandomListNode node = new RandomListNode(curr.label);
                m.put(curr, node); 
            }
            
            if (curr.next != null) {
                if (!m.containsKey(curr.next)) {
                    RandomListNode node = new RandomListNode(curr.next.label);
                    m.put(curr.next, node); 
                }
                m.get(curr).next = m.get(curr.next); 
            }
            
            if (curr.random != null) {
                if (!m.containsKey(curr.random)) {
                    RandomListNode node = new RandomListNode(curr.random.label);
                    m.put(curr.random, node); 
                } 
                m.get(curr).random = m.get(curr.random); 
            }
            
            curr = curr.next; 
        }
        
        return m.get(head); 
    }
}
