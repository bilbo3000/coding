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
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     * 
     * Count number of nodes in two list. Then find out the diff d. 
     * Move head d nodes on longer list. Then start moving forward on both 
     * lists. The node they meet would be the intersection. 
     * 
     * O(n) time; O(1) space. 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0; 
        int countB = 0; 
        
        ListNode currA = headA; 
        ListNode currB = headB; 
        
        while (currA != null) {
            countA++; 
            currA = currA.next; 
        }
        
        while (currB != null) {
            countB++; 
            currB = currB.next; 
        }
        
        int diff = Math.abs(countA - countB);
        
        if (countA > countB) {
            // List A is longer 
            while (diff > 0) {
                headA = headA.next; 
                diff--; 
            }
        } else {
            while (diff > 0) {
                headB = headB.next; 
                diff--; 
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; 
            }
            
            headA = headA.next; 
            headB = headB.next; 
        }
        
        return null; 
    }  
}
