/**
 * Given a BT. Find the size of the larget BST within the BT.
 *  
 * This is the brute force solution. Inorder traversal the tree. 
 * For a given node N, check if the BT rooted at N is a BST. If yes, 
 * then find its size and return. (Because of inorder traversal, 
 * this is guaranteed to find the largest BST, cause the higher 
 * the root, the larger the tree). If not, then recur on subtrees 
 * and return the max size. 
 *
 * Time: O(N^2), skewed tree. 
 */
public class Solution {
	public int largestBST(TreeNode root) {
		
		if (isBST(root)) {
			return size(root);
		} else {
			return Math.max(largestBST(root.left), largestBST(root.right));
		}
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
