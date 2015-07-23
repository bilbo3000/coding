/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Swap nodes in pairs iterative approach. 
 * Traverse through the list via two pointers. Prev and curr. 
 * Swap curr and the next node. Update prev/head accordingly. 
 * Until it reaches the last node or null, then stop traversal. 
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next.next; 
            ListNode next = curr.next; 
            next.next = curr; 
            curr.next = temp; 
            
            if (prev != null) {
                prev.next = next; 
            }
            
            if (curr == head) {
                head = next; 
            }
            
            prev = curr; 
            curr = temp; 
        }
        
        return head; 
    }
}
