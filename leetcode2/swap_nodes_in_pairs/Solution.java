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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; 
        
        ListNode temp = head.next; 
        temp.next = swapPairs(temp.next); 
        
        head.next = temp.next; 
        temp.next = head; 
        head = temp; 
        
        return head; 
    }
}
