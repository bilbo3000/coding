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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int cnt = 1; 
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (cnt < m) {
            prev = curr; 
            curr = curr.next; 
            cnt++;
        }
        
        // Now, curr points to the mth node. 
        ListNode rcurr = curr; 
        ListNode rprev = null; 
        
        while (cnt <= n) {
            ListNode temp = rcurr.next; 
            rcurr.next = rprev; 
            rprev = rcurr; 
            rcurr = temp; 
            cnt++; 
        }
        
        curr.next = rcurr; 
        
        if (prev != null) {
            prev.next = rprev; 
        }
        else {
            head = rprev; 
        }
        
        return head; 
    }
}
