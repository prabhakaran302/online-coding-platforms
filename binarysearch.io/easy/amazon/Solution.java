package easy.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] moves = new String[] { "EAST" };
		int x = 1;
		int y = 0;
		System.out.println(sol.solve(moves, x, y));
		System.out.println("###############################\n");

		String text = "";
		System.out.println(sol.solveDogCat(text, "ludicrous", "injure"));
		System.out.println("###############################\n");

		System.out.println(sol.solveAnagram("listen", "silent"));
		System.out.println("###############################\n");

		int[] nums = new int[] { -9, -2, 0, 2, 3 };
		System.out.println(Arrays.toString(sol.sortSquares(nums)));
		System.out.println("###############################\n");

		nums = new int[] { 908, 908, 273, 268, 910, 445, 68, 1007, 197, 566, 512, 323, 100 };
		System.out.println((sol.buySellStock(nums)));
		System.out.println("###############################\n");

		System.out.println(Arrays.toString(sol.pascal(3)));
		System.out.println("###############################\n");

		System.out.println((sol.solveCocoKaka("cat", "foo")));
		System.out.println("###############################\n");

		String arr[] = new String[] { "anthony", "ant", "antigravity" };
		System.out.println(sol.solveLongestCommonPrefix(arr));
		System.out.println("###############################\n");

		System.out.println(sol.solveRunLengthEncoding("AAAABBBCCDAA"));
		System.out.println("###############################\n");

		System.out.println(sol.solveAncientAstronautTheory("jugm", "xuaccfikwwjyz"));
		System.out.println("###############################\n");

		System.out.println(sol.solveRepeatingString("abcdabcdabcdabcdabcd"));
		System.out.println("###############################\n");

	}

	/**
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * @param node
	 * @param target
	 * @return
	 */
	public LLNode solve(LLNode node, int target) {
		LLNode head = node;
		while (head != null && head.val == target)
			head = head.next;

		LLNode current = head;
		LLNode prev = head;

		while (current != null) {
			if (current.val == target) {
				prev.next = current.next;
			} else {
				prev = current;
			}
			current = current.next;
		}
		return head;
	}

	/**
	 * Given a string s, return whether it's a repeating string.
	 * 
	 * @param s
	 * @return
	 */
	public boolean solveRepeatingString(String s) {
		int[] lps = computeLPSArray(s);
		int n = s.length();
		int longPrefSuf = lps[n - 1];

		return (longPrefSuf > 0 && (n % (n - longPrefSuf)) == 0) ? true : false;
	}

	private int[] computeLPSArray(String s) {
		int[] lps = new int[s.length()];
		lps[0] = 0;
		int i = 1;
		int j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				lps[i] = 0;
				if (j > 0)
					j = lps[j - 1];
				else {
					i++;
				}

			}
		}
		return lps;
	}

	/**
	 * You are given a string dictionary, representing a partial lexicographic
	 * ordering of ancient astronauts' dictionary. Given a string s, return whether
	 * it's a lexicographically sorted string according to this ancient astronaut
	 * dictionary.
	 * 
	 * @param dictionary
	 * @param s
	 * @return
	 */
	public boolean solveAncientAstronautTheory(String dictionary, String s) {

		int order = 0;
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < dictionary.length(); i++) {
			map.put(dictionary.charAt(i), order++);
		}

		Map<Character, Integer> mapS = new LinkedHashMap<>();
		int index = 0;
		int sOrder = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ' && map.get(c) != null) {
				if (!mapS.containsKey(c)) {
					if (map.get(c) < sOrder)
						return false;
					mapS.put(c, index++);
					sOrder = map.get(c);
				} else {
					if (map.get(c) < sOrder)
						return false;
				}
			}
		}

		return true;
	}

	/**
	 * Run-length encoding is a fast and simple method of encoding strings. The
	 * basic idea is to represent repeated successive characters as a single count
	 * and character. For example, the string "AAAABBBCCDAA" would be encoded as
	 * "4A3B2C1D2A".
	 * 
	 * @param nums
	 * @return
	 */
	public String solveRunLengthEncoding(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char c = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (c == s.charAt(i)) {
				count++;
			} else {
				sb.append(count);
				sb.append(c);
				c = s.charAt(i);
				count = 0;
				i--;
			}
		}
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}

	/**
	 * Given a list of lowercase alphabet strings words, return the longest common
	 * prefix.
	 * 
	 * 
	 * @param words
	 * @return
	 */
	public String solveLongestCommonPrefix(String[] words) {
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		int index = 0;
		char c = 0;
		while (flag) {
			if (words[0].length() > index) {
				c = words[0].charAt(index);
			} else {
				flag = false;
				break;
			}
			for (int i = 0; i < words.length; i++) {
				if (words[i].length() > index && c != words[i].charAt(index)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				index++;
				sb.append(c);
			}

		}
		return sb.toString();
	}

	/**
	 * Given lowercase alphabet strings s, and t return whether you can create a
	 * 1-to-1 mapping for each letter in s to another letter (could be the same
	 * letter) such that s could be mapped to t, with the ordering of characters
	 * preserved.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean solveCocoKaka(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> mapS = new HashMap<>();
		Map<Character, Character> mapT = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (mapS.containsKey(s.charAt(i))) {
				if (t.charAt(i) != mapS.get(s.charAt(i)))
					return false;
			} else if (mapT.containsKey(t.charAt(i))) {
				if (s.charAt(i) != mapT.get(t.charAt(i)))
					return false;
			} else {
				mapS.put(s.charAt(i), t.charAt(i));
				mapT.put(t.charAt(i), s.charAt(i));
			}
		}
		return true;
	}

	/**
	 * Given an integer n, return the nth (0-indexed) row of Pascal's triangle.
	 * 
	 * Pascal's triangle can be created as follows: In the top row, there is an
	 * array of 1. Subsequent row is created by adding the number above and to the
	 * left with the number above and to the right, treating empty elements as 0.
	 * 
	 * @param n
	 * @return
	 */
	public int[] pascal(int n) {
		int res[] = new int[n + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = findPascalVal(n, i);
		}
		return res;
	}

	private int findPascalVal(int n, int i) {
		if (i == 0 || n == 0)
			return 1;
		else if (i == n)
			return 1;
		else {
			return findPascalVal(n - 1, i) + findPascalVal(n - 1, i - 1);
		}
	}

	/**
	 * Given a list of integers prices representing the stock prices of a company in
	 * chronological order, return the maximum profit you could have made from
	 * buying and selling that stock any number of times.
	 * 
	 * You must buy before you can sell it.
	 * 
	 * Note: You are not required to buy or sell the stock.
	 * 
	 * @param prices
	 * @return
	 */
	public int buySellStock(int[] prices) {
		int ans = 0;
		int n = prices.length;
		int start = 0;
		while (start < n - 1) {
			while (start < n - 1 && prices[start] >= prices[start + 1]) {
				start++;
			}
			int buy = prices[start];
			while (start < n - 1 && prices[start] < prices[start + 1]) {
				start++;
			}
			int sell = prices[start];
			ans += (sell - buy);
		}
		return ans;
	}

	/**
	 * Given a sorted list of integers, square the elements and give the output in
	 * sorted order.
	 * 
	 * Note: The integers can be 0 or negative.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] sortSquares(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];

		int k = 0;
		for (k = 0; k < n; k++)
			if (nums[k] >= 0)
				break;

		int neg = k - 1;
		int pos = k;
		int ind = 0;

		while (pos < n && neg >= 0) {
			if (pos < n && nums[pos] * nums[pos] <= nums[neg] * nums[neg]) {
				res[ind++] = nums[pos] * nums[pos];
				pos++;
			} else if (neg >= 0 && nums[pos] * nums[pos] > nums[neg] * nums[neg]) {
				res[ind++] = nums[neg] * nums[neg];
				neg--;
			}
		}

		while (pos < n) {
			res[ind++] = nums[pos] * nums[pos];
			pos++;
		}
		while (neg >= 0) {
			res[ind++] = nums[neg] * nums[neg];
			neg--;
		}

		return res;
	}

	/**
	 * Given two strings s0 and s1, return whether they are anagrams of each other.
	 * Two words are anagrams when you can rearrange one to become the other. For
	 * example, "listen" and "silent" are anagrams.
	 * 
	 * @param s0
	 * @param s1
	 * @return
	 */
	public boolean solveAnagram(String s0, String s1) {
		if (s0.length() != s1.length())
			return false;

		int count1[] = new int[256];
		Arrays.fill(count1, 0);
		int count2[] = new int[256];
		Arrays.fill(count2, 0);
		int i;
		for (i = 0; i < s0.length() && i < s1.length(); i++) {
			count1[s0.charAt(i)]++;
			count2[s1.charAt(i)]++;
		}

		for (i = 0; i < 256; i++)
			if (count1[i] != count2[i])
				return false;

		return true;
	}

	/**
	 * Given an integer n, return a list of integers from 1 to n as strings except
	 * for multiples of 3 use “Fizz” instead of the integer and for the multiples of
	 * 5 use “Buzz”. For integers which are multiples of both 3 and 5 use
	 * “FizzBuzz”.
	 * 
	 * @param n
	 * @return
	 */
	public String[] solveFizzBuzz(int n) {
		String[] res = new String[n];
		for (int i = 1; i <= n; i++) {
			String va;
			if (i % 3 == 0 && i % 5 == 0) {
				va = "FizzBuzz";
			} else if (i % 3 == 0) {
				va = "Fizz";
			} else if (i % 5 == 0) {
				va = "Buzz";
			} else {
				va = String.valueOf(i);
			}
			res[i - 1] = va;
		}
		return res;
	}

	/**
	 * Given the strings text, word0, and word1, return the smallest distance
	 * between any two occurrences of word0 and word1 in text, measured in number of
	 * words. If either word0 or word1 doesn't appear in text, return -1.
	 * 
	 * @param text
	 * @param word0
	 * @param word1
	 * @return
	 */
	public int solveDogCat(String text, String word0, String word1) {

		boolean searhWord0 = false;
		boolean searhWord1 = false;

		String[] textArray = text.split(" ");
		int start = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < textArray.length; i++) {
			String cur = textArray[i];
			if (cur.equalsIgnoreCase(word0) && searhWord1) {
				int dis = i - start - 1;
				if (min > dis)
					min = dis;
				start = i;
				searhWord0 = true;
				searhWord1 = false;
			} else if (cur.equalsIgnoreCase(word0)) {
				start = i;
				searhWord0 = true;
			}

			if (cur.equalsIgnoreCase(word1) && searhWord0) {
				int dis = i - start - 1;
				if (min > dis)
					min = dis;
				start = i;
				searhWord1 = true;
				searhWord0 = false;
			} else if (cur.equalsIgnoreCase(word1)) {
				start = i;
				searhWord1 = true;
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	/**
	 * A Roomba robot is currently sitting in a cartesian plane at (0, 0). You are
	 * given a list of its moves that it will make, containing NORTH, SOUTH, WEST,
	 * and EAST.
	 * 
	 * Return whether after its moves it will end up in the coordinate (x, y).
	 * 
	 * @param moves
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean solve(String[] moves, int x, int y) {
		int s = 0;
		int e = 0;
		for (String cur : moves) {
			switch (cur) {
			case "EAST":
				e++;
				break;
			case "WEST":
				e--;
				break;
			case "NORTH":
				s++;
				break;
			case "SOUTH":
				s--;
				break;
			}
		}

		return e == x && y == s;
	}
}

class AVLNode {
	AVLNode left;
	AVLNode right;

	int value;
	int count;
	int numLeft;

	public AVLNode(int value) {
		this.value = value;
	}
}

class LLNode {
	int val;
	LLNode next;
}