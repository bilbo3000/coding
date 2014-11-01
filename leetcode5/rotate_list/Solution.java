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
            return head; 
        }
        
        int len = 0; 
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            len++; 
            prev = curr; 
            curr = curr.next; 
        }
        
        n = n % len; 
        
        if (n == 0) {
            return head; 
        }
        
        int k = len - n; 
        ListNode tail = prev; 
        curr = head; 
        prev = null; 
        
        while (k > 0) {
            prev = curr; 
            curr = curr.next; 
            k--; 
        }
        
        prev.next = null; 
        tail.next = head; 
        
        return curr; 
    }
}
