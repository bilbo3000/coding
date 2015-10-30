/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * 
 * O(logN)
 */
public class Solution {
    class SegmentTreeNode {
        int l; 
        int r; 
        int min; 
        SegmentTreeNode left; 
        SegmentTreeNode right; 
        
        SegmentTreeNode(int l, int r, int min) {
            this.l = l; 
            this.r = r; 
            this.min = min; 
        }
    }
    
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        SegmentTreeNode root = build(A, 0, A.length - 1);
        ArrayList<Integer> result = new ArrayList<>(); 
        
        for (Interval item : queries) {
            result.add(query(root, item.start, item.end));
        }
        
        return result; 
    }
    
    private int query(SegmentTreeNode node, int l, int r) {
        if (node == null) {
            return Integer.MAX_VALUE; 
        }
        
        if (node.l >= l && node.r <= r) {
            return node.min; 
        }
        
        return Math.min(query(node.left, l, r), query(node.right, l, r));
    }
    
    private SegmentTreeNode build(int[] A, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            SegmentTreeNode node = new SegmentTreeNode(l, r, A[l]); 
            return node; 
        }
        
        int mid = (l + r) / 2; 
        SegmentTreeNode left = build(A, l, mid);
        SegmentTreeNode right = build(A, mid + 1, r);
        SegmentTreeNode node = new SegmentTreeNode(l, r, Math.min(left.min, right.min));
        node.left = left; 
        node.right = right; 
        
        return node; 
    }
}
