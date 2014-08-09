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
        ListNode result = null; 
        ListNode tail = null; 
        int carry = 0; 
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            
            if (tail == null) {
                result = new ListNode(digit);
                tail = result; 
            } else {
                tail.next = new ListNode(digit);
                tail = tail.next; 
            }
            
            l1 = l1.next; 
            l2 = l2.next; 
        }
        
        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + carry; 
                int digit = sum % 10; 
                carry = sum / 10; 
                
                if (tail == null) {
                    result = new ListNode(digit);
                    tail = result; 
                } else {
                    tail.next = new ListNode(digit);
                    tail = tail.next; 
                }
                
                l2 = l2.next; 
            }
        }
        
        if (l2 == null) {
            while (l1 != null) {
                int sum = l1.val + carry; 
                int digit = sum % 10; 
                carry = sum / 10; 
                
                if (tail == null) {
                    result = new ListNode(digit);
                    tail = result; 
                } else {
                    tail.next = new ListNode(digit);
                    tail = tail.next; 
                }
                
                l1 = l1.next; 
            }
        }
        
        if (carry != 0) {
            if (tail == null) {
                result = new ListNode(carry);
                tail = result; 
            } else {
                tail.next = new ListNode(carry);
                tail = tail.next; 
            }
        }
        
        return result; 
    }
}
