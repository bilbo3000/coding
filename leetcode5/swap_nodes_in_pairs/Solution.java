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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode temp = swapPairs(head.next.next);  
        ListNode next = head.next; 
        head.next = temp; 
        next.next = head; 
        
        return next; 
    }
}
