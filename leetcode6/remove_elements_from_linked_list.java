/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Remove all nodes which value equals to the given value from 
 * a linked list. 
 * Traverse through the list with two pointers and remove node 
 * from linked list accordingly. 
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null; 
        ListNode curr = head; 

        while (curr != null) {
            if (curr.val != val) {
                prev = curr; 
                curr = curr.next; 
            } else {
                if (curr == head) {
                    head = head.next; 
                    curr = curr.next; 
                } else {
                    prev.next = curr.next; 
                    curr = prev.next; 
                }
            }
        }
        
        return head; 
    }
}
