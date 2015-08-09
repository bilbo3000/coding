/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Reverse the linked list in k groups. 
 * Solve it recursively. For given head, count k nodes, then recursively process 
 * the list starting from k + 1 node. Then reverse the first k nodes. Attach 
 * the result returned from the recursive call the the reversed list. Then return 
 * new head. 
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null; 
        }
        
        ListNode curr = head; 
        int count = 0; 
        
        while (count < k && curr != null) {
            curr = curr.next; 
            count++; 
        }
        
        if (count < k) {
            return head; 
        }
        
        ListNode temp = reverseKGroup(curr, k);
        ListNode prev = null; 
        curr = head; 
        
        while (k > 0) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next;
            k--; 
        }
        
        head.next = temp; 
        
        return prev; 
    }
}
