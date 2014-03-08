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
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>(); 
        
        if (n == 0) { 
            result.add(null); 
            return result; 
        }
        
        result = helper(1, n); 
        return result; 
    }
    
    public ArrayList<TreeNode> helper(int l, int r) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>(); 
        
        if (l > r) return result; 
        
        for (int i = l; i <= r; i++) {
            ArrayList<TreeNode> leftResult = helper(l, i - 1); 
            ArrayList<TreeNode> rightResult = helper(i + 1, r); 
            
            int lsize = leftResult.size(); 
            int rsize = rightResult.size(); 
            
            if (lsize == 0 || rsize == 0) {
                if (lsize == 0 && rsize == 0) {
                    result.add(new TreeNode(i)); 
                }
                else if (lsize == 0) {
                    for (int j = 0; j < rsize; j++) {
                        TreeNode node = new TreeNode(i); 
                        node.right = rightResult.get(j); 
                        result.add(node); 
                    }
                }
                else {
                    for (int j = 0; j < lsize; j++) {
                        TreeNode node = new TreeNode(i); 
                        node.left = leftResult.get(j); 
                        result.add(node); 
                    } 
                }
            }
            else {
                for (int j = 0; j < lsize; j++) {
                    for (int k = 0; k < rsize; k++) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftResult.get(j); 
                        node.right = rightResult.get(k); 
                        result.add(node); 
                    }
                }
            }
        }
        
        return result; 
    }
}
