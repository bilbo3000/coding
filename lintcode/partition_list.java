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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     * 
     * Maintain a pointer that points to the last node that is less than target. 
     * Update tail accordingly while traversing through the list. 
     * 
     * O(n). 
     */
    public ListNode partition(ListNode head, int x) {
        ListNode tail = null; 
        ListNode curr = head; 
        ListNode prev = null; 
        
        while (curr != null) {
            if (curr.val < x) {
                // Need to swap 
                if (tail == prev) {
                    tail = curr; 
                    prev = curr; 
                    curr = curr.next; 
                } else {
                    ListNode next = curr.next; 
                    prev.next = next; 
                    
                    if (tail == null) {
                        curr.next = head; 
                        head = curr; 
                        tail = head; 
                    } else {
                        curr.next = tail.next; 
                        tail.next = curr; 
                        tail = curr; 
                    }
                    
                    curr = prev.next; 
                }
            } else {
                prev = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}

