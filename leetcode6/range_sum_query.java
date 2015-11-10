public class NumArray {
    class Node {
        int sum; 
        int l; 
        int r; 
        
        Node(int sum) {
            this.sum = sum;
        }
        
        Node left; 
        Node right; 
    }
    
    private Node root; 

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    private Node build(int[] nums, int i, int j) {
        if (i > j) return null; 
        if (i == j) {
            Node node = new Node(nums[i]);
            node.l = i; 
            node.r = j; 
            
            return node; 
        }
        
        int mid = (i + j) / 2; 
        Node left = build(nums, i, mid);
        Node right = build(nums, mid + 1, j);
        Node node = new Node(left.sum + right.sum);
        node.left = left; 
        node.right = right; 
        node.l = i; 
        node.r = j; 
        
        return node; 
    }

    public int sumRange(int i, int j) {
        return find(root, i, j); 
    }
    
    private int find(Node node, int i, int j) {
        if (node == null) return 0; 
        if (i <= node.l && j >= node.r) {
            return node.sum; 
        }
        
        if (node.l > j || node.r < i) {
            return 0; 
        }
        
        return find(node.left, i, j) + find(node.right, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
