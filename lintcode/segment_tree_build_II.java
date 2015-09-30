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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     * 
     * O(n)
     */
    public SegmentTreeNode build(int[] A) {
        return helper(A, 0, A.length - 1);
    }
    
    private SegmentTreeNode helper(int[] A, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            return new SegmentTreeNode(l, r, A[l]); 
        }
        
        SegmentTreeNode left = helper(A, l, (l + r) / 2); 
        SegmentTreeNode right = helper(A, (l + r) / 2 + 1, r);
        
        SegmentTreeNode node = new SegmentTreeNode(l, r, Math.max(left.max, right.max));
        node.left = left; 
        node.right = right; 
        
        return node; 
    }
}
