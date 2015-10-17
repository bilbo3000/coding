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
 * 
 * Merge sort a list. 
 * 
 * O(nlogn)
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        ListNode temp = slow.next; 
        slow.next = null; 
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(temp);
        
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode head = null; 
        ListNode tail = null; 
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                if (tail == null) {
                    head = h1; 
                    tail = h1; 
                } else {
                    tail.next = h1; 
                    tail = tail.next; 
                }
                
                h1 = h1.next; 
            } else {
                if (tail == null) {
                    head = h2; 
                    tail = h2; 
                } else {
                    tail.next = h2; 
                    tail = tail.next; 
                }
                
                h2 = h2.next; 
            }
        }
        
        if (h1 != null) {
            if (tail == null) {
                head = h1; 
                tail = h1; 
            } else {
                tail.next = h1; 
                tail = tail.next; 
            }
        }
        
        if (h2 != null) {
            if (tail == null) {
                head = h2; 
                tail = h2; 
            } else {
                tail.next = h2; 
                tail = tail.next; 
            }
        }
        
        return head; 
    }
}

