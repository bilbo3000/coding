/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     * 
     * O(n).
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next; 
                }
                
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

