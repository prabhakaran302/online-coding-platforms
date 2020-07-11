package com.practice.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.practice.easy.util.TreeNode;

/**
 * https://leetcode.com/explore/featured/card/july-leetcoding-challenge/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class JulyLeetCoding {
	public static void main(String[] args) {
		JulyLeetCoding julyLeetCoding = new JulyLeetCoding();
		System.out.println(julyLeetCoding.arrangeCoins(1));
		System.out.println("***************************\n");

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(julyLeetCoding.levelOrderBottom(root));
		System.out.println("***************************\n");

		int n = 10;
		System.out.println(julyLeetCoding.nthUglyNumber(n));
		System.out.println("***************************\n");

		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(julyLeetCoding.islandPerimeter(grid));
		System.out.println("***************************\n");

		int[] nums = new int[] { 0, 0, 0, 0 };
		System.out.println(julyLeetCoding.threeSum(nums));
		System.out.println("***************************\n");

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(julyLeetCoding.widthOfBinaryTree(root));
		System.out.println("***************************\n");

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.child = new Node(7);
		head.next.next.child.next = new Node(8);
		head.next.next.child.next.next = new Node(9);
		head.next.next.child.next.next.next = new Node(10);
		head.next.next.child.next.child = new Node(11);
		head.next.next.child.next.child.next = new Node(12);
		System.out.println(julyLeetCoding.flatten(head));
		System.out.println("***************************\n");
	}

	/**
	 * Given a set of distinct integers, nums, return all possible subsets (the
	 * power set).
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> nr = new ArrayList<List<Integer>>();
			for (List<Integer> li : result) {
				List<Integer> temlL = new ArrayList<Integer>(li);
				temlL.add(nums[i]);
				nr.add(temlL);
			}
			result.addAll(nr);
		}

		return result;
	}

	/**
	 * You are given a doubly linked list which in addition to the next and previous
	 * pointers, it could have a child pointer, which may or may not point to a
	 * separate doubly linked list. These child lists may have one or more children
	 * of their own, and so on, to produce a multilevel data structure, as shown in
	 * the example below.
	 * 
	 * Flatten the list so that all the nodes appear in a single-level, doubly
	 * linked list. You are given the head of the first level of the list.
	 * 
	 * 
	 * @param head
	 * @return
	 */
	public Node flatten(Node head) {
		return flattenUtil(head);

	}

	private Node flattenUtil(Node head) {
		if (head == null)
			return null;

		Node next = head.next;

		head.next = flattenUtil(head.child);

		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		tail.next = flattenUtil(next);

		return head;
	}

	/**
	 * Given a binary tree, write a function to get the maximum width of the given
	 * tree. The width of a tree is the maximum width among all levels. The binary
	 * tree has the same structure as a full binary tree, but some nodes are null.
	 * 
	 * The width of one level is defined as the length between the end-nodes (the
	 * leftmost and right most non-null nodes in the level, where the null nodes
	 * between the end-nodes are also counted into the length calculation.
	 * 
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {
		return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	private int dfs(TreeNode root, int level, int order, ArrayList<Integer> start, ArrayList<Integer> end) {
		// TODO Auto-generated method stub
		/*
		 * if (root == null) return 0; if (start.size() == level) { start.add(order);
		 * end.add(order); } else end.set(level, order);
		 * 
		 * int cur = end.get(level) - start.get(level) + 1;
		 * 
		 * int left = dfs(root.left, level + 1, 2 * order, start, end); int right =
		 * dfs(root.right, level + 1, 2 * order + 1, start, end);
		 * 
		 * 
		 * return Math.max(cur, Math.max(left, right));
		 */

		// Pending::
		return 0;
	}

	/**
	 * Given an array nums of n integers, are there elements a, b, c in nums such
	 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.parallelSort(nums);
		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}

				if (nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> li = new ArrayList<>();
					li.add(nums[i]);
					li.add(nums[j]);
					li.add(nums[k]);
					j++;
					k--;
					res.add(li);
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}

		return res;
	}

	/**
	 * You are given a map in form of a two-dimensional integer grid where 1
	 * represents land and 0 represents water.
	 * 
	 * Grid cells are connected horizontally/vertically (not diagonally). The grid
	 * is completely surrounded by water, and there is exactly one island (i.e., one
	 * or more connected land cells).
	 * 
	 * The island doesn't have "lakes" (water inside that isn't connected to the
	 * water around the island). One cell is a square with side length 1. The grid
	 * is rectangular, width and height don't exceed 100. Determine the perimeter of
	 * the island.
	 * 
	 * 
	 * @param grid
	 * @return
	 */
	public int islandPerimeter(int[][] grid) {
		int perim = 0;
		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					perim += findIncludingSide(grid, i, j);
				}
			}
		}

		return perim;
	}

	private int findIncludingSide(int[][] grid, int i, int j) {
		int row = grid.length;
		int col = grid[0].length;

		int count = 4;

		if (i > 0 && grid[i - 1][j] == 1)
			count--;

		if (i < row - 1 && grid[i + 1][j] == 1)
			count--;

		if (j > 0 && grid[i][j - 1] == 1)
			count--;

		if (j < col - 1 && grid[i][j + 1] == 1)
			count--;

		return count;
	}

	/**
	 * You have a total of n coins that you want to form in a staircase shape, where
	 * every k-th row must have exactly k coins.
	 * 
	 * Given n, find the total number of full staircase rows that can be formed.
	 * 
	 * n is a non-negative integer and fits within the range of a 32-bit signed
	 * integer.
	 * 
	 * @param n
	 * @return
	 */
	public int arrangeCoins(int n) {
		int end = n;
		int i = 1;
		for (i = 1; i <= n; i++) {
			if (end < i)
				return i - 1;
			end -= i;
		}
		return i - 1;
	}

	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes'
	 * values. (ie, from left to right, level by level from leaf to root).
	 * 
	 * For example: Given binary tree [3,9,20,null,null,15,7],
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
		Queue<TreeNodeLevel> queue = new LinkedList<>();
		TreeNodeLevel rootlevel = new TreeNodeLevel(root, 0);
		queue.add(rootlevel);

		while (!queue.isEmpty()) {
			TreeNodeLevel cur = queue.poll();
			if (map.get(cur.level) == null) {
				List<Integer> li = new ArrayList<>();
				li.add(cur.node.val);
				map.put(cur.level, li);
			} else {
				List<Integer> li = map.get(cur.level);
				li.add(cur.node.val);
				map.put(cur.level, li);
			}

			if (cur.node.left != null) {
				TreeNodeLevel newNode = new TreeNodeLevel(cur.node.left, cur.level + 1);
				queue.offer(newNode);
			}

			if (cur.node.right != null) {
				TreeNodeLevel newNode = new TreeNodeLevel(cur.node.right, cur.level + 1);
				queue.offer(newNode);
			}
		}

		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			list.add(map.get(it.next()));
		}

		return list;
	}

	/**
	 * Write a program to find the n-th ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		int dp[] = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		int m2 = 2;
		int m3 = 3;
		int m5 = 5;
		int next_ugly_no = 1;

		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			next_ugly_no = Math.min(m2, Math.min(m3, m5));

			dp[i] = next_ugly_no;
			if (next_ugly_no == m2) {
				i2 = i2 + 1;
				m2 = dp[i2] * 2;
			}
			if (next_ugly_no == m3) {
				i3 = i3 + 1;
				m3 = dp[i3] * 3;
			}
			if (next_ugly_no == m5) {
				i5 = i5 + 1;
				m5 = dp[i5] * 5;
			}
		}
		return next_ugly_no;
	}
}

class TreeNodeLevel {
	public TreeNodeLevel(TreeNode node, int level) {
		super();
		this.node = node;
		this.level = level;
	}

	TreeNode node;
	int level;
}

class Node {
	public Node(int i) {
		val = i;
	}

	public int val;
	public Node prev;
	public Node next;
	public Node child;
};