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
     * @return: The head of linked list.
     * 
     * O(n^2)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode prev = head; 
        ListNode curr = head.next; 
        
        while (curr != null) {
            ListNode p1 = null; 
            ListNode p2 = head; 
            
            while (p2 != curr && p2.val <= curr.val) {
                p1 = p2; 
                p2 = p2.next; 
            }
            
            if (p2 != curr) {
                // Need to insert
                if (p1 == null) {
                    head = curr; 
                } else {
                    p1.next = curr; 
                }
                
                prev.next = curr.next; 
                curr.next = p2; 
                curr = prev.next; 
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
