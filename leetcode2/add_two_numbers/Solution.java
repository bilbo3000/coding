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
    ListNode result = null; 
    ListNode tail = null;
        
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        while (l1 != null & l2 != null) {
            int sum = l1.val + l2.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            addNode(digit);
            l1 = l1.next; 
            l2 = l2.next; 
        }
        
        if (l2 != null) {
            while (l2 != null) {
                int sum = l2.val + carry; 
                int digit = sum % 10; 
                carry = sum / 10; 
                addNode(digit);
                l2 = l2.next; 
            }
        }
        
        if (l1 != null) {
            while (l1 != null) {
                int sum = l1.val + carry; 
                int digit = sum % 10; 
                carry = sum / 10; 
                addNode(digit);
                l1 = l1.next; 
            }
        }
        
        if (carry == 1) {
            addNode(1); 
        }
            
        return result; 
    }
    
    private void addNode(int digit) {
        ListNode newNode = new ListNode(digit); 
        
        if (tail == null) {
            result = newNode; 
            tail = newNode; 
        }
        else {
            tail.next = newNode; 
            tail = tail.next; 
        }
    }
}
