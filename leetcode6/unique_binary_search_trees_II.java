/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find all the unique binary search trees with nodes numbered from 1 to n. 
 * Solve it recursively. The idea was to let each number from l to r be the 
 * root and recursively process its left and right parts. Then attach the 
 * results returned from left and right subtree in all the ways to the root 
 * and return all the possibilities as the result. Note that if l > r, add 
 * null to the result, which will make life a lot easier after it returns, 
 * since we have something to iterate through instead of getting an empty set.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> result = new ArrayList<>(); 
        
        if (l > r) {
            result.add(null);
            return result; 
        }
        
        if (l == r) {
            result.add(new TreeNode(l));
            return result; 
        }
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> lchild = helper(l, i - 1);
            List<TreeNode> rchild = helper(i + 1, r); 
            
            for (TreeNode leftItem : lchild) {
                for (TreeNode rightItem : rchild) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftItem; 
                    root.right = rightItem; 
                    result.add(root);
                }
            }
        }
        
        return result; 
    }
}
