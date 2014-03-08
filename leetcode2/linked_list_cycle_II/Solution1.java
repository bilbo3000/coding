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
 */
public class Solution {
    Set<ListNode> s = new HashSet<ListNode>(); 
    
    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            if (s.contains(head)) break; 
            s.add(head); 
            head = head.next; 
        }
        
        return head; 
    }
}
