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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null; 
        }
        
        int cnt = 0; 
        ListNode curr = head; 
        
        while (curr != null && cnt < k) {
            curr = curr.next; 
            cnt++; 
        }
        
        if (cnt != k) {
            return head; 
        } else {
            ListNode temp = reverseKGroup(curr, k);
            
            ListNode ptrNext = null; 
            ListNode ptrCurr = head; 
            ListNode ptrPrev = null; 
            int num = 0; 
            
            while (num < k) {
                ptrNext = ptrCurr.next; 
                ptrCurr.next = ptrPrev; 
                ptrPrev = ptrCurr; 
                ptrCurr = ptrNext; 
                num++; 
            }
            
            if (head != null) {
                head.next = temp; 
            }
            
            return ptrPrev; 
        }
    }
}
