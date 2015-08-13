/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Merge K sorted lists. 
 * Divide and conquer. Each time split the given list of lists into halves and recursively
 * merge each half. Then merge the returned results. 
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1); 
    }
    
    private ListNode helper(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            return lists[l];
        }
        
        int mid = (l + r) / 2; 
            ListNode list1 = helper(lists, l, mid); 
            ListNode list2 = helper(lists, mid + 1, r);
            ListNode head = null; 
            ListNode tail = null; 
 
            
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    if (tail == null) {
                        head = list1; 
                        tail = list1; 
                    } else {
                        tail.next = list1; 
                        tail = tail.next; 
                    }
                    
                    list1 = list1.next; 
                } else {
                    if (tail == null) {
                        head = list2; 
                        tail = list2; 
                    } else {
                        tail.next = list2; 
                        tail = tail.next; 
                    }
                    
                    list2 = list2.next; 
                }
            }
            
            if (list1 != null) {
                if (tail == null) {
                    head = list1;
                } else {
                    tail.next = list1; 
                }
            }
            
            if (list2 != null) {
                if (tail == null) {
                    head = list2; 
                } else {
                    tail.next = list2; 
                }
            }
            
            return head; 
    }
}
