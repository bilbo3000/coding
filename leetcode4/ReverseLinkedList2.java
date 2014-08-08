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
        ListNode prev = null; 
        ListNode curr = head; 
        int cnt = 1; 
        
        while (curr != null && cnt < m) {
            prev = curr; 
            curr = curr.next; 
            cnt++; 
        }
        
        ListNode mPrev = null; 
        ListNode mCurr = null;
        
        if (curr != null) {
            mPrev = prev; 
            mCurr = curr; 
            prev = null; 
        }
        
        ListNode next = null; 
        
        // Reverse 
        while (curr != null && cnt <= n) {
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            cnt++; 
        }
        
        ListNode nPrev = null; 
        ListNode nCurr = null; 
        nPrev = prev; 
        nCurr = curr; 
        
        if (mCurr != null) {
            mCurr.next = nCurr; 
        }
        
        if (mPrev != null) {
            mPrev.next = nPrev;  
        } else {
            head = nPrev; 
        }
        
        return head; 
    }
}
