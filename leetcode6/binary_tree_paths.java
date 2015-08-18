/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find all root to leaf pathes in a given binary tree. 
 * Solve it recursively. Carry a list of values along the recursive calls. Once it hits a 
 * leaf, meaning it finds a path. Build the path string via string builder and then stored 
 * in the result list. 
 */
public class Solution {
    private List<String> result = new ArrayList<>(); 
    
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new ArrayList<Integer>());
        
        return result; 
    }
    
    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return; 
        }
        
        if (node.left == null && node.right == null) {
            list.add(node.val);
            StringBuilder sb = new StringBuilder(String.valueOf(list.get(0))); 
            
            for (int i = 1; i < list.size(); i++) {
                sb.append("->");
                sb.append(String.valueOf(list.get(i)));
            }
            
            result.add(sb.toString());
            list.remove(list.size() - 1);
            return; 
        }
        
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
        list.remove(list.size() - 1);
        
        return; 
    }
}
