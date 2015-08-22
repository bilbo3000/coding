/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Partition the list such that nodes with value less than the given value are before the 
 * nodes with greater or equal nodes. 
 * Borrow the idea from quick sort partition step. Use a pointer to point to the last node that 
 * is less than the given value. For current node, if it is >= val, move forward; otherwise, need 
 * to decide where to move it. DO NOT forget to update the pointer to the last node with smaller 
 * value than given node. 
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode last = null; 
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.val < x) {
                // Move 
                if (prev == last) {
                    last = curr; 
                    prev = curr; 
                    curr = curr.next; 
                } else {
                    if (last == null) {
                        prev.next = curr.next; 
                        curr.next = head; 
                        head = curr; 
                        last = curr; 
                        curr = prev.next; 
                    } else {
                        prev.next = curr.next; 
                        curr.next = last.next; 
                        last.next = curr;
                        curr = prev.next; 
                        last = last.next; 
                    }
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head;
    }
}
