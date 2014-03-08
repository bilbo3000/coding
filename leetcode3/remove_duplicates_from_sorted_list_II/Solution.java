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
        ListNode curr = head; 
        ListNode prev = null; 
        boolean dup = false; 
        
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next; 
                dup = true; 
            }
            else {
                if (dup) { // Delete current node 
                    if (prev != null) {
                        curr = curr.next; 
                        prev.next = curr; 
                    }
                    else {
                        curr = curr.next; 
                        head = curr; 
                    }
                    
                    dup = false; 
                }
                else {
                    prev = curr; 
                    curr = curr.next; 
                }
            }
        }
        
        return head; 
    }
}
