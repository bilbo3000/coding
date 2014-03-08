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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null; 
        }
        
        ListNode curr = head; 
        int n = 0; 
        
        while (curr != null && n < k) {
            curr = curr.next; 
            n++; 
        }
        
        if (n < k) {  // Left over 
            return head; 
        }
        
        ListNode temp = reverseKGroup(curr, k); 
        ListNode prev = temp; 
        n = 0; 
        
        while (head != null && n < k) {
            ListNode next = head.next; 
            head.next = prev; 
            prev = head; 
            head = next;
            n++; 
        }
        
        return prev; 
    }
}
