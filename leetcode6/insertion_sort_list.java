/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Insertion sort linked list. 
 * Traverse each node with two pointers starting from the second node. For each 
 * node, traverse from the beginning with two pointers to find the first node 
 * which value is no less than the current value. Then move the current node 
 * before that node. Make sure to discuss different cases such as moving to 
 * the start and moving to the middle. 
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        ListNode curr = head.next; 
        ListNode prev = head; 

        while (curr != null) {
            ListNode p1 = null; 
            ListNode p2 = head; 
            
            while (p2 != curr && p2.val < curr.val) {
                p1 = p2; 
                p2 = p2.next; 
            }
            
            if (p2 == curr) {
                prev = curr; 
                curr = curr.next; 
            } else {
                prev.next = curr.next; 
                curr.next = p2; 
                
                if (p1 == null) {
                    head = curr; 
                } else {
                    p1.next = curr; 
                }
                
                curr = prev.next; 
            }
        }
        
        return head;
    }
}
