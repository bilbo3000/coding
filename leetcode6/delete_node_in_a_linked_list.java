/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Remove the given node from a linked list. Only given that node. 
 * The idea was to walk through the list with two pointers and copy the next node value 
 * to the current position. Then delete the last node by setting the next of the first 
 * pointer to null. 
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; 
        }
        
        ListNode prev = null; 
        
        while (node.next != null) {
            node.val = node.next.val; 
            prev = node; 
            node = node.next; 
        }
        
        if (prev != null) {
            prev.next = null; 
        }
        
        return; 
    }
}
