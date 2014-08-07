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
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        ListNode prev = null; 
        
        while (fast != null) {
            fast = fast.next; 
            if (fast != null) {
                prev = slow; 
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        TreeNode treeNode = new TreeNode(slow.val);
        
        if (prev == null) {
            treeNode.left = sortedListToBST(null); 
        } else {
            prev.next = null; 
            treeNode.left = sortedListToBST(head); 
        }
        
        treeNode.right = sortedListToBST(slow.next);
        
        return treeNode; 
    }
}
