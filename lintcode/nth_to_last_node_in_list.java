/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     * 
     * Reverse linked list and count first n nodes. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        
        // First reverse the list 
        ListNode prev = null; 
        ListNode curr = head; 

        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        ListNode result = prev; 
        
        while (n > 1) {
            result = result.next; 
            n--; 
        }
        
        return result; 
    }
}

