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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return head; 
        }
        
        ListNode curr = head; 
        Stack<ListNode> s = new Stack<ListNode>(); 
        
        while (curr != null) {
            s.push(curr);
            curr = curr.next; 
        }
        
        n = n % s.size();
        ListNode front = null;
        ListNode tail = null; 
        
        while (n > 0) {
            ListNode top = s.pop(); 
            
            if (s.size() > 0) {
                s.peek().next = null; 
            }
            
            if (tail == null) {
                front = top; 
                tail = top; 
            }
            else {
                top.next = front;  
                front = top;  
            }
            
            n--;
        }
        
        if (tail == null) {
            return head; 
        }
        
        tail.next = head; 
        
        return front; 
    }
}
