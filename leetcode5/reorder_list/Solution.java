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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        // Reverse second half 
        ListNode curr = slow.next; 
        ListNode prev = null; 
        slow.next = null; 
        
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        // Merge 
        ListNode i = head; 
        ListNode j = prev; 
        
        while (j != null) {
            ListNode next = i.next; 
            i.next = j; 
            j = j.next; 
            i.next.next = next; 
            i = i.next.next; 
        }
    }
}
