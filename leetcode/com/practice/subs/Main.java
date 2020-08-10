package com.practice.subs;

import java.util.*;
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
