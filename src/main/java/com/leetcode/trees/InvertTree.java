package com.leetcode.trees;

public class InvertTree {
	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = invertTree(root.left);
		TreeNode r = invertTree(root.right);

		if (left == null && r == null)
			return root;

		TreeNode temp = left;
		root.left = r;
		root.right = temp;

		return root;

	}
}
