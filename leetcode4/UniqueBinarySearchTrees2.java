/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n); 
    }
    
    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> result = new ArrayList<TreeNode>(); 
        
        if (l > r) {
            result.add(null); 
            return result; 
        }
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = helper(l, i - 1);
            List<TreeNode> right = helper(i + 1, r);
            
            if (left.size() == 0) {
                for (TreeNode item : right) {
                    TreeNode node = new TreeNode(i);
                    node.right = item; 
                    result.add(node); 
                }
            } else if (right.size() == 0) {
                for (TreeNode item : left) {
                    TreeNode node = new TreeNode(i);
                    node.left = item; 
                    result.add(node); 
                }
            } else {
                for (TreeNode lnode : left) {
                    for (TreeNode rnode : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = lnode; 
                        node.right = rnode; 
                        result.add(node); 
                    }
                }
            }
        }
        
        return result; 
    }
}
