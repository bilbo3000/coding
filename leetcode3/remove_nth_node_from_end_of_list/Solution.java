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
    private int cnt = 0; 
    private ListNode head; 
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.head = head; 
        helper(null, head, n);
        
        return this.head; 
    }
    
    private void helper(ListNode prev, ListNode curr, int n) {
        if (curr == null) {
            return; 
        }
        
        helper(curr, curr.next, n); 
        cnt++; 
        
        if (cnt == n) {
            if (prev == null) {
                head = curr.next; 
            }
            else {
                prev.next = curr.next; 
            }
        }
    }
}
