/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     * Preorder recursive traversal approach. 
     * If current node fall into the range, store the value and recursively process 
     * left and right subtree. 
     * If current node fall to the left of the range, recursively process right
     * subtree. 
     * If current node fall to the right of the range, recursively process left 
     * subtree. 
     * O(n) in worse case where all elements fall into the range. 
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        helper(root, k1, k2, result);
        Collections.sort(result);
        
        return result; 
    }
    
    private void helper(TreeNode node, int k1, int k2, ArrayList<Integer> result) {
        if (node == null) {
            return; 
        }
        
        if (k1 <= node.val && node.val <= k2) {
            result.add(node.val);
            helper(node.left, k1, k2, result);
            helper(node.right, k1, k2, result);
        } else if (node.val < k1) {
            helper(node.right, k1, k2, result);
        } else if (node.val > k2){
            helper(node.left, k1, k2, result);
        }
    }
}
