package com.dcp;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes
 * under it have the same value. Given the root to a binary tree, count the
 * number of unival subtrees
 * 
 * @author prabhakaran.nivanil
 *
 */
public class CountUnivalTrees {

	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		is_uni(root);
		return count;
	}

	private TreeNode is_uni(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = is_uni(root.left);
		TreeNode right = is_uni(root.right);

		if (left == null && right == null) {
			count++;
			return root;
		}

		if (left != null && right != null) {
			if (left.val == right.val && left.val == root.val) {
				count++;
				return root;
			} else {
				return root;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(4);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(5);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(4);
		tree.right.right = new TreeNode(5);

		CountUnivalTrees c = new CountUnivalTrees();
		System.out.println(c.countUnivalSubtrees(tree));
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
