package com.dcp;

/**
 * Given an integer k and a string s, find the length of the longest substring
 * that contains at most k distinct characters
 * 
 * @author prabhakaran.nivanil
 *
 */
public class LongestSubStringKUniqueCharacters {
	final static int MAX_CHARS = 26;

	static public void main(String[] args) {
		String s = "abccddcddcbaabb";
		int k = 2;
		kUniques(s, k);
	}

	static boolean isValid(int count[], int k) {
		int val = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] >= 1)
				val++;
		}
		return k >= val;
	}

	static void kUniques(String s, int k) {
		if (s == null || s.length() < 1)
			return;

		int max_substring_len = 1;

		int start_at = 0;
		int end_at = 0;

		int[] count = new int[MAX_CHARS];
		count[s.charAt(0) - 'a'] = 1;

		for (int i = 1; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;

			while (!isValid(count, k)) {
				count[s.charAt(start_at) - 'a']--;
				start_at++;
			}

			end_at++;

			if (end_at - start_at + 1 > max_substring_len) {
				max_substring_len = end_at - start_at + 1;
			}

		}

		System.out.println("Max Substring with K distinct characters " + max_substring_len);
	}
}
