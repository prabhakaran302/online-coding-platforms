package com.practice.subs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Main obj = new Main();

		String strArray[] = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
				"let3 art zero" };
		System.out.println(Arrays.toString(obj.reorderLogFiles(strArray)));

		String a = "blflxll";
		System.out.println(obj.reorganizeString(a));

		a = "aa";
		String p = "*";
		System.out.println(obj.isMatch(a, p));

		int inter[][] = new int[][] { { 1, 4 }, { 4, 5 } };
		System.out.println(Arrays.deepToString(obj.merge(inter)));

		String str[] = new String[] { "bags", "baggage", "banner", "box", "cloths" };
		a = "bags";
		System.out.println(obj.suggestedProducts(str, a));

		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(obj.maxProfitSellOnce(prices));

		prices = new int[] { 1, 0, 0, 0, 0, 0 };
		obj.maxDistToClosest(prices);

		str = new String[] { "18" };
		System.out.println(obj.evalRPN(str));

		int[] sticks = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(obj.connectSticks(sticks));

		System.out.println(obj.lengthOfLongestSubstring("dvdf"));

		int[][] orange = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(obj.orangesRotting(orange));
	}

	/**
	 * 
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		// TODO: Implement
		return 0;
	}

	boolean checkAll(int arr[][], int R, int C) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	private boolean isValid(int i, int y, int row, int col) {
		return (i >= 0 && y >= 0 && i < row && y < col);
	}

	boolean isDelim(Ele temp) {
		return (temp.x == -1 && temp.y == -1);
	}

	class Ele {
		int x = 0;
		int y = 0;

		Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Ele [x=" + x + ", y=" + y + "]";
		}

	}

	/**
	 * Given an array of strings, group anagrams together.
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> li = new ArrayList<>();
		for (String st : strs) {
			char c[] = st.toCharArray();
			Arrays.parallelSort(c);
			String s = new String(c);

			if (map.containsKey(s)) {
				map.get(s).add(st);
			} else {
				List<String> l = new ArrayList<String>();
				l.add(st);
				map.put(s, l);
			}
		}

		for (Map.Entry<String, List<String>> en : map.entrySet()) {
			li.add(en.getValue());
		}

		return li;
	}

	/**
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		Set<Character> set = new LinkedHashSet<>();
		int cur = 0;
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				char ccur = s.charAt(i);
				boolean flag = true;
				Iterator<Character> it = set.iterator();
				while (flag && it.hasNext()) {
					char t = it.next();
					if (t == ccur) {
						flag = false;
					}
					it.remove();
				}
				set.add(s.charAt(i));
				cur = set.size();
			} else {
				set.add(s.charAt(i));
				cur++;
			}
			if (max < set.size())
				max = cur;
		}

		return max;
	}

	/**
	 * 
	 * @param sticks
	 * @return
	 */
	public int connectSticks(int[] sticks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : sticks)
			pq.offer(i);

		int sum = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum += a + b;
			pq.offer(a + b);
		}

		return sum;
	}

	/**
	 * Evaluate Reverse Polish Notation
	 * 
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		int res = 0;
		for (String s : tokens) {
			if (s.equalsIgnoreCase("/") || s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-")
					|| s.equalsIgnoreCase("*")) {
				int a = stack.pop();
				int b = stack.pop();
				res = getRes(a, b, s);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return res;
	}

	private int getRes(int a, int b, String s) {
		int res = 0;
		switch (s) {
		case "+":
			res = a + b;
			break;
		case "-":
			res = b - a;
			break;
		case "*":
			res = a * b;
			break;
		case "/":
			res = b / a;
			break;
		}

		return res;
	}

	/**
	 * Buy and sell Stock to maximize profit
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfitSellOnce(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int diff = prices[1] - prices[0];
		int min = prices[0];
		int n = prices.length;
		for (int i = 1; i < n; i++) {
			if (prices[i] - min > diff)
				diff = prices[i] - min;
			if (prices[i] < min)
				min = prices[i];
		}

		return diff;
	}

	/**
	 * Buy and sell Stock n no of times
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int sum = 0;
		int i = 0;
		while (i < prices.length) {
			while (i <= prices.length - 2 && prices[i] >= prices[i + 1])
				i++;
			int buy = prices[i];
			while (i < prices.length - 1 && prices[i] < prices[i + 1])
				i++;
			if (i == prices.length - 1)
				break;
			int sel = prices[i];
			sum += (sel - buy);
		}
		return sum;
	}

	/**
	 * Given an array of strings products and a string searchWord. We want to design
	 * a system that suggests at most three product names from products after each
	 * character of searchWord is typed. Suggested products should have common
	 * prefix with the searchWord. If there are more than three products with a
	 * common prefix return the three lexicographically minimums products.
	 * 
	 * @param products
	 * @param searchWord
	 * @return
	 */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> list = new ArrayList<>();
		Arrays.parallelSort(products);
		for (int i = 0; i < searchWord.length(); i++) {
			List<String> li = new ArrayList<String>();
			String str = searchWord.substring(0, i + 1);
			for (int j = 0; j < products.length; j++) {
				if (li.size() < 3 && products[j].length() > i
						&& products[j].substring(0, i + 1).equalsIgnoreCase(str)) {
					li.add(products[j]);
				} else if (li.size() >= 3) {
					break;
				} else {
					continue;
				}
			}
			list.add(li);
		}
		return list;
	}

	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {
		List<List<Integer>> list = new ArrayList<>();
		int tmp[] = null;

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0] - o2[0];
			}

		});

		int i = 0;
		while (i < intervals.length) {
			if (tmp == null) {
				tmp = intervals[i];
			} else {
				int cur[] = intervals[i];
				if (tmp[1] >= cur[0]) {
					tmp[0] = Math.min(tmp[0], cur[0]);
					tmp[1] = Math.max(tmp[1], cur[1]);
				} else {
					List<Integer> li = new ArrayList<Integer>();
					li.add(tmp[0]);
					li.add(tmp[1]);
					list.add(li);
					tmp = cur;
				}
			}
			i++;
		}

		List<Integer> li = new ArrayList<Integer>();
		li.add(tmp[0]);
		li.add(tmp[1]);
		list.add(li);

		int res[][] = new int[list.size()][2];
		int count = 0;
		for (List<Integer> curLi : list) {
			res[count][0] = curLi.get(0);
			res[count][1] = curLi.get(1);
			count++;
		}
		return res;
	}

	/**
	 * Top K frequent words
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		int[] list = new int[k];
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int str : nums) {
			if (map.get(str) != null) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		final Map<Integer, Integer> mapSort = map.entrySet().stream()
				.sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, v) -> key, LinkedHashMap::new));
		Iterator<Integer> it = mapSort.keySet().iterator();
		for (int i = 0; i < k; i++) {
			list[i] = it.next();
		}

		return list;
	}

	/**
	 * Word Pattern match - DP
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();

		boolean res[][] = new boolean[n + 1][m + 1];
		res[0][0] = true;
		for (int i = 1; i <= m; i++) {
			System.out.println(p.charAt(i - 1));
			if (p.charAt(i - 1) == '*')
				res[0][i] = res[0][i - 1];
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (p.charAt(j - 1) == '*') {
					res[i][j] = res[i - 1][j] || res[i][j - 1];
				} else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					res[i][j] = res[i - 1][j - 1];
				} else {
					res[i][j] = false;
				}
			}
		}

		return res[n][m];
	}

	/**
	 * Given a string S, check if the letters can be rearranged so that two
	 * characters that are adjacent to each other are not the same.
	 * 
	 * If possible, output any possible result. If not possible, return the empty
	 * string.
	 * 
	 * @param S
	 * @return
	 */
	public String reorganizeString(String str) {
		// TODO: try again
		return null;
	}

	/**
	 * Given a binary tree, return the sum of values of nodes with even-valued
	 * grandparent. (A grandparent of a node is the parent of its parent, if it
	 * exists.)
	 * 
	 * If there are no nodes with an even-valued grandparent, return 0.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public int sumEvenGrandparent(TreeNode root) {
		return sumEvenGrandparent(root, 0, 0);
	}

	private int sumEvenGrandparent(TreeNode root, int p, int gp) {
		if (root == null)
			return 0;
		int sum = 0;
		if (gp % 2 == 0 && gp > 0)
			sum = root.val;

		return sum + sumEvenGrandparent(root.left, root.val, p) + sumEvenGrandparent(root.right, root.val, p);
	}

	/**
	 * You have an array of logs. Each log is a space delimited string of words.
	 * 
	 * For each log, the first word in each log is an alphanumeric identifier. Then,
	 * either:
	 * 
	 * Each word after the identifier will consist only of lowercase letters, or;
	 * Each word after the identifier will consist only of digits. We will call
	 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
	 * each log has at least one word after its identifier.
	 * 
	 * Reorder the logs so that all of the letter-logs come before any digit-log.
	 * The letter-logs are ordered lexicographically ignoring identifier, with the
	 * identifier used in case of ties. The digit-logs should be put in their
	 * original order.
	 * 
	 * Return the final order of the logs.
	 * 
	 * @param logs
	 * @return
	 */
	public String[] reorderLogFiles(String[] logs) {
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char c1 = o1.split(" ")[1].charAt(0);
				char c2 = o2.split(" ")[1].charAt(0);
				if (Character.isDigit(c1) && Character.isDigit(c2)) {
					return 0;
				} else if (!Character.isDigit(c1) && Character.isDigit(c2)) {
					return -1;
				} else if (Character.isDigit(c1) && !Character.isDigit(c2)) {
					return 1;
				} else {
					String[] s1 = o1.split(" ", 2);
					String[] s2 = o2.split(" ", 2);

					int diff = s1[1].compareTo(s2[1]);
					if (diff != 0)
						return diff;
					else
						return s1[0].compareTo(s1[0]);
				}
			}

		};
		Arrays.parallelSort(logs, cmp);
		return logs;
	}

	public boolean checkRecord(String s) {
		int cA = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A')
				cA++;
			else if (s.charAt(i) == 'L' && i < s.length() - 1 && s.charAt(i + 1) == 'L') {
				return false;
			}
			if (cA > 1)
				return false;
		}
		return true;
	}

	public int maxDistToClosest(int[] seats) {
		int N = seats.length;
		int K = 0; // current longest group of empty seats
		int ans = 0;

		for (int i = 0; i < N; ++i) {
			if (seats[i] == 1) {
				K = 0;
			} else {
				K++;
				ans = Math.max(ans, (K + 1) / 2);
			}
		}

		for (int i = 0; i < N; ++i)
			if (seats[i] == 1) {
				ans = Math.max(ans, i);
				break;
			}

		for (int i = N - 1; i >= 0; --i)
			if (seats[i] == 1) {
				ans = Math.max(ans, N - 1 - i);
				break;
			}

		return ans;
	}

	public void wallsAndGates(int[][] rooms) {
		int row = rooms.length;
		int col = rooms[0].length;
		boolean[][] vistedRooms = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; i++) {
				if (rooms[i][j] == 0) {
					visitRooms(rooms, i, j, row, col, vistedRooms, 0);
				}
			}
		}
	}

	private void visitRooms(int[][] rooms, int i, int j, int row, int col, boolean[][] vistedRooms, int dist) {
		if (i < 0 || i >= row || j < 0 || j >= col) {
			return;
		}
		if (vistedRooms[i][j]) {
			return;
		}
		if (rooms[i][j] == -1) {
			return;
		}
		if (dist > rooms[i][j]) {
			return;
		}
		vistedRooms[i][j] = true;

		if (dist < rooms[i][j]) {
			rooms[i][j] = dist;
		}

		visitRooms(rooms, i - 1, j, row, col, vistedRooms, dist + 1);
		visitRooms(rooms, i + 1, j, row, col, vistedRooms, dist + 1);
		visitRooms(rooms, i, j - 1, row, col, vistedRooms, dist + 1);
		visitRooms(rooms, i, j + 1, row, col, vistedRooms, dist + 1);

		vistedRooms[i][j] = false;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
