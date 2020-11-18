package com.trees;

import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static void main(String[] args) {

	}

	public static TreeNode getTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		return root;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

	public static void preOder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " \t");
		preOder(root.left);
		preOder(root.right);
	}

	public static void preOder(TreeNode root, List<Integer> li) {
		if (root == null)
			return;
		li.add(root.val);
		preOder(root.left);
		preOder(root.right);
	}

}
