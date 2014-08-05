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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode prev = head; 
        ListNode curr = head.next; 
        
        while (curr != null) {
            if (curr.val != prev.val) {
                prev = curr; 
                curr = curr.next; 
            } else {
                prev.next = curr.next; 
                curr = prev.next; 
            }
        }
        
        return head; 
    }
}
