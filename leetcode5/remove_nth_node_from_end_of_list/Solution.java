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
    private ListNode head = null; 
    private int cnt = 0; 
    
    public ListNode removeNthFromEnd(ListNode h, int n) {
        head = h; 
        helper(null, head, n);
        
        return head; 
    }
    
    private void helper(ListNode prev, ListNode curr, int n) {
        if (curr == null) {
            cnt++; 
            return; 
        }
        
        helper(curr, curr.next, n);
        
        if (cnt == n) {
            if (prev == null) {
                head = head.next; 
            } else {
                prev.next = curr.next;  
            }
        }
        
        cnt++; 
    }
}
