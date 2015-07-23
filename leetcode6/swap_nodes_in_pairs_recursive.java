/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Swap nodes in pairs recursive solution. 
 * Solve it recursively. The idea was to recursively swap the sublist
 * starting from the third node. Once the recursive call returns, swap 
 * the first two nodes and attach the result from recursive call. 
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode temp = swapPairs(head.next.next); 
        ListNode next = head.next; 
        next.next = head; 
        head.next = temp; 
        head = next; 
        
        return head; 
    }
}
