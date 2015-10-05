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
 * 
 * Recursive solution. 
 * Time complexity? 
 */
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int l, int r) {
        if (l > r) {
            List<TreeNode> list = new ArrayList<>(); 
            list.add(null);
            return list; 
        }
        
        List<TreeNode> result = new ArrayList<>(); 
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = helper(l, i - 1);
            List<TreeNode> right = helper(i + 1, r);
            
            for (TreeNode lnode : left) {
                for (TreeNode rnode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode; 
                    root.right = rnode; 
                    result.add(root); 
                }
            }
        }
        
        return result; 
    }
}
