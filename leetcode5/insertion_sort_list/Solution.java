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
        if (head == null) {
            return head; 
        } 
        
        ListNode prev = head; 
        ListNode curr = head.next; 
        
        while (curr != null) {
            ListNode tempCurr = head; 
            ListNode tempPrev = null; 
            
            while (tempCurr != curr && tempCurr.val < curr.val) {
                tempPrev = tempCurr; 
                tempCurr = tempCurr.next; 
            }
            
            if (tempCurr == curr) {
                prev = curr; 
                curr = curr.next; 
            } else {  // Need to move
                if (tempCurr.next == curr) {
                    tempCurr.next = curr.next;
                    curr.next = tempCurr; 
                    
                    if (tempPrev == null) {
                        head = curr; 
                    } else {
                        tempPrev.next = curr; 
                    }
                    
                    curr = prev.next; 
                } else {
                    prev.next = curr.next; 
                    curr.next = tempCurr; 
                    
                    if (tempPrev == null) {
                        head = curr; 
                    } else {
                        tempPrev.next = curr; 
                    }
                    
                    curr = prev.next; 
                }
            }
        }
        
        return head; 
    }
}
