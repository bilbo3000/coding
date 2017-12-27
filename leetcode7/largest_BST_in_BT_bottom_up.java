/**
 * Given a BT. Find the size of the larget BST within the BT.
 *  
 * This is the bottom up solution (meaning when recur each node, visit both child 
 * before visit itself such that info from children can propagate up). It returns an 
 * info structure with the following info: 
 * - size: size of the subtree. This need to be constantly bubble up because parent 
 * node may need this information to calculate its size, say, it's a BST. 
 * 
 * - min, max: min is the min of the subtree, which is used when subtree is a right child, 
 * and max is the max of the subtree, which is used when subtree is a left child. It 
 * returns both so the parent can pick the right one to use. (This could easily leed
 * to error if base case not initialize right, make sure consider both null case, and
 * leaf node case separately). 
 * 
 * - ans: the current answer rooted at current subtree. (meaning the max BST within
 * give subtree). This is needed because when current subtree is not a BST, it need
 * to choose which child to get the current solution. (note that if current subtree
 * is BST, then its size must be the current answer as it must larger than either 
 * child's solution). 
 * 
 * - isBST: whether subtree is a BST. This is needed because parent node need to use 
 * this piece of information to determine whether itself is a BST.
 * 
 * The cores are 
 * 1) that a BT is a BST when both left and right child is BST and the min
 * of right is larger than root and max of left is smaller than root. 
 * 2) traverse bottom-up can bubble up these information. 
 * 
 * Time: O(n)
 */
public class Solution {
	
	class Info {
		int size; // Size of subtree rooted at current node
		int min; // The min value in the subtree, used when it's a right subtree
		int max; // The max value in the subtree, used when it's a left subtree
		int ans; // The results up to the current subtree
		boolean isBST; // Whether current subtree is a BST
		
		private Info(int size, int min, int max, int ans, boolean isBST) {
			this.size = size; 
			this.min = min; 
			this.max = max; 
			this.ans = ans; 
			this.isBST = isBST; 
		}
	}
	
	public int largestBST(TreeNode root) {
		return helper(root).ans;
	}
	
	/*
	 * Helper method traverse the tree bottom-up. 
	 */
	private Info helper(TreeNode root) {
		Info info = new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true); 
		
		if (root == null) {
			return info; 
		}
		
		if (root.left == null && root.right == null) {
			return new Info(1, root.value, root.value, 1, true);
		}
		
		// Recur on left and right child 
		Info l = helper(root.left);
		Info r = helper(root.right);
		
		info.size = l.size + 1 + r.size; 
		info.min = Math.min(root.value, Math.min(l.min, r.min)); 
		info.max = Math.max(root.value, Math.max(l.max, r.max));
		
		// First check if current subtree is BST
		if (root.value >= l.max && root.value <= r.min && l.isBST && r.isBST) {
			info.ans = info.size; 
			info.isBST = true; 
		} else {
			info.ans = Math.max(l.ans, r.ans);
			info.isBST = false; 
		}
		
		return info;
	}
	
	/*
	 * Helper method determines if a given BT is a BST
	 */
	public boolean isBST(TreeNode root) {
		if (root == null) {
			return true; 
		}
		
		if (root.left == null && root.right == null) {
			return true; 
		}
		
		// Left child should smaller than 
		if (root.left != null && root.left.value > root.value) {
			return false; 
		}
		
		return isSmaller(root.left, root.value) && isLarger(root.right, root.value) && isBST(root.left) && isBST(root.right);
		
	}
	
	/*
	 * Helper method checks if all elements in given BT are no larger than given value. 
	 */
	private boolean isSmaller(TreeNode root, int value) {
		if (root == null) {
			return true; 
		}
		
		if (root.value > value) {
			return false; 
		}
		
		return isSmaller(root.left, value) && isSmaller(root.right, value);
	}
	
	private boolean isLarger(TreeNode root, int value) {
		if (root == null) {
			return true; 
		}
		
		if (root.value < value) {
			return false; 
		}
		
		return isLarger(root.left, value) && isLarger(root.right, value);
	}
	
	/*
	 * Helper method calculates the size of a BT
	 */
	private int size(TreeNode root) {
		if (root == null) {
			return 0; 
		}
		
		if (root.left == null && root.right == null) {
			return 1; 
		}
		
		return size(root.left) + 1 + size(root.right);
	}
}
