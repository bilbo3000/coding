/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Merge two sorted linked list. 
 * Two pointers iterating through two lists, and add the node with smaller value. 
 * Make sure the discuss the case whether the result list is empty or not. After 
 * exhaust either list, need to check whether the other list is empty or not. Append 
 * the other list to the end of result list if not empty. 
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null; 
        ListNode tail = null; 
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (tail == null) {
                    head = l1; 
                    tail = l1; 
                    l1 = l1.next; 
                    tail.next = null; 
                } else {
                    tail.next = l1;
                    l1 = l1.next; 
                    tail = tail.next; 
                    tail.next = null; 
                }
            } else {
                if (tail == null) {
                    head = l2; 
                    tail = l2; 
                    l2 = l2.next; 
                    tail.next = null; 
                } else {
                    tail.next = l2; 
                    l2 = l2.next; 
                    tail = tail.next; 
                    tail.next = null; 
                }
            }
        }
        
        if (l1 != null) {
            if (tail == null) {
                head = l1; 
            } else {
                tail.next = l1; 
            }
        } else if (l2 != null){
            if (tail == null) {
                head = l2; 
            } else {
                tail.next = l2; 
            }
        }
        
        return head; 
    }
}
