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
        ListNode prev = null; 
        ListNode curr = head; 
        ListNode last = null; 
        
        while (curr != null) {
            if (curr.val < x) {  // Move 
                if (prev == last) {
                   last = curr; 
                   prev = curr; 
                   curr = curr.next; 
                }
                else {
                    prev.next = curr.next; 
                    
                    if (last == null) {
                        curr.next = head; 
                        head = curr; 
                        last = head; 
                    }
                    else {
                        curr.next = last.next; 
                        last.next = curr; 
                        last = last.next; 
                    }
                    
                    curr = prev.next; 
                }
            }
            else {  // No move 
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
