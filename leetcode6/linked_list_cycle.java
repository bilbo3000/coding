/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Determine if a linked list has a cycle. 
 * 
 * In order to not use extra space, the idea was to use two pointers. 
 * The fast pointer and slow pointer, where the fast pointer moves twice 
 * as fast as the slow pointer. Note that slow pointer starts at the first 
 * node while the fast pointer starts at the second node (if exists). 
 * If the fast pointer ever catches up the slow pointer, there must be a 
 * circle in the list. On the other hand, if the fast pointer reaches the 
 * end of list, there must not be a circle in the list.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false; 
        }
        
        ListNode curr = head; 
        ListNode next = head.next; 
        
        while (curr != next && next != null) {
            curr = curr.next; 
            next = next.next; 
            
            if (next != null) {
               next = next.next;  
            }
        }
        
        if (curr == next) {
            return true; 
        }
        
        return false; 
    }
}
