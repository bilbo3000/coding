/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Add two numbers represented in linked list in reverse order. 
 * The idea was to maintain carry while loop through the lists. Each 
 * time calculate sum, digit, update carry. Before attach new node, 
 * make sure to check whehter tail is null. Note that the number could 
 * have different length. Thus need to walk through whatever list is 
 * remaining. Also, at the very end, the carry could be non-zero, which 
 * requires adding additional node if carry is not null. 
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null; 
        ListNode tail = null; 
        int carry = 0; 
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            
            ListNode node = new ListNode(digit);
            
            if (tail == null) {
                head = node; 
                tail = node; 
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
                head = node;
                tail = node;
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
                head = node;
                tail = node; 
            } else {
                tail.next = node;
                tail = tail.next; 
            }
            
            l2 = l2.next; 
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            
            if (tail == null) {
                head = node; 
                tail = node; 
            } else {
                tail.next = node; 
                tail = tail.next; 
            }
        }
        
        return head;
    }
}
