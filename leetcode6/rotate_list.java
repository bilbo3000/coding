/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Rotate a list to the right by k positions. 
 * First go through the list and count the length. Meanwhile, store the last node. 
 * Note that need to update k = k % length to avoid wrap around. No need to do anything 
 * if k is 0. Thus, there are length - k nodes at the beginning. Walk through the first 
 * length - k nodes and update pointers accordingly. Becareful of off by 1 error when 
 * walking the list. 
 * 
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null; 
        }
        
        int len = 0; 
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            prev = curr; 
            curr = curr.next; 
            len++; 
        }
        
        k = k % len; 
        
        if (k == 0) {
            return head; 
        }
        
        curr = head; 
        
        for (int i = 1; i < len - k; i++) {
            curr = curr.next; 
        }
        
        prev.next = head; 
        head = curr.next; 
        curr.next = null; 
        
        return head; 
    }
}
