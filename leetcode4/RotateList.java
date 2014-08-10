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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null; 
        }
        
        ListNode curr = head; 
        ListNode prev = null; 
        int len = 0; 
        
        while (curr != null) {
            len++; 
            prev = curr; 
            curr = curr.next; 
        }
        
        int i = 0; 
        
        while (i < len - n % len) {
            if (head != null && prev != null && head != prev) {
                ListNode temp = head.next; 
                head.next = null; 
                prev.next = head; 
                prev = prev.next; 
                head = temp; 
            }
            
            i++; 
        }
        
        return head; 
    }
}
