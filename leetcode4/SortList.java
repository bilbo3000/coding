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
        if (head == null) {
            return null; 
        }
        
        if (head.next == null) {
            return head; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next ;
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        ListNode left = head; 
        ListNode right = slow.next; 
        slow.next = null; 
        
        left = sortList(left);
        right = sortList(right); 
        
        ListNode h = null; 
        ListNode t = null; 
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (t != null) {
                    t.next = left; 
                    t = t.next; 
                    left = left.next; 
                } else {
                    h = left; 
                    t = left; 
                    left = left.next; 
                }
            } else {
                if (t != null) {
                    t.next = right; 
                    t = t.next; 
                    right = right.next; 
                } else {
                    h = right; 
                    t = right; 
                    right = right.next; 
                }
            }
        }
        
        if (left != null) {
            if (t != null) {
                t.next = left; 
            } else {
                h = left; 
                t = left; 
            }
        }
        
        if (right != null) {
            if (t != null) {
                t.next = right; 
            } else {
                h = right; 
                t = right; 
            }
        }
        
        return h; 
    }
}
