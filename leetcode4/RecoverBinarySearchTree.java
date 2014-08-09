public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> inorder = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                inorder.add(curr);
                curr = curr.right;
            }
        }

        TreeNode firstLarge = null;
        TreeNode lastLess = null;

        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                firstLarge = inorder.get(i);
                break;
            }
        }

        for (int i = inorder.size() - 1; i > 0; i--) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                lastLess = inorder.get(i);
                break; 
            }
        }

        if (firstLarge != null && lastLess != null) {
            int temp = firstLarge.val;
            firstLarge.val = lastLess.val;
            lastLess.val = temp;
        }
    }
}
