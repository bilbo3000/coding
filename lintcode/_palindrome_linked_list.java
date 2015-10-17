/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     * 
     * Slow and fast pointer traverse the list. Then split the list in halves. 
     * Reverse the second half. Then traverse both list and compare each node. 
     * If nodes are all the same, then must be palindrome. (Note that there 
     * could be one extra node at the end of first list if total length is 
     * odd).
     * 
     * O(n) time and O(1) space. 
     */
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        ListNode temp = slow.next; 
        slow.next = null; 
        
        // Reverse second half 
        ListNode prev = null; 
        
        while (temp != null) {
            ListNode next = temp.next; 
            temp.next = prev; 
            prev = temp; 
            temp = next; 
        } 
        
        while (head != null && prev != null) {
            if (head.val != prev.val) {
                return false; 
            }
            
            head = head.next; 
            prev = prev.next; 
        }
        
        return true; 
    }
}
