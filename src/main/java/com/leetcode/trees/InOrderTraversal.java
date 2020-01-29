package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	public static void main(String[] args) {
		InOrderTraversal obj = new InOrderTraversal();
		TreeNode root = new TreeNode(12);
		List<Integer> list = obj.inorderTraversal(root);
		System.out.println(list);
		list = obj.inorderTraversalRecursive(root);
		System.out.println(list);
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorderTraversalRecursiveUtil(root, list);
		return list;
	}

	public void inorderTraversalRecursiveUtil(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorderTraversalRecursiveUtil(root.left, list);
		list.add(root.val);
		inorderTraversalRecursiveUtil(root.right, list);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			while (root.left != null) {
				stack.push(root.left);
				root = root.left;
			}
			
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
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