/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     * 
     * O(n)
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return; 
        }
        
        // Current node if leaf node
        if (root.start == index && root.end == index) {
            root.max = value; 
            return; 
        }
        
        // Figure out which branch to go down to modify,
        // The other branch is untouched.
        if (index <= (root.start + root.end) / 2) {
            modify(root.left, index, value); 
        } else {
            modify(root.right, index, value);
        }
        
        root.max = Math.max(root.left.max, root.right.max);
    }
}
