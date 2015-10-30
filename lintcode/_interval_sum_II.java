public class Solution {
    /* you may need to use some attributes here */
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

    private SegmentTreeNode root; 
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        root = build(A, 0, A.length - 1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     * 
     * O(logN)
     */
    public long query(int start, int end) {
        return queryHelper(root, start, end); 
    }
    
    private long queryHelper(SegmentTreeNode node, int l, int r) {
        if (node == null) {
            return 0; 
        }
        
        if (node.l >= l && node.r <= r) {
            return node.sum; 
        }
        
        if (node.r < l || node.l > r) {
            return 0; 
        }
        
        return queryHelper(node.left, l, r) + queryHelper(node.right, l, r); 
    }
    
    /**
     * @param index, value: modify A[index] to value.
     * 
     * O(logN)
     */
    public void modify(int index, int value) {
        modifyHelper(root, index, value); 
    }
    
    private void modifyHelper(SegmentTreeNode node, int index, int value) {
        if (node == null || index < node.l || index > node.r) {
            return; 
        }
        
        if (node.l == node.r && node.l == index) {
            node.sum = (long)value; 
            return; 
        }
        
        int mid = (node.l + node.r) / 2;
        
        if (index <= mid) {
            modifyHelper(node.left, index, value); 
        } else {
            modifyHelper(node.right, index, value); 
        }
        
        node.sum = 0; 
        
        if (node.left != null) {
            node.sum += node.left.sum; 
        }
        
        if (node.right != null) {
            node.sum += node.right.sum; 
        }
    }
    
    private SegmentTreeNode build(int[] A, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            SegmentTreeNode node = new SegmentTreeNode(l, r, (long) A[l]);
            return node; 
        }
        
        int mid = (l + r) / 2; 
        SegmentTreeNode left = build(A, l, mid); 
        SegmentTreeNode right = build(A, mid + 1, r); 
        SegmentTreeNode node = new SegmentTreeNode(l, r, left.sum + right.sum); 
        node.left = left; 
        node.right = right; 
        
        return node; 
    }
}

