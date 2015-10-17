/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode temp = swapPairs(head.next.next);
        ListNode next = head.next; 
        head.next = temp; 
        next.next = head; 
        
        return next; 
    }
}
