package com.dcp;

public class MinimumInsertionsToMakeStringPalindrome {
	public int minInsertions(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0, k = i; k < s.length(); k++, j++) {
				if (s.charAt(j) == s.charAt(k)) {
					dp[j][k] = dp[j + 1][k - 1];
				} else {
					dp[j][k] = Math.min(dp[j + 1][k], dp[j][k - 1]) + 1;
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}
