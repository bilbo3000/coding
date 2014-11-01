/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        ListNode temp = slow.next; 
        slow.next = null; 
        
        ListNode left = sortList(head); 
        ListNode right = sortList(temp); 
        
        ListNode result = null; 
        ListNode tail = null; 
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (tail == null) {
                    result = left; 
                    tail = left; 
                    left = left.next; 
                } else {
                    tail.next = left; 
                    tail = tail.next; 
                    left = left.next; 
                }
            } else {
                if (tail == null) {
                    result = right; 
                    tail = right; 
                    right = right.next; 
                } else {
                    tail.next = right; 
                    tail = tail.next; 
                    right = right.next; 
                }
            }
        }
        
        if (left != null) {
            if (tail == null) {
                result = left; 
                tail = left; 
                left = left.next; 
            } else {
                tail.next = left; 
                tail = tail.next; 
                left = left.next; 
            }
        }
        
        if (right != null) {
            if (tail == null) {
                result = right; 
                tail = right; 
                right = right.next; 
            } else {
                tail.next = right; 
                tail = tail.next; 
                right = right.next; 
            }
        }
        
        return result; 
    }
}
