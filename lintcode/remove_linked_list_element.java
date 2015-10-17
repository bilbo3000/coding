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
     * @param val an integer
     * @return a ListNode
     * 
     * O(n)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    head = curr.next; 
                    curr = head; 
                } else {
                    prev.next = curr.next; 
                    curr = prev.next; 
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}
