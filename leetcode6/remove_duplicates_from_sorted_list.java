/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Remove duplicates from sorted. 
 * Linear solution. Iterate through the list via curr and prev. If the current node 
 * has the same value as the next node. Then remove current node. Make sure to 
 * consider edge cases. i.e. need to update head if removing the first node. 
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            // Remove
            if (curr.next != null && curr.val == curr.next.val) {
                if (prev != null) {
                    prev.next = curr.next; 
                    curr = curr.next;
                } else {
                    curr = curr.next; 
                    head = curr; 
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
