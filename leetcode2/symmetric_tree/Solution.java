/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        ArrayList<TreeNode> left = new ArrayList<TreeNode>();
        ArrayList<TreeNode> right = new ArrayList<TreeNode>();
        inorder(root, left);
        inorder(root, right);
        Collections.reverse(right);

        if (left.size() != right.size()) return false;

        for (int i = 0; i < left.size(); i++) {
            TreeNode n1 = left.get(i);
            TreeNode n2 = right.get(i);

            if (n1 == null && n2 == null) continue;
            if (n1 == null && n2 != null || n1 != null && n2 == null) return false;
            if (n1.val != n2.val) return false;
        }

        return true;
    }

    void inorder(TreeNode root, ArrayList<TreeNode> al) {
        if (root == null || (root.left == null && root.right == null)) {
            al.add(root);
            return;
        }

        inorder(root.left, al);
        al.add(root);
        inorder(root.right, al);
    }
}
