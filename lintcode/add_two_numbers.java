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
 * 
 * O(max length of the two number)
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0; 
        ListNode result = null; 
        ListNode tail = null; 
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            
            ListNode node = new ListNode(digit);
            
            if (tail == null) {
                result = node; 
                tail = node; 
            } else {
                tail.next = node; 
                tail = node; 
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
                result = node; 
                tail = node; 
            } else {
                tail.next = node; 
                tail = node; 
            }
            
            l1 = l1.next; 
        }
        
        while (l2 != null) {
            int sum = l2.val + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            
            ListNode node = new ListNode(digit);
            
            if (tail == null) {
                result = node; 
                tail = node; 
            } else {
                tail.next = node; 
                tail = node; 
            }
            
            l2 = l2.next; 
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            
            if (tail == null) {
                result = node; 
                tail = node; 
            } else {
                tail.next = node; 
                tail = node; 
            }
        }
        
        return result; 
    }
}
