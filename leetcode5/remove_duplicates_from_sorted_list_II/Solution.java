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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head; 
        }
        
        ListNode prev = null; 
        ListNode curr = head;  
        boolean delete = false; 
        
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                delete = true; 
                curr.next = curr.next.next; 
            } else {
                if (delete) {
                    if (prev == null) {
                        head = curr.next;  
                        curr = head; 
                    } else {
                        prev.next = curr.next; 
                        curr = prev.next; 
                    }
                    
                    delete = false; 
                } else {
                    prev = curr; 
                    curr = curr.next; 
                }
            }
        }
        
        return head; 
    }
}
