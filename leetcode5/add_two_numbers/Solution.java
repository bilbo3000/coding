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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; 
        ListNode head = null; 
        ListNode tail = null; 
        
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val; 
            int digit = sum % 10; 
            carry = sum / 10; 
            
            ListNode node = new ListNode(digit);
            
            if (tail == null) {
                tail = node; 
                head = node; 
            } else {
                tail.next = node; 
                tail = tail.next; 
            }
            
            l1 = l1.next; 
            l2 = l2.next; 
        }
        
        while (l1 != null) {
            int sum = l1.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10;
            
            ListNode node = new ListNode(digit);
            
            if (tail == null) {
                tail = node; 
                head = node; 
            } else {
                tail.next = node; 
                tail = tail.next; 
            }
            
            l1 = l1.next; 
        }
        
        while (l2 != null) {
            int sum = l2.val + carry; 
            int digit = sum % 10;
            carry = sum / 10; 
            
            ListNode node = new ListNode(digit); 
            
            if (tail == null) {
                tail = node; 
                head = node; 
            } else {
                tail.next = node; 
                tail = tail.next; 
            }
            
            l2 = l2.next; 
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            
            if (tail == null) {
                tail = node; 
                head = node; 
            } else {
                tail.next = node; 
                tail = tail.next; 
            }
        }
        
        return head; 
    }
}
