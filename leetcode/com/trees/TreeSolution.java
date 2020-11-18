package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeSolution {
	public static void main(String[] args) {
		TreeSolution sol = new TreeSolution();
		TreeNode root = TreeNode.getTree();
		TreeNode.preOder(root);

		System.out.println();
		System.out.println(sol.getLonelyNodes(root));
		System.out.println(sol.serialize(root));
		TreeNode node = sol.deserialize(sol.serialize(root));
		TreeNode.preOder(node);

		System.out.println();
		System.out.println(sol.rightSideView(root));
		System.out.println(sol.numTrees(3));

		int[] pre = new int[] { 3, 9, 20, 15, 7 };
		int[] in = new int[] { 9, 3, 15, 20, 7 };
		TreeNode.preOder(sol.buildTree(pre, in));

		System.out.println();
		System.out.println(sol.levelOrder(root));

		System.out.println(sol.isValidBST(root));

	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> li = new ArrayList<>();
		if (root == null)
			return li;
		li.add(root.val);
		addInLeft(root, li);
		addLeaves(root.left, li);
		addLeaves(root.right, li);
		addfromRight(root, li);
		return li;
	}

	private void addfromRight(TreeNode root, List<Integer> li) {
		if (root == null)
			return;
		if (root.right != null) {
			addfromRight(root.right, li);
			li.add(root.val);
		} else if (root.left != null) {
			addfromRight(root.left, li);
			li.add(root.val);
		}
	}

	private void addLeaves(TreeNode node, List<Integer> li) {
		if (node == null)
			return;
		addLeaves(node.left, li);
		if (node.left == null && node.right == null)
			li.add(node.val);
		addLeaves(node.right, li);
	}

	private void addInLeft(TreeNode root, List<Integer> li) {
		if (root == null)
			return;
		if (root.left != null) {
			li.add(root.val);
			addInLeft(root.left, li);
		} else if (root.right != null) {
			li.add(root.val);
			addInLeft(root.right, li);
		}
	}

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;

		if (n1 != null && n2 != null && n1.val == n2.val)
			return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);

		return false;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return maxDepth(root, 1);
	}

	private int maxDepth(TreeNode root, int i) {
		if (root == null)
			return i;
		int l = maxDepth(root.left, i + 1);
		int r = maxDepth(root.right, i + 1);
		return Math.max(l, r);
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		Sum sum = new Sum();
		rangeSumBST(root, L, R, sum);
		return sum.sum;
	}

	private void rangeSumBST(TreeNode root, int l, int r, Sum sum) {
		if (root == null)
			return;
		if (root.val >= l && root.val <= r)
			sum.sum += root.val;
		if (root.val < l)
			return;
		if (root.val > r)
			return;
		rangeSumBST(root.left, l, r, sum);
		rangeSumBST(root.right, l, r, sum);
	}

	class Sum {
		int sum = 0;
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTUtil(TreeNode root, long minValue, int maxValue) {
		if (root == null)
			return true;

		if ((minValue == Integer.MIN_VALUE && root.val == minValue && root.left != null)
				|| (maxValue == Integer.MAX_VALUE && root.val == maxValue && root.right != null))
			return false;

		if (root.val > maxValue || root.val < minValue)
			return false;

		boolean l = isValidBSTUtil(root.left, minValue, root.val - 1);
		boolean r = isValidBSTUtil(root.right, root.val + 1, maxValue);

		return l && r;
	}

	public List<Integer> getLonelyNodes(TreeNode root) {
		var list = new ArrayList<Integer>();
		getLonelyNodes(root, list);
		return list;
	}

	private TreeNode getLonelyNodes(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return null;

		TreeNode left = getLonelyNodes(root.left, list);
		TreeNode right = getLonelyNodes(root.right, list);

		if (left != null && right != null)
			return root;
		else if (left == null && right == null) {
			return root;
		} else {
			if (left == null)
				list.add(right.val);
			else
				list.add(left.val);
			return root;
		}

	}

	public String serialize(TreeNode root) {
		var sb = new ArrayList<String>();
		var q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == null)
				sb.add("#");
			else
				sb.add(String.valueOf(cur.val));
			if (cur != null) {
				q.add(cur.left);
				q.add(cur.right);
			}
		}
		return String.join(",", sb);
	}

	public TreeNode deserialize(String data) {
		if (data.startsWith("#"))
			return null;
		String str[] = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(str[0])));
		var q = new LinkedList<TreeNode>();
		q.offer(root);

		int ind = 1;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur != null) {
				String l = String.valueOf(str[ind++]);
				String r = String.valueOf(str[ind++]);

				if (!l.equalsIgnoreCase("#"))
					cur.left = new TreeNode(Integer.parseInt(l));
				if (!r.equalsIgnoreCase("#"))
					cur.right = new TreeNode(Integer.parseInt(r));

				q.offer(cur.left);
				q.offer(cur.right);
			}
		}
		return root;
	}

	public List<Integer> rightSideView(TreeNode root) {
		var list = new ArrayList<Integer>();

		var q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				TreeNode cur = q.poll();
				if (i == n - 1) {
					list.add(cur.val);
				}
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
		}
		return list;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameterOfBinaryTree(root.left);
		int rd = diameterOfBinaryTree(root.right);

		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		int l = height(root.left);
		int r = height(root.right);

		return Math.max(l, r) + 1;
	}

	/**
	 * Catalan Number = (((2n)!/(n+1)!*n(!))
	 * 
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		// TODO: return cataln
		return 0;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		var map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		AtomicInteger pIndex = new AtomicInteger(0);
		return buildTreeUtil(preorder, map, 0, preorder.length - 1, pIndex);
	}

	private TreeNode buildTreeUtil(int[] preorder, HashMap<Integer, Integer> map, int low, int high,
			AtomicInteger pIndex) {
		if (low > high)
			return null;

		TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);
		int inInd = map.get(root.val);
		root.left = buildTreeUtil(preorder, map, low, inInd - 1, pIndex);
		root.right = buildTreeUtil(preorder, map, inInd + 1, high, pIndex);

		return root;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		var q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int n = q.size();
			List<Integer> li = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				TreeNode cur = q.poll();
				li.add(cur.val);

				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			list.add(li);
		}
		return list;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
		if (low > high)
			return null;
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, low, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, high);
		return root;
	}
}
