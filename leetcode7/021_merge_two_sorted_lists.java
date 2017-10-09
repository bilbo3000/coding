/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 Merge two sorted linked list. 
 
 Walk through two lists and append the smaller node each comparison. 
 If any list becomes empty, append the rest of the other list to the end 
 of the result. 
 
 Using a dummy head would help avoid bunch of null checking. 
 
 Time: O(n), where n is the total number of nodes; 
 Space: O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode tail = dummy; 
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1; 
                l1 = l1.next; 
            } else {
                tail.next = l2; 
                l2 = l2.next; 
            }
            
            tail = tail.next; 
        }
        
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1; 
        }
        
        return dummy.next; 
    }
}
