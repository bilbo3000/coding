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
    public ListNode partition(ListNode head, int x) {
        ListNode firstLargePrev = null; 
        ListNode firstLarge = null; 
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.val >= x) {
                if (firstLarge == null) {
                    firstLargePrev = prev; 
                    firstLarge = curr; 
                }
                
                prev = curr; 
                curr = curr.next; 
            } else {
                if (firstLarge != null) {
                    if (firstLargePrev == null) {
                        prev.next = curr.next; 
                        curr.next = firstLarge; 
                        head = curr; 
                        firstLargePrev = curr; 
                        curr = prev.next; 
                    } else {
                        prev.next = curr.next; 
                        curr.next = firstLarge; 
                        firstLargePrev.next = curr; 
                        firstLargePrev = curr; 
                        curr = prev.next; 
                    }
                } else {
                    prev = curr; 
                    curr = curr.next; 
                }
            }
        }
        
        return head; 
    }
}
