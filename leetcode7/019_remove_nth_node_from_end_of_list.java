/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 Delete the nth node from the end in one path. 
 
 The tricky part is to delete the node in one path 
 --> the list length is unknown. 
 
 Having two pointers where there are n nodes between them; 
 Advance two pointers in tandem. When first node points to null; 
 the second pointer must point to the (n + 1)th node from the end
 
 Time: O(n); 
 Space: O(1);
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
        ListNode first = head; 
        
        while (n > 0) {
            first = first.next;
            n--; 
        }
        
        ListNode second = dummy; 
        
        while (first != null) {
            first = first.next; 
            second = second.next; 
        }
        
        // second should point to the last (n + 1)th node. 
        // There are n nodes between second and first (last null). 
        second.next = second.next.next; 
        
        return dummy.next; 
    }
}
