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
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     * 
     * O(logn)
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0; 
        }
        
        if (root.start >= start && root.end <= end) {
            return root.max; 
        }
        
        // Completely fall into left subtree 
        if (end <= (root.start + root.end) / 2) {
            return query(root.left, start, end);
        }
        
        // Complete fall into right subtree 
        if (start >= (root.start + root.end) / 2 + 1) {
            return query(root.right, start, end);
        }
        
        // Fall into both left and right subtrees 
        return Math.max(query(root.left, start, end), query(root.right, start, end));
    }
    
}
