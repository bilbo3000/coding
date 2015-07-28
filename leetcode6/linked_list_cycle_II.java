/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Find the node where cycle starts. Returns null if cycle does not exist. 
 * The idea was to use slow and fast pointers to traverse the linked list 
 * where the fast pointer is twice as fast as the slow pointer and they 
 * both start from the first node. 
 * The ideas was based on the following equation: 
 * 2*(x + k1m + y) = x + k2m + y, where 
 * x: from the beginning to the merge node; 
 * m: the length of the cycle; 
 * y: the partial length from where the cycle begins to the point where they meet; 
 * k1, k2: the number of full cycles slow and fast pointers traverse respectively; 
 * Thus, we have x + y = (k2 - 2k1)m, where the remaining length in the last partial 
 * cycle is equal to the length from the beginning to the starting point of the cycle. 
 * Then we can find the start of the cycle. 
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        ListNode slow = head; 
        ListNode fast = head; 
        
        do {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        } while (fast != null && slow != fast); 
        
        if (fast == null) {
            return null; 
        }
        
        slow = head; 
        
        while (slow != fast) {
            slow = slow.next; 
            fast = fast.next; 
        }
        
        return slow; 
    }
}
