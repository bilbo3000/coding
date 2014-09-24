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
            }
            
            if (slow == fast) {
                break; 
            }
        }
        
        if (fast == null) {
            return null; 
        }
        
        ListNode temp = head; 
        
        while (temp != slow) {
            temp = temp.next; 
            slow = slow.next; 
        }
        
        return temp; 
    }
}
