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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode node = head.next; 
        ListNode parent = head; 
        
        while (node != null) {
            ListNode curr = head; 
            ListNode prev = null; 
            
            while (curr != node && curr.val < node.val) {
                prev = curr; 
                curr = curr.next; 
            }
            
            if (curr != node) {
                parent.next = node.next; 
                
                if (prev == null) {
                    node.next = head; 
                    head = node; 
                }
                else {
                    node.next = prev.next; 
                    prev.next = node; 
                }
                
                node = parent.next; 
            }
            else {
                parent = node; 
                node = node.next; 
            }
        }
        
        return head; 
    }
}
