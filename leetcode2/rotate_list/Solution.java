public class Solution {
    private ListNode head = null; 
    private ListNode t = null; 
    private int cnt = 0; 
    private int n = 0; 
    private int len = 0; 
    
    public ListNode rotateRight(ListNode head, int n) {
    	if (head == null) return null; 
    	
        this.n = n; 
        this.head = head; 
        helper(null, head);
        
        return this.head; 
    }
    
    private void helper(ListNode prev, ListNode curr) {
        if (curr == null) {
            t = prev; 
            n = n % len; 
            return; 
        }
        
        len++; 
        helper(curr, curr.next); 
        cnt++; 
        
        if (cnt == n) {
            if (prev == null) {
                 return;
            }
            
            prev.next = null;
            
            if (t != null && t != head) {
                t.next = head; 
            }
            
            head = curr; 
        }
    }
}
