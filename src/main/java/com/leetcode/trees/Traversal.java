package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
	public static void main(String[] args) {
		Traversal obj = new Traversal();
		TreeNode root = obj.getTree();

		List<Integer> list = obj.inOrderTraversalIterative(root);
		System.out.println("inOrderTraversalIterative " + list);

		list = obj.inorderTraversalRecursive(root);
		System.out.println("inorderTraversalRecursive " + list);

		list = obj.preOrderTraversalIterative(root);
		System.out.println("preOrderTraversalIterative " + list);

		list = obj.preOrderTraversalRecursive(root);
		System.out.println("preOrderTraversalRecursive " + list);

		list = obj.postOrderTraversalRecursive(root);
		System.out.println("postOrderTraversalRecursive " + list);

		list = obj.postOrderTraversalIterative(root);
		System.out.println("postOrderTraversalIterative " + list);
	}

	private List<Integer> postOrderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postOrderTraversalRecursiveUtil(root, list);
		return list;
	}

	private void postOrderTraversalRecursiveUtil(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		postOrderTraversalRecursiveUtil(root.left, list);
		postOrderTraversalRecursiveUtil(root.right, list);
		list.add(root.val);
	}

	private List<Integer> postOrderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			if (root.right != null) {
				stack.push(root.right);
			}
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			while (root != null) {
				if (root.right != null) {
					stack.push(root.right);
				}
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (!stack.isEmpty() && stack.peek() == root.right) {
				stack.pop();
				stack.push(root);
				root = root.right;
			} else {
				list.add(root.val);
				root = null;
			}
		}

		return list;
	}

	private List<Integer> preOrderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preOrderTraversalRecursiveUtil(root, list);
		return list;
	}

	private void preOrderTraversalRecursiveUtil(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		preOrderTraversalRecursiveUtil(root.left, list);
		preOrderTraversalRecursiveUtil(root.right, list);
	}

	private List<Integer> preOrderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}

		return list;
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorderTraversalRecursiveUtil(root, list);
		return list;
	}

	private void inorderTraversalRecursiveUtil(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorderTraversalRecursiveUtil(root.left, list);
		list.add(root.val);
		inorderTraversalRecursiveUtil(root.right, list);
	}

	public List<Integer> inOrderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
	}

	public TreeNode getTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}