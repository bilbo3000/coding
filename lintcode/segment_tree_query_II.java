/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     * 
     * O(logn)
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0; 
        }
        
        // Query range *contains* segment range
        if (root.start >= start && root.end <= end) {
            return root.count; 
        }
        
        // Completely fall off range
        if (start > root.end || end < root.start) {
            return 0; 
        }
        
        return query(root.left, start, end) + query(root.right, start, end);
    }
}
