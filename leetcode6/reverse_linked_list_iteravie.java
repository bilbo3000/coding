/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Reverse a linked list iteratively. 
 * The idea was to maintain three pointers prev, curr, and next. Then 
 * basically rotate the pointer curr->next to curr->prev. Then advance
 * prev, and curr, until curr becomes null. 
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head; 
        ListNode next = null; 
        
        while (curr != null) {
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        return prev; 
    }
}
