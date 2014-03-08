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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head; 
        int cnt = 0; 
        
        while (ptr != null) {
            cnt++; 
            
            if (cnt == k) break; 
            
            ptr = ptr.next; 
        }
        
        if (ptr == null) return head; 
        
        ListNode temp = reverseKGroup(ptr.next, k); 
        
        ListNode prev = temp; 
        ListNode curr = head; 
        
        while (prev != ptr) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        return ptr; 
    }
}
