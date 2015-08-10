/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Reverse a linked list from the mth node to nth node. 
 * The idea was to traverse the linked list with prev and curr pointers 
 * to find the mth node, where curr will point to the mth node, prev could 
 * be null. Then start from there, use a separate pair of pointers to 
 * traverse and reverse node till the nth node, where prev2 would point 
 * to the nth node and curr2 will be after it. Then arrange the heads. 
 * The lessons learned was that traverse the list with two pointers. 
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null; 
        }
        
        ListNode prev = null; 
        ListNode curr = head; 
        int count = 1; 
        
        while (curr != null && count < m) {
            prev = curr; 
            curr = curr.next; 
            count++; 
        }
        
        ListNode prev2 = null; 
        ListNode curr2 = curr; 
        
        while (curr2 != null && count <= n) {
            ListNode next = curr2.next; 
            curr2.next = prev2; 
            prev2 = curr2; 
            curr2 = next; 
            count++; 
        }
        
        if (prev == null) {
            curr.next = curr2; 
            return prev2; 
        } else {
            prev.next = prev2; 
            curr.next = curr2; 
            return head; 
        }
    }
}
