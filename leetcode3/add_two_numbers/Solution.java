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
    private ListNode result = null; 
    private ListNode tail = null;
        
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; 
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; 
            int digit = sum % 10; 
            addNode(digit); 
            carry = sum / 10; 
            l1 = l1.next; 
            l2 = l2.next; 
        }
        
        while (l1 != null) {
            int sum = l1.val + carry; 
            int digit = sum % 10; 
            addNode(digit); 
            carry = sum / 10; 
            l1 = l1.next; 
        }
        
        while (l2 != null) {
            int sum = l2.val + carry; 
            int digit = sum % 10; 
            addNode(digit); 
            carry = sum / 10; 
            l2 = l2.next; 
        }
        
        if (carry == 1) {
            addNode(1); 
        }
        
        return result; 
    }
    
    private void addNode(int val) {
        ListNode newNode = new ListNode(val); 
        if (tail == null) {
            result = newNode; 
            tail = newNode; 
        }
        else {
            tail.next = newNode; 
            tail = newNode; 
        }
    }
}
