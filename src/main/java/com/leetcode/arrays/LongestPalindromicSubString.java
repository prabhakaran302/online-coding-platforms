package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class LongestPalindromicSubString {
	/**
	 * O(n2) Solution , O(n) solution is available in form of Manacher's Algorithm
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {

		if (s == null || s.length() <= 1)
			return s;

		int len = s.length();

		int start = 0;
		int maxLength = 1;

		for (int i = 1; i < s.length(); i++) {
			int low = i - 1;
			int high = i;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if (maxLength < high - low + 1) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if (maxLength < high - low + 1) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}
		}

		return getPalindromicString(s, start, maxLength);
	}

	private String getPalindromicString(String s, int start, int maxLength) {
		return s.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
		System.out.println(longestPalindromicSubString.longestPalindrome("ac"));
	}
}
