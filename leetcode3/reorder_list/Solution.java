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
    private ListNode index; 
    private boolean stop; 
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; 
        }
        
        ListNode curr = head;
        Stack<ListNode> s = new Stack<ListNode>(); 
        
        while(curr.next != null) {
            s.push(curr); 
            curr = curr.next; 
        }
        
        ListNode prev = s.peek(); 
        ListNode index = head; 
        
        while (index != prev && index != curr) {
            prev.next = curr.next; 
            curr.next = index.next; 
            index.next = curr; 
            index = curr.next; 
            curr = s.pop(); 
            prev = s.peek(); 
        }
    }
}
