package com.leetcode.trees;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/submissions/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SecondMinimumNodeInTree {

	public int findSecondMinimumValue(TreeNode root) {
		Set<Integer> set = new TreeSet<>();
		findSecondMinimumValueUtil(root, set);

		if (set.size() <= 1)
			return -1;

		Iterator<Integer> it = set.iterator();
		int count = 0;
		Integer i = Integer.MAX_VALUE;
		while (it.hasNext()) {
			if (count >= 2)
				break;
			i = it.next();
			count++;
		}
		if (i == Integer.MAX_VALUE && set.size() != 2)
			return -1;

		return i;
	}

	private void findSecondMinimumValueUtil(TreeNode root, Set<Integer> set) {
		if (root == null)
			return;
		if (root != null) {
			set.add(root.val);
		}
		findSecondMinimumValueUtil(root.left, set);
		findSecondMinimumValueUtil(root.right, set);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2147483647);

		SecondMinimumNodeInTree obj = new SecondMinimumNodeInTree();
		System.out.println(obj.findSecondMinimumValue(root));
	}
}
