/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     * 
     * 1. Split the list in halves 
     * 2. Reverse the second half
     * 3. Merge two lists. 
     */
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null) {
            return; 
        }
        
        // First split the list in halves 
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        // Reverse the second half
        ListNode curr = slow.next; 
        ListNode prev = null; 
        slow.next = null; 
        
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        
        // Merge two lists. 
        ListNode list2 = prev; 
        ListNode list1 = head; 
        
        while (list2 != null) {
            ListNode next2 = list2.next; 
            ListNode next1 = list1.next; 
            list1.next = list2; 
            list2.next = next1; 
            list1 = next1; 
            list2 = next2; 
        }
    }
}

