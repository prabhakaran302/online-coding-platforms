package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	public static void main(String[] args) {
		InOrderTraversal obj = new InOrderTraversal();
		TreeNode root = new TreeNode(12);
		List<Integer> list = obj.inorderTraversal(root);
		System.out.println(list);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

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