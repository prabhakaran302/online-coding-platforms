package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class WordBreakProblem {
	/**
	 * Backtracking solution
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0) {
			return true;
		} else {
			for (int i = 1; i <= s.length(); i++) {
				String prefix = s.substring(0, i);
				if (wordDict.contains(prefix) && wordBreak(s.substring(i), wordDict))
					return true;
			}
		}
		return false;
	}

	public boolean wordBreakIterative(String s, List<String> wordDict) {
		int[] array = new int[s.length() + 1];
		Arrays.fill(array, -1);

		array[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1) {
				for (int j = i + 1; j < array.length; j++) {
					if (wordDict.contains(s.substring(i, j))) {
						array[j] = i;
					}
				}
			}
		}
		System.out.println(Arrays.toString(array));
		return array[s.length()] != -1;
	}

	public void wordBreak(String s, List<String> wordDict, String out) {
		if (s.length() == 0) {
			System.out.println(out);
			return;
		} else {
			for (int i = 1; i <= s.length(); i++) {
				String prefix = s.substring(0, i);
				if (wordDict.contains(prefix)) {
					String str = s.substring(i);
					wordBreak(str, wordDict, out + " " + prefix);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("dog");

		String s = "catsanddog";

		WordBreakProblem obj = new WordBreakProblem();
		obj.wordBreakIterative(s, wordDict);
	}
}
