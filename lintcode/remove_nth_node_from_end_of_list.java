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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        head = prev; 
        curr = prev; 
        prev = null; 
        
        while (n > 1) {
            prev = curr; 
            curr = curr.next; 
            n--; 
        }
        
        if (prev == null) {
            head = head.next;  
        } else {
            prev.next = curr.next; 
        }
        
        prev = null; 
        curr = head; 
        
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        return prev; 
    }
}

