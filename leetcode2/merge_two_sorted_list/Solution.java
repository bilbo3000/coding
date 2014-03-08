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
    ListNode head = null; 
    ListNode tail = null; 
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                insert(l1); 
                l1 = l1.next; 
            }
            else {
                insert(l2); 
                l2 = l2.next; 
            }
        }
        
        if (l1 != null) {
            insert(l1); 
        }
        
        if (l2 != null) {
            insert(l2); 
        }
        
        return head; 
    }
    
    private void insert(ListNode node) {
        if (tail == null) {
            tail = node; 
            head = node; 
            node = node.next; 
        }
        else {
            tail.next = node; 
            node = node.next; 
            tail = tail.next; 
        }
    }
}
