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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        ListNode prev = null; 
        ListNode curr = head; 
        boolean deleting = false; 
        
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {  // Have somthing to delete after curr node
                deleting = true;  // In deleting mode 
                curr.next = curr.next.next; 
            } else {
                if (deleting) {  // delete myself 
                    deleting = false; 
                    if (prev != null) {
                        prev.next = curr.next; 
                        curr = prev.next; 
                    } else {
                        head = curr.next; 
                        curr = head; 
                    }
                } else {
                    prev = curr; 
                    curr = curr.next; 
                }
            }
        }
        
        return head; 
    }
}
