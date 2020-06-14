package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreOderAndInOrder {
	static int preIndex = 0;

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preIndex = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTreeUtil(preorder, inorder, 0, preorder.length - 1, map);
	}

	private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {
		if (start > end)
			return null;

		Integer cur = preorder[preIndex++];
		TreeNode node = new TreeNode(cur);

		int inIndex = map.get(cur);
		if (start == end)
			return node;

		node.left = buildTreeUtil(preorder, inorder, start, inIndex - 1, map);
		node.right = buildTreeUtil(preorder, inorder, inIndex + 1, end, map);
		return node;
	}
}
