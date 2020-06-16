package com.leetcode.trees;

public class ValidBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(34);
		root.left = new TreeNode(-61);
		root.right = new TreeNode(-50);

		// root.right.left = new TreeNode(3);
		root.left.right = new TreeNode(45);

		ValidBST validBST = new ValidBST();
		System.out.println(validBST.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		return validBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean validBSTUtil(TreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;

		if(root.left != null && !(root.left.val < root.val))
			return false;
		
		if(root.right != null && !(root.right.val > root.val))
			return false;
		
		if (root.val < minValue || root.val > maxValue)
			return false;

		boolean left = validBSTUtil(root.left, minValue, root.val - 1);
		boolean right = validBSTUtil(root.right, root.val + 1, maxValue);

		return left == right;
	}
}
