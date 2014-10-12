/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode prev = null; 
        ListNode curr = head; 
        ListNode last = null; 
        
        while (curr != null) {
            if (curr.val < x) {
                if (last == null) {
                    if (prev != null) {
                        prev.next = curr.next; 
                        curr.next = head; 
                        last = curr; 
                        head = curr; 
                        curr = prev.next; 
                    } else {
                        last = curr; 
                        prev = curr; 
                        curr = curr.next; 
                    }
                } else {  // Last != null, prev cannot be null
                    if (last.next == curr) {
                        last = curr; 
                        prev = curr; 
                        curr = curr.next; 
                    } else {
                        prev.next = curr.next; 
                        curr.next = last.next;  
                        last.next = curr; 
                        last = curr; 
                        curr = prev.next; 
                    }
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
