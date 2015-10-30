/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    class SegmentTreeNode {
        int l; 
        int r; 
        long sum; 
        SegmentTreeNode left; 
        SegmentTreeNode right; 
        
        SegmentTreeNode(int l, int r, long sum) {
            this.l = l; 
            this.r = r; 
            this.sum = sum; 
        }
    }
    
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     * Build segment tree. Thus, each query will at most travel the depth of the 
     * tree, which is O(logN). 
     * 
     * O(logN) for each query. 
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<>(); 
        SegmentTreeNode root = build(A, 0, A.length - 1);
        
        for (Interval item : queries) {
            result.add(new Long(query(root, item.start, item.end)));
        }
        
        return result; 
    }
    
    private SegmentTreeNode build(int[] A, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            SegmentTreeNode node = new SegmentTreeNode(l, r, (long)A[l]); 
            return node; 
        }
        
        int mid = (l + r) / 2; 
        SegmentTreeNode left = build(A, l, mid); 
        SegmentTreeNode right = build(A, mid + 1, r); 
        long sum = 0; 
        
        if (left != null) {
            sum += left.sum; 
        }
        
        if (right != null) {
            sum += right.sum; 
        }
        
        SegmentTreeNode node = new SegmentTreeNode(l, r, sum);
        node.left = left; 
        node.right = right; 
        
        return node;
    }
    
    private long query(SegmentTreeNode node, int l, int r) {
        if (node.l >= l && node.r <= r) {
            return node.sum; 
        }
        
        if (node.r < l || node.l > r) {
            return 0; 
        }
        
        return query(node.left, l, r) + query(node.right, l, r);
    }
}

