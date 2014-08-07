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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return helper(head, null, head, n); 
    }
    
    private ListNode helper(ListNode head, ListNode prev, ListNode curr, int n) {
        if (curr == null) {
            cnt++; 
            return head; 
        }
        
        head = helper(head, curr, curr.next, n); 
        
        if (cnt == n) {
            if (prev == null) {
                head = curr.next; 
            } else {
                prev.next = curr.next; 
            }
        }
        
        cnt++; 
        
        return head; 
    } 
}
