/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Delete all duplicates nodes in the linked list. 
 * The idea was for each node, try to delete all the nodes after it that have 
 * the same value as the node if possible and use a boolean flag to indicate 
 * whether we need to delete current node. 
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head; 
        boolean flag = false; 
        
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next; 
                flag = true; 
            } 
            
            if (flag) {
                flag = false; 
                
                // Delete current node 
                if (prev == null) {
                    head = curr.next; 
                    curr = curr.next; 
                } else {
                    prev.next = curr.next; 
                    curr = curr.next; 
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
