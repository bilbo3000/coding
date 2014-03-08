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
        ListNode index = null; 
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            if (curr.val < x) {  // Swap 
                if (index == prev) {
                    index = curr; 
                    prev = curr; 
                    curr = curr.next; 
                }
                else {
                    prev.next = curr.next; 
                    
                    if (index == null) {
                        curr.next = head; 
                        head = curr; 
                        index = curr; 
                    }
                    else {
                        curr.next = index.next; 
                        index.next = curr; 
                        index = curr; 
                    }
                    
                    curr = prev.next; 
                }
            }
            else {  // Move on
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
