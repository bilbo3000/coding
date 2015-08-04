/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Merge sort linked list. 
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (slow != null && fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        ListNode next = slow.next; 
        slow.next = null; 
        ListNode a = sortList(head);
        ListNode b = sortList(next);
        ListNode result = null; 
        ListNode tail = null; 
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                if (tail == null) {
                    result = a; 
                    tail = a; 
                    a = a.next; 
                } else {
                    tail.next = a; 
                    tail = a; 
                    a = a.next; 
                }
            } else {
                if (tail == null) {
                    result = b; 
                    tail = b; 
                    b = b.next; 
                } else {
                    tail.next = b;
                    tail = b; 
                    b = b.next; 
                }
            }
        }
        
        if (a != null) {
            if (tail == null) {
                result = a; 
            } else {
                tail.next = a; 
            }
        }
        
        if (b != null) {
            if (tail == null) {
                result = b; 
            } else {
                tail.next = b; 
            }
        }
        
        return result; 
    }
}
