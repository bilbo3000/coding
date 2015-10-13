/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     * 
     * O(n).
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || k <= 1) {
            return head; 
        }
        
        ListNode prev = null; 
        ListNode curr = head; 
        
        // Count the length 
        int len = 0; 
        
        while (curr != null && len < k) {
            len++; 
            curr = curr.next; 
        }
        
        if (len < k) {
            return head; 
        }
        
        curr = head; 
        
        while (curr != null && len > 0) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            len--; 
        }
        
        head.next = reverseKGroup(curr, k);
        
        return prev; 
    }
}
