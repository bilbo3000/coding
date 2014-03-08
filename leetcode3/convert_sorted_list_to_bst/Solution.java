/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        ListNode prev = null; 
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                prev = slow; 
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        if (prev != null) {
            prev.next = null; 
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        if (slow == head) {
            root.left = null; 
        }
        else {
            root.left = sortedListToBST(head); 
        }
        
        root.right = sortedListToBST(slow.next); 
        
        return root; 
    }
}