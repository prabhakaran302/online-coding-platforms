package com.practice.thirtydays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.practice.easy.util.ListNode;
import com.practice.easy.util.TreeNode;
import com.practice.easy.util.Utils;

/**
 * https://leetcode.com/problemset/30-day-challenge/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class ThirtyDaysProblems {
	public static void main(String[] args) {
		ThirtyDaysProblems obj = new ThirtyDaysProblems();

		int[] stones = new int[] { 2, 2 };
		System.out.println(obj.lastStoneWeight(stones));
		System.out.println("\n***************************\n");

		int[] nums = new int[] { 0, 1 };
		obj.moveZeroes(nums);
		System.out.println("\n***************************\n");

		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(obj.maxProfit(prices));
		System.out.println("\n***************************\n");

		TreeNode root = new TreeNode(2);
		System.out.println(obj.diameterOfBinaryTree(root));
		System.out.println("\n***************************\n");

		String S = "xywrrmp";
		String T = "xywrrmu#p";
		System.out.println(obj.backspaceCompare(S, T));
		System.out.println("\n***************************\n");

		MinStack min = new MinStack();
		min.push(2147483646);
		min.push(2147483646);
		min.push(2147483647);
		System.out.println(min.top());
		min.pop();
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
		min.pop();
		min.push(2147483647);
		System.out.println(min.top());
		System.out.println(min.getMin());
		min.push(-2147483648);
		System.out.println(min.top());
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
		System.out.println("\n***************************\n");

		int[] preorder = new int[] { 4, 2 };
		root = obj.bstFromPreorder(preorder);
		Utils.preOrder(root);
		System.out.println("\n***************************\n");

		nums = new int[] { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
		System.out.println("\n***************************\n");

		S = "bl";
		T = "yby";
		System.out.println(obj.longestCommonSubsequence(S, T));
		System.out.println("\n***************************\n");

		System.out.println(obj.checkValidString(")("));
		System.out.println("\n***************************\n");

		root = new TreeNode(-10);
		System.out.println(obj.maxPathSum(root));
		System.out.println("\n***************************\n");

		nums = new int[] { 3, 1 };
		System.out.println(obj.search(nums, 1));
		System.out.println("\n***************************\n");

		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));

		System.out.println("\n***************************\n");

		char[][] matrix = new char[][] { { '1' } };
		System.out.println(obj.maximalSquare(matrix));
		System.out.println("\n***************************\n");
	}

	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	/**
	 * We have a collection of stones, each stone has a positive integer weight.
	 * 
	 * Each turn, we choose the two heaviest stones and smash them together. Suppose
	 * the stones have weights x and y with x <= y. The result of this smash is:
	 * 
	 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
	 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
	 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
	 * there are no stones left.)
	 * 
	 * 
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight(int[] stones) {
		Queue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int i : stones)
			que.offer(i);

		while (!que.isEmpty() && que.size() > 1) {
			int f = que.poll();
			int s = que.poll();

			if (!(f == s)) {
				que.offer(Math.abs(f - s));
			} else {
				que.offer(0);
			}
		}

		return que.poll();
	}

	/**
	 * Given an array nums, write a function to move all 0's to the end of it while
	 * maintaining the relative order of the non-zero elements.
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int index = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}
		for (int i = index; i < n; i++)
			nums[i] = 0;
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (i.e., buy one and sell one share of the stock
	 * multiple times).
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int sum = 0;

		int buy = -1;
		int sell = -1;

		for (int i = 0; i < prices.length; i++) {
			while (i < prices.length - 1 && prices[i] > prices[i + 1])
				i++;

			buy = i;

			while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
				i++;
			}
			sell = i;
			sum = sum + (prices[sell] - prices[buy]);
		}
		return sum;
	}

	/**
	 * Given a binary tree, you need to compute the length of the diameter of the
	 * tree. The diameter of a binary tree is the length of the longest path between
	 * any two nodes in a tree. This path may or may not pass through the root.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameterOfBinaryTree(root.left);
		int rd = diameterOfBinaryTree(root.right);

		return Math.max(lh + rh, Math.max(ld, rd));
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);

		return Math.max(lh, rh) + 1;
	}

	/**
	 * Given two strings S and T, return if they are equal when both are typed into
	 * empty text editors. # means a backspace character.
	 * 
	 * Note that after backspacing an empty text, the text will continue empty.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public boolean backspaceCompare(String S, String T) {
		int sLength = S.length() - 1;
		int tLength = T.length() - 1;

		while (sLength >= 0 || tLength >= 0) {
			int countS = 0;
			while (sLength >= 0 && (countS > 0 || S.charAt(sLength) == '#')) {
				if (S.charAt(sLength) == '#') {
					countS++;
				} else {
					countS--;
				}

				sLength--;
			}

			int countT = 0;
			while (tLength >= 0 && (countT > 0 || T.charAt(tLength) == '#')) {
				if (T.charAt(tLength) == '#') {
					countT++;
				} else {
					countT--;
				}

				tLength--;
			}

			if (sLength >= 0 && tLength >= 0) {
				if (S.charAt(sLength) != T.charAt(tLength)) {
					return false;
				} else {
					sLength--;
					tLength--;
				}
			} else {
				if (sLength >= 0 || tLength >= 0) {
					return false;
				}
			}
		}

		return sLength < 0 && tLength < 0;
	}

	/**
	 * Given an integer array nums, find the contiguous subarray (containing at
	 * least one number) which has the largest sum and return its sum.
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length < 1)
			return 0;
		int sum_so_far = nums[0];
		int max_sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum_so_far = Math.max(sum_so_far + nums[i], nums[i]);
			max_sum = Math.max(sum_so_far, max_sum);
		}

		return max_sum;
	}

	/**
	 * Return the root node of a binary search tree that matches the given preorder
	 * traversal.
	 * 
	 * (Recall that a binary search tree is a binary tree where for every node, any
	 * descendant of node.left has a value < node.val, and any descendant of
	 * node.right has a value > node.val. Also recall that a preorder traversal
	 * displays the value of the node first, then traverses node.left, then
	 * traverses node.right.)
	 * 
	 * It's guaranteed that for the given test cases there is always possible to
	 * find a binary search tree with the given requirements.
	 * 
	 * @param preorder
	 * @return
	 */
	public TreeNode bstFromPreorder(int[] preorder) {
		Index index = new Index();
		return bstFromPreorderUtil(preorder, index, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode bstFromPreorderUtil(int[] preorder, Index index, int key, int minValue, int maxValue) {
		if (index.index >= preorder.length) {
			return null;
		}
		TreeNode root = null;
		if (key > minValue && key < maxValue) {
			index.index = index.index + 1;
			root = new TreeNode(key);

			if (index.index < preorder.length) {
				root.left = bstFromPreorderUtil(preorder, index, preorder[index.index], minValue, key);
			}

			if (index.index < preorder.length) {
				root.right = bstFromPreorderUtil(preorder, index, preorder[index.index], key, maxValue);
			}
		}

		return root;
	}

	class Index {
		int index = 0;
	}

	/**
	 * Given an array nums of n integers where n > 1, return an array output such
	 * that output[i] is equal to the product of all the elements of nums except
	 * nums[i].
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int left[] = new int[nums.length];
		left[0] = 1;
		int prod = 1;
		for (int i = 1; i < nums.length; i++) {
			prod = prod * nums[i - 1];
			left[i] = prod;
		}

		int right = nums[left.length - 1];
		for (int i = left.length - 2; i >= 0; i--) {
			left[i] = right * left[i];
			right = right * nums[i];
		}

		return left;
	}

	/**
	 * Given two strings text1 and text2, return the length of their longest common
	 * subsequence.
	 * 
	 * A subsequence of a string is a new string generated from the original string
	 * with some characters(can be none) deleted without changing the relative order
	 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
	 * "aec" is not). A common subsequence of two strings is a subsequence that is
	 * common to both strings.
	 * 
	 * 
	 * 
	 * If there is no common subsequence, return 0.
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[m][n];
	}

	/**
	 * Given an array of strings, group anagrams together.
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char c[] = str.toCharArray();
			Arrays.parallelSort(c);
			String key = String.valueOf(c);
			if (map.get(key) == null) {
				List<String> li = new ArrayList<String>();
				li.add(str);
				map.put(key, li);
			} else {
				map.get(key).add(str);
			}
		}

		list.addAll(map.values());

		return list;
	}

	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its path.
	 * 
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else if (i == 0 || j == 0) {
					if (i == 0) {
						grid[i][j] = grid[i][j] + grid[i][j - 1];
					} else {
						grid[i][j] = grid[i][j] + grid[i - 1][j];
					}
				} else {
					grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
				}
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}

	/**
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges of
	 * the grid are all surrounded by water.
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length < 1)
			return 0;
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[0].length; ++j)
				if (grid[i][j] == '1' && !visited[i][j]) {
					DFS(grid, i, j, visited);
					++count;
				}

		return count;
	}

	private boolean isSafe(char[][] grid, int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length)
				&& (grid[row][col] == '1' && !visited[row][col]);
	}

	private void DFS(char[][] grid, int row, int col, boolean visited[][]) {
		int rowNbr[] = new int[] { -1, 1, 0, 0 };
		int colNbr[] = new int[] { 0, 0, -1, 1 };

		visited[row][col] = true;

		for (int k = 0; k < 4; ++k)
			if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited))
				DFS(grid, row + rowNbr[k], col + colNbr[k], visited);
	}

	/**
	 * Given a string containing only three types of characters: '(', ')' and '*',
	 * write a function to check whether this string is valid. We define the
	 * validity of a string by these rules:
	 * 
	 * <p>
	 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	 * <p>
	 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
	 * <p>
	 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	 * <p>
	 * '*' could be treated as a single right parenthesis ')' or a single left
	 * parenthesis '(' or an empty string.
	 * <p>
	 * An empty string is also valid.
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {
		int openBr = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
				openBr++;
			else
				openBr--;

			if (openBr < 0)
				return false;
		}
		if (openBr == 0)
			return true;
		int closeBr = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
				closeBr++;
			else
				closeBr--;

			if (closeBr < 0)
				return false;
		}
		return true;
	}

	/**
	 * Given a non-empty binary tree, find the maximum path sum.
	 * 
	 * For this problem, a path is defined as any sequence of nodes from some
	 * starting node to any node in the tree along the parent-child connections. The
	 * path must contain at least one node and does not need to go through the root.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		Res res = new Res();
		maxPathSum(root, res);
		return res.max;
	}

	private int maxPathSum(TreeNode root, Res res) {
		if (root == null)
			return 0;

		int l = maxPathSum(root.left, res);
		int r = maxPathSum(root.right, res);

		int nodeD = Math.max(Math.max(l, r) + root.val, root.val);
		int allPath = Math.max(nodeD, l + r + root.val);

		res.max = Math.max(res.max, allPath);
		return nodeD;
	}

	class Res {
		int max = Integer.MIN_VALUE;
	}

	/**
	 * Given an array of integers and an integer k, you need to find the total
	 * number of continuous subarrays whose sum equals to k.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k)
				count++;

			if (map.get(sum - k) != null) {
				count += map.get(sum - k);
			}

			if (map.get(sum) == null) {
				map.put(sum, 1);
			} else {
				map.put(sum, map.get(sum) + 1);
			}
		}
		return count;
	}

	/**
	 * Given a binary array, find the maximum length of a contiguous subarray with
	 * equal number of 0 and 1.
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxLength(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == 0) {
				max = i + 1;
			}
			if (map.get(sum) == null) {
				map.put(sum, i);
			} else {
				if (max < i - map.get(sum))
					max = i - map.get(sum);
			}
		}

		return max;
	}

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown
	 * to you beforehand.
	 * 
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		return searchUtil(nums, 0, nums.length - 1, target);
	}

	public int searchUtil(int[] nums, int low, int high, int target) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;

		if (nums[mid] == target)
			return mid;

		if (nums[low] <= nums[mid]) {
			if (target >= nums[low] && target <= nums[mid]) {
				return searchUtil(nums, low, mid - 1, target);
			} else {
				return searchUtil(nums, mid + 1, high, target);
			}
		} else {
			if (target >= nums[mid] && target <= nums[high]) {
				return searchUtil(nums, mid + 1, high, target);
			} else {
				return searchUtil(nums, low, mid - 1, target);
			}
		}
	}

	/**
	 * Given an array of non-negative integers, you are initially positioned at the
	 * first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if (nums.length <= 1)
			return true;
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (max <= i && nums[i] == 0)
				return false;

			if (max < i + nums[i])
				max = i + nums[i];

			if (max >= nums.length - 1)
				return true;
		}
		return false;
	}

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
	 * containing only 1's and return its area.
	 * 
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length < 1)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (matrix[i - 1][j - 1] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
				}

				if (max < dp[i][j])
					max = dp[i][j];
			}
		}

		return max;
	}
}

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * <p>
 * push(x) -- Push element x onto stack.
 * </p>
 * <p>
 * pop() -- Removes the element on top of the stack.
 * </p>
 * top() -- Get the top element.
 * 
 * <p>
 * getMin() -- Retrieve the minimum element in the stack.
 * </p>
 * 
 * @author prabhakaran.nivanil
 *
 */
class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		int min = Math.min(getMin(), x);
		minStack.push(min);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			minStack.pop();
			stack.pop();
		}
	}

	public int top() {
		if (!stack.isEmpty())
			return stack.peek();
		return -1;
	}

	public int getMin() {
		if (!minStack.isEmpty())
			return minStack.peek();
		return Integer.MAX_VALUE;
	}
}

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * <p>
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * @author prabhakaran.nivanil
 *
 */
class LRUCache {
	int size;

	Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		size = capacity;
		map = new LinkedHashMap<Integer, Integer>();
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		int val = map.remove(key);
		map.put(key, val);
		return val;
	}

	public void put(int key, int value) {
		if (map.containsKey(key))
			map.remove(key);

		else if (map.size() == size) {
			int firstKey = map.keySet().iterator().next();
			map.remove(firstKey);
		}

		map.put(key, value);
	}
}
