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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        ListNode prev = null; 
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                // Duplicates 
                curr = curr.next; 
                
                if (prev != null) {
                    prev.next = curr; 
                } else {
                    head = curr; 
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }  
}
