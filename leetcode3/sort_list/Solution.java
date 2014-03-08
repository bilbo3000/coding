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
        ListNode temp1 = sortList(head);
        ListNode temp2 = sortList(temp); 
        
        head = null; 
        ListNode tail = null; 
        
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                    if (tail == null) {
                        head = temp1; 
                        tail = temp1; 
                    }
                    else {
                        tail.next = temp1; 
                        tail = tail.next; 
                    }
                temp1 = temp1.next; 
            }
            else {
                if (tail == null) {
                    head = temp2; 
                    tail = temp2; 
                }
                else {
                    tail.next = temp2; 
                    tail = tail.next; 
                } 
                temp2 = temp2.next; 
            }
        }
        
        if (temp1 != null) {
            if (tail == null) {
                head = temp1; 
                tail = temp1; 
            }
            else {
                tail.next = temp1; 
                tail = tail.next; 
            }
        }
        
        if (temp2 != null) {
            if (tail == null) {
                head = temp2; 
                tail = temp2; 
            }
            else {
                tail.next = temp2; 
                tail = tail.next; 
            }
        }
        
        return head; 
    }
}
