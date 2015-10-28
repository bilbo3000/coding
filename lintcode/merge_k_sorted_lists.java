/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     * 
     * O(logk * n) k is the number of lists and n is the total elements. 
     */
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
        
        if (list2 != null) {
            if (tail == null) {
                head = list2;
            } else {
                tail.next = list2; 
            }
        }
        
        if (list1 != null) {
            if (tail == null) {
                head = list1; 
            } else {
                tail.next = list1; 
            }
        }
        
        return head; 
    }
}

