/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Traverse a binary tree in zig zag level order. 
 * The idea was to use alternating two levels traverse the tree. Meanwhile, 
 * count the number of levels. And for even levels, collections.reverse the 
 * list before save the result. 
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        int count = 0; 
        
        if (root != null) {
            levels.get(lev0).add(root);
        }
        
        while (levels.get(lev0).size() != 0) {
            List<TreeNode> curr = levels.get(lev0); 
            List<TreeNode> next = levels.get(lev1);
            List<Integer> list = new ArrayList<>(); 
            count++; 
            
            for (TreeNode node : curr) {
                list.add(node.val); 
                
                if (node.left != null) {
                    next.add(node.left);
                }
                
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            
            if (count % 2 == 0) {
                Collections.reverse(list);
            }
            
            result.add(list);
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return result; 
    }
}
