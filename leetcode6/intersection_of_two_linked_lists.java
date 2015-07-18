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
 * 
 * Get the intersection node of two linked list. 
 * The brute force approach. Use a set to store all the nodes while traversing list A. 
 * Then traverse list B, until it finds a node that also in the set. Otherwise, return 
 * null. 
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>(); 
        ListNode curr = headA; 
        
        while (curr != null) {
            s.add(curr);
            curr = curr.next; 
        }
        
        curr = headB; 
        
        while (curr != null) {
            if (s.contains(curr)) {
                return curr; 
            }
            
            curr = curr.next; 
        }
        
        return null; 
    }
}
