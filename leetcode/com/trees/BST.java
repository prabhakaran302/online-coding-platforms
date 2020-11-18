package com.trees;

import java.util.Stack;

class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		TreeNode node = stack.pop();
		TreeNode temp = node;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		return temp.val;
	}

	public boolean hasNext() {
		if (stack.isEmpty())
			return false;
		return true;
	}
}
