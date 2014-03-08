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
public class Solution2 {
    private int cnt = 0; 
    private ListNode head; 
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null; 
        }
        
        ListNode curr = head; 
        Stack<ListNode> s = new Stack<ListNode>(); 
        
        while (curr.next != null) {
            s.push(curr); 
            curr = curr.next; 
        }
        
        ListNode prev = null; 
        int cnt = 1; 
        
        if (s.size() != 0) {
            prev = s.peek(); 
        }
        
        while (cnt < n) {
            curr = s.pop(); 
            
            if (s.size() != 0) {
                prev = s.peek(); 
            }
            else {
                prev = null; 
            }
            
            cnt++; 
        }
        
        if (prev != null) {
            prev.next = curr.next; 
        }
        else {
            head = curr.next; 
        }
        
        return head; 
    }
}
