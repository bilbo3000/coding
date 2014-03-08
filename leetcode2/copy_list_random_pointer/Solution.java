/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private RandomListNode h = null; 
    private RandomListNode t = null; 
    private Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
    
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head; 
        
        while (curr != null) {
            if (!m.containsKey(curr)) {
                RandomListNode temp = new RandomListNode(curr.label); 
                m.put(curr, temp); 
            }
            
            RandomListNode newNode = m.get(curr);
            
            if (h == null) {
                h = newNode; 
                t = newNode; 
            }
            else {
                t.next = newNode; 
                t = t.next; 
            }
            
            if (curr.random != null) {
                if (!m.containsKey(curr.random)) {
                    RandomListNode temp = new RandomListNode(curr.random.label); 
                    m.put(curr.random, temp); 
                }
                
                newNode.random = m.get(curr.random);
            }
            
            curr = curr.next; 
        }
        
        return h; 
    }
}
