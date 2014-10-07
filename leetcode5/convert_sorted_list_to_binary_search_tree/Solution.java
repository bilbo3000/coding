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
        
        if (head.next == null) {
            return new TreeNode(head.val); 
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
        
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next); 
        
        if (prev != null) {
            prev.next = null; 
            root.left = sortedListToBST(head); 
        }
        
        return root; 
    }
}
