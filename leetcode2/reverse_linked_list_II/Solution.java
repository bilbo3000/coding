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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head; 
        int cnt = 1; 
        ListNode curr = head;
        ListNode prev = null; 
        
        while (cnt < m) {
            cnt++; 
            prev = curr; 
            curr = curr.next; 
        }
        
        ListNode left1 = prev; 
        ListNode left2 = curr; 
        prev = null; 
        
        while (cnt <= n) {
            cnt++; 
            ListNode temp = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = temp; 
        }
        
        if (left1 == null) {
            head = prev; 
        }
        else {
            left1.next = prev; 
        }
        
        left2.next = curr; 
        
        return head;
    }
}
