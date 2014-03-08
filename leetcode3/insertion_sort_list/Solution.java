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
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode prev = head; 
        ListNode curr = head.next; 
        
        while (curr != null) {
            ListNode pt1 = null; 
            ListNode pt2 = head; 
            
            while (pt2.val < curr.val) {
                pt1 = pt2; 
                pt2 = pt2.next; 
            }
            
            if (pt2 == curr) {
                prev = curr; 
                curr = curr.next; 
            }
            else {
                prev.next = curr.next; 
                
                if (pt1 == null) {
                    head = curr; 
                    curr.next = pt2; 
                }
                else {
                    curr.next = pt2; 
                    pt1.next = curr; 
                }
                
                curr = prev.next; 
            }
        }
        
        return head; 
    }
}
