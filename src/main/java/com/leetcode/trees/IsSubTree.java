package com.leetcode.trees;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class IsSubTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (t == null)
			return true;

		if (checkSubTree(s, t)) {
			return true;
		}
		
		return (isSubtree(s.left, t) || isSubtree(s.right, t));

	}

	private boolean checkSubTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;

		if (s == null || t == null)
			return false;

		return s.val == t.val && checkSubTree(s.left, t.left) && checkSubTree(s.right, t.right);
	}

	public static void main(String[] args) {
		System.out.println(new IsSubTree().isSubtree(null, null));
	}
}
