/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.*; 

public class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>(); 
        TreeNode curr = root; 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                s.push(curr); 
                curr = curr.left; 
            }
            else {
                curr = s.pop(); 
                temp.add(curr);
                curr = curr.right; 
            }
        }
        
        int a = -1; 
        int b = -1;
        int n = temp.size(); 
        
        for (int i = 0; i < n - 1; i++) {
            int x = temp.get(i).val; 
    
            if (x > temp.get(i + 1).val) {
                if (i == 0 || x > temp.get(i - 1).val) {
                    a = i; 
                    break; 
                }
            }
        }
        
        for (int i = n - 1; i > 0; i--) {
            int x = temp.get(i).val; 
            
            if (x < temp.get(i - 1).val) {
                if (i == n - 1 || x < temp.get(i + 1).val) {
                    b = i; 
                    break; 
                }
            }
        }
        
        if (a != -1 && b != -1) {
            int t = temp.get(a).val; 
            temp.get(a).val = temp.get(b).val; 
            temp.get(b).val = t; 
        }
    }
}