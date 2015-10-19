/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null; 
        }
        
        Map<RandomListNode, RandomListNode> m = new HashMap<>(); 
        RandomListNode curr = head; 
        
        while (curr != null) {
            if (!m.containsKey(curr)) {
                RandomListNode temp = new RandomListNode(curr.label);
                m.put(curr, temp);
            }
            
            if (curr.random != null && !m.containsKey(curr.random)) {
                RandomListNode temp = new RandomListNode(curr.random.label);
                m.put(curr.random, temp);
            }
            
            if (curr.next != null && !m.containsKey(curr.next)) {
                RandomListNode temp = new RandomListNode(curr.next.label);
                m.put(curr.next, temp);
            }
            
            if (curr.next != null) {
                m.get(curr).next = m.get(curr.next); 
            }
            
            if (curr.random != null) {
                m.get(curr).random = m.get(curr.random); 
            }
            
            curr = curr.next; 
        }
        
        return m.get(head);
    }
}
