import java.util.ArrayList;
import java.util.List;

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

        if (l == r) {
            TreeNode node = new TreeNode(l);
            result.add(node);

            return result;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = helper(l, i - 1);
            List<TreeNode> right = helper(i + 1, r);

                for (TreeNode litem : left) {
                    for (TreeNode ritem : right) {
                        TreeNode node = new TreeNode(i);

                        if (litem != null) {
                            node.left = litem;
                        }

                        if (ritem != null) {
                            node.right = ritem;
                        }
                        result.add(node);
                    }
                }
        }

        return result;
    }
}
