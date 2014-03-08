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
        if (head == null || head.next == null || head.next.next == null) return;
        
        // Split the list into halves 
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        fast = slow.next; 
        slow.next = null; 
        slow = head; 
        
        // Reverse the second half
        ListNode prev = null; 
        ListNode curr = fast; 
        
        while (curr != null) {
            ListNode temp = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = temp; 
        }
        
        fast = prev; 
        
        // Merge two lists 
        while (fast != null) {
            ListNode temp = fast.next; 
            fast.next = slow.next; 
            slow.next = fast; 
            slow = slow.next.next; 
            fast = temp; 
        }
    }
}
