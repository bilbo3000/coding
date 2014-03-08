import java.util.*;

public class Solution {
    /*
        Insert a node to the tri-nary tree.
        @return the root of the tri-nary tree.
     */
    public TreeNode insert(TreeNode root, int x) {
        TreeNode node = new TreeNode(x);

        if (root == null) {  // Tree is empty
            root = node;
            return root;
        }

        // Traverse the tree to find right location to insert.
        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {
            prev = curr;

            if (curr.val > x) {
                curr = curr.left;
            } else if (curr.val < x) {
                curr = curr.right;
            } else {
                curr = curr.middle;
            }
        }

        // Insert
        if (x < prev.val) {
            prev.left = node;
        } else if (x > prev.val) {
            prev.right = node;
        } else {
            prev.middle = node;
        }

        node.parent = prev;  // Point to parent node

        return root;
    }

    /*
        Delete the first node with given value from the given
        tri-nary tree.
     */
    public TreeNode delete(TreeNode root, int x) {
        // Traverse the tree to look for the node to be deleted.
        TreeNode node = root;

        while (node != null) {
            if (node.val == x) {
                break;
            }

            if (node.val > x) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) {
            return root;  // Node does not exist, return
        }

        // Delete node
        if (node.middle != null) {  // Middle branch exists
            TreeNode curr = node;

            while (curr.middle != null) {
                curr = curr.middle;
            }

            curr.parent.middle = null;  // Remove the last node on the mid branch
        } else {  // Middle branch does not exist
            if (node.right == null) {
                root = transplant(root, node, node.left);   // Transplant from left
            } else if (node.left == null) {
                root = transplant(root, node, node.right);  // Transplant from right
            } else {  // Both left and right sub tree exist
                TreeNode y = findMin(node);  // Promote the smallest one in the right subtree

                if (y.parent != node) {
                    root = transplant(root, y, y.right);
                    y.right = node.right;
                    y.right.parent = y;
                }

                root = transplant(root, node, y);
                y.left = node.left;
                y.left.parent = y;
            }
        }

        return root;
    }

    /*
        Helper function that transplant node v to node u.
     */
    private TreeNode transplant(TreeNode root, TreeNode u, TreeNode v) {
        if (u == null) {
            return root;
        }

        if (u.parent == null) {  // Replace root
            root = v;
        } else {
            if (u == u.parent.left) {  // u is left child
                u.parent.left = v;
            } else if (u == u.parent.right) {  // u is right child
                u.parent.right = v;
            } else {  // u is middle child
                u.parent.middle = v;
            }

            if (v != null) {
                v.parent = u.parent;   // Update v's parent
            }
        }

        return root;
    }

    /*
        Helper function that finds the min node in the
        subtree start from given node.
     */
    private TreeNode findMin(TreeNode node) {
        TreeNode curr = node;

        while (curr != null && curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    /*
        Prints the given tri-nary tree level by level
     */
    public void levelPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>();
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>());
        int lev1 = 0;
        int lev2 = 1;
        levels.get(lev1).add(root);

        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev1);
            ArrayList<TreeNode> next = levels.get(lev2);

            for (TreeNode node : curr) {
                System.out.print(node.val + " ");

                if (node.left != null) {
                    next.add(node.left);
                }

                if (node.middle != null) {
                    next.add(node.middle);
                }

                if (node.right != null) {
                    next.add(node.right);
                }
            }

            System.out.println();
            curr.clear();
            lev1 = lev1 ^ lev2;
            lev2 = lev1 ^ lev2;
            lev1 = lev1 ^ lev2;
        }

        System.out.println();
    }
}
