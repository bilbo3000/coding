/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find all root-leaf paths which add up equal to the sum. 
 * Solve it recursively. Carry a list through recursive calls. When it reaches 
 * a leaf and its value is equal to the sum, then store that list. For the nodes 
 * in the middle of a branch, add its value to the list, subtract its value from 
 * sum, then move on to its left and right child. Remember to remove the item
 * we added to the list each time befor we return. 
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>(); 
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<Integer>());
        
        return result; 
    }
    
    private void helper(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return; 
        }
        
        if (node.left == null && node.right == null && node.val == sum) {
            list.add(node.val); 
            result.add(new ArrayList<Integer>(list)); 
            list.remove(list.size() - 1);
            return; 
        }
        
        list.add(node.val);
        helper(node.left, sum - node.val, list);
        helper(node.right, sum - node.val, list); 
        list.remove(list.size() - 1);
    }
}
