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
    private ListNode head = null; 
    private ListNode tail = null; 
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                addNode(l1);
                l1 = l1.next; 
            }
            else {
                addNode(l2); 
                l2 = l2.next; 
            }
        }
        
        if (l1 != null) {
            addNode(l1); 
        }
        
        if (l2 != null) {
            addNode(l2); 
        }
        
        return head; 
    }
    
    private void addNode(ListNode node) {
        if (tail == null) {
            head = node; 
            tail = node; 
        }
        else {
            tail.next = node; 
            tail = tail.next; 
        }
    }
}
