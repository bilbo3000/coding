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
        if (k <= 1) {
            return head; 
        }
        
        int cnt = 0;
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null && cnt < k) {
            prev = curr; 
            curr = curr.next; 
            cnt++; 
        }
        
        if (cnt == k) {
            ListNode temp = reverseKGroup(curr, k);
            ListNode ptr = head; 
            ListNode ptrPrev = null; 
            prev.next = null; 
            
            while (ptr != null) {
                ListNode next = ptr.next; 
                ptr.next = ptrPrev; 
                ptrPrev = ptr; 
                ptr = next; 
            }
            
            head.next = temp; 
            head = prev; 
        } 
        
        return head; 
    }
}
