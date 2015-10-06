/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     * 
     * Reverse linked list in place in O(n). 
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) {
            return null; 
        }
        
        ListNode p1 = null; 
        ListNode c1 = head; 
        int count = 1; 
        
        while (count != m) {
            p1 = c1; 
            c1 = c1.next; 
            count++; 
        }
        
        ListNode p2 = null; 
        ListNode c2 = c1; 
        
        while (count != n + 1) {
            ListNode next = c2.next; 
            c2.next = p2; 
            p2 = c2; 
            c2 = next; 
            count++; 
        }
        
        if (p1 == null) {
            head = p2; 
        } else {
            p1.next = p2; 
        }
        
        c1.next = c2; 
        
        return head; 
    }
}
