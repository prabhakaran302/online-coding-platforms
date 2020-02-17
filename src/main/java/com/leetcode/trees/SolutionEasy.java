package com.leetcode.trees;

public class SolutionEasy {
	/**
	 * Given the root node of a binary search tree, return the sum of values of all
	 * nodes with value between L and R (inclusive).
	 * 
	 * The binary search tree is guaranteed to have unique values.
	 */
	public int rangeSumBST(TreeNode root, int L, int R) {
		Sum sum = new Sum();
		rangeSumBST(root, L, R, sum);
		return sum.sum;
	}

	class Sum {
		int sum;
	}

	private void rangeSumBST(TreeNode root, int l, int r, Sum sum) {
		if (root == null)
			return;
		if (root.val >= l && root.val <= r) {
			sum.sum = sum.sum + root.val;
		}
		if (root != null && root.val >= l)
			rangeSumBST(root.left, l, r, sum);
		if (root != null && root.val <= r)
			rangeSumBST(root.right, l, r, sum);
	}

	/**
	 * Given two binary trees and imagine that when you put one of them to cover the
	 * other, some nodes of the two trees are overlapped while the others are not.
	 * 
	 * You need to merge them into a new binary tree. The merge rule is that if two
	 * nodes overlap, then sum node values up as the new value of the merged node.
	 * Otherwise, the NOT null node will be used as the node of new tree.
	 * 
	 * Example 1:
	 * 
	 * Input: Tree 1 Tree 2 1 2 / \ / \ 3 2 1 3 / \ \ 5 4 7 Output: Merged tree: 3 /
	 * \ 4 5 / \ \ 5 4 7
	 */

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;
		TreeNode root = new TreeNode(t1 == null ? t2.val : t2 == null ? t1.val : t1.val + t2.val);
		root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
		root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
		return root;
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		if (root.val >= val)
			return searchBST(root.left, val);
		else
			return searchBST(root.right, val);
	}

	/**
	 * 
	 * Given a binary tree, find the length of the longest path where each node in
	 * the path has the same value. This path may or may not pass through the root.
	 * 
	 * The length of path between two nodes is represented by the number of edges
	 * between them.
	 * 
	 * 
	 */
	class LongestUniPathValue {
		int res;

		LongestUniPathValue() {
			res = 0;
		}
	}

	public int longestUnivaluePath(TreeNode root) {
		LongestUniPathValue l = new LongestUniPathValue();
		longestUnivaluePathUtil(root, l);
		return l.res;
	}

	private int longestUnivaluePathUtil(TreeNode root, LongestUniPathValue l) {
		if (root == null)
			return 0;
		int left = longestUnivaluePathUtil(root.left, l);
		int right = longestUnivaluePathUtil(root.right, l);
		int arrowLeft = 0, arrowRight = 0;
		if (root.left != null && root.left.val == root.val) {
			arrowLeft += left + 1;
		}
		if (root.right != null && root.right.val == root.val) {
			arrowRight += right + 1;
		}
		l.res = Math.max(l.res, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null && sum == 0)
			return true;
		boolean left = hasPathSum(root.left, sum - root.val);
		boolean right = hasPathSum(root.right, sum - root.val);

		return left || right;
	}

	class Mode	{
		int curval = 0;
		int curcount = 0;
		int[] mode;
		int maxcount = 0;
		int modecount = 0;
	}
	
	public int[] findMode(TreeNode root) {
		Mode mode = new Mode();
		inorder(root,mode);
		mode.mode = new int[mode.modecount];
		mode.curcount = 0;
		mode.modecount = 0;
		inorder(root,mode);
		return mode.mode;
	}

	private void handleval(int val, Mode m) {
		if (m.curval != val) {
			m.curval = val;
			m.curcount = 0;
		}
		m.curcount++;
		if (m.curcount > m.maxcount) {
			m.maxcount = m.curcount;
			m.modecount = 1;
		} else if (m.curcount == m.maxcount) {
			if (m.mode != null) {
				m.mode[m.modecount] = m.curval;
			}
			m.modecount++;
		}
	}

	private void inorder(TreeNode root, Mode m) {
		if (root == null)
			return;
		inorder(root.left,m);
		handleval(root.val,m);
		inorder(root.right,m);
	}

	public static void main(String[] args) {
		Traversal obj = new Traversal();
		TreeNode root = obj.getTree();
		SolutionEasy sol = new SolutionEasy();
		System.out.println(sol.rangeSumBST(root, 2, 5));

		root = getTree();
		System.out.println(sol.minDepth(root));
	}

	private static TreeNode getTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);

		return root;
	}

}
