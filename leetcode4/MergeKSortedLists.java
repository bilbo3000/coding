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
    public ListNode mergeKLists(List<ListNode> lists) {
        return helper(lists, 0, lists.size() - 1); 
    }
    
    private ListNode helper(List<ListNode> lists, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            return lists.get(l); 
        }
        
        int mid = (l + r) / 2; 
        ListNode left = helper(lists, l, mid); 
        ListNode right = helper(lists, mid + 1, r); 
        ListNode head = null; 
        ListNode tail = null; 
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (tail == null) {
                    head = left; 
                    tail = left; 
                } else {
                    tail.next = left; 
                    tail = tail.next; 
                }
                
                left = left.next; 
            } else {
                if (tail == null) {
                    head = right; 
                    tail = right; 
                } else {
                    tail.next = right; 
                    tail = tail.next; 
                }
                
                right = right.next; 
            }
        }
        
        if (left != null) {
            if (tail == null) {
                head = left; 
            } else {
                tail.next = left; 
            }
        }
        
        if (right != null) {
            if (tail == null) {
                head = right; 
            } else {
                tail.next = right; 
            }
        }
        
        return head; 
    }
}
