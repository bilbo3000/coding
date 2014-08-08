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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            ListNode ptrCurr = head; 
            ListNode ptrPrev = null; 
            
            while (ptrCurr != curr && ptrCurr.val < curr.val) {
                ptrPrev = ptrCurr; 
                ptrCurr = ptrCurr.next; 
            }
            
            if (ptrCurr == curr) {
                prev = curr; 
                curr = curr.next; 
            } else {
                prev.next = curr.next; 
                curr.next = ptrCurr; 
                
                if (ptrPrev != null) {
                    ptrPrev.next = curr; 
                } else {
                    head = curr; 
                }
                
                curr = prev.next; 
            }
        }
        
        return head; 
    }
}
