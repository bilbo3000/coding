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
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     * 
     * 1. Reverse the whole list
     * 2. Reverse back first k nodes
     * 3. Reverse back the remaining nodes. 
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        // First reverse the whole list
        ListNode prev = null; 
        ListNode curr = head;
        int len = 0; 

        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            len++; 
        }
        
        k = k % len; 
        head = prev; 
        
        // Reverse first k node
        prev = null; 
        curr = head; 
        
        while (k > 0) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            k--; 
        }
        
        // Reverse the remaining part 
        ListNode prev2 = null; 
        
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev2; 
            prev2 = curr; 
            curr = next; 
        }
        
        if (prev == null) {
            // Do not rotate
            return prev2; 
        }
        
        head.next = prev2; 
        
        return prev; 
    }
}
