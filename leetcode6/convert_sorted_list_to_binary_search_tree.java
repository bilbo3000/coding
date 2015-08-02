/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Convert a sorted linked list to a BST. 
 * Solve it recursively. Use fast and slow pointer approach to split the list in half 
 * each time. Use the middle element as the tree root (the one pointed by slow). Then 
 * recursively process the left part as left child (if exist, we also need to maintain
 * a prev pointer here) and the right part as right child. Then return the root.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null; 
        }
        
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        ListNode prev = null; 
        
        while (slow != null && fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                fast = fast.next; 
                prev = slow; 
                slow = slow.next; 
            }
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        if (prev != null) {
            prev.next = null; 
            root.left = sortedListToBST(head);
        }
        
        root.right = sortedListToBST(slow.next);
        
        return root; 
    }
}
