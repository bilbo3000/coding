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
        if (head == null || head.next == null) return head; 
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                fast = fast.next; 
                slow = slow.next; 
            }
        }
        
        ListNode head2 = slow.next; 
        slow.next = null; 
        ListNode head1 = head; 
        head = null; 
        ListNode tail = null; 
        head1 = sortList(head1);
        head2 = sortList(head2); 
        
        // Merge
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (head == null) {
                    head = head1; 
                    tail = head1; 
                    head1 = head1.next; 
                    tail.next = null; 
                }
                else {
                    tail.next = head1;
                    tail = tail.next; 
                    head1 = head1.next; 
                    tail.next = null; 
                }
            }
            else {
                if (head == null) {
                    head = head2; 
                    tail = head2; 
                    head2 = head2.next; 
                    tail.next = null; 
                }
                else {
                    tail.next = head2; 
                    tail = tail.next; 
                    head2 = head2.next; 
                    tail.next = null; 
                }
            }
        }
        
        if (head1 == null) {
            if (head == null) {
                head = head2; 
            }
            else {
                tail.next = head2; 
            }
        }
        else {
            if (head == null) {
                head = head1; 
            }
            else {
                tail.next = head1; 
            }
        }
        
        return head; 
    }
}
