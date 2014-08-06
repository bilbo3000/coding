/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        ListNode slow = head; 
        ListNode fast = head; 
        
        while (fast != null) {
            fast = fast.next; 
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
                
                if (slow == fast) {  // meet
                    ListNode node = head; 
                    
                    while (node != slow) {
                        node = node.next; 
                        slow = slow.next; 
                    }
                    
                    return node; 
                }
            }
        }
        
        return null; 
    }
}
