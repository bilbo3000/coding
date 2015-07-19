/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Reverse the linked list recursively. 
 * The idea was to reverse the last n - 1 nodes recursively at each level. 
 * Then append the current head at the end of the return value from recursive
 * call. Then return the new head as the result of this level of recursion. 
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode temp = reverseList(head.next); 
        ListNode tail = temp; 
        
        while (tail.next != null) {
            tail = tail.next; 
        }
        
        head.next = null; 
        tail.next = head; 
        
        return temp; 
    }
}
