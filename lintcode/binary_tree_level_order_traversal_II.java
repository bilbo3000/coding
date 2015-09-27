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
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
                // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (root != null) {
            levels.get(0).add(root);
        }
        
        while (levels.get(lev0).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev0);
            ArrayList<TreeNode> next = levels.get(lev1);
            ArrayList<Integer> temp = new ArrayList<>(); 
            
            for (TreeNode item : curr) {
                temp.add(item.val);
                
                if (item.left != null) {
                    next.add(item.left);
                }
                
                if (item.right != null) {
                    next.add(item.right);
                }
            }
            
            result.add(temp);
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return result; 
    }
}
