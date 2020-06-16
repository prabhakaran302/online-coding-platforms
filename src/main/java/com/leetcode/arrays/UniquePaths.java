package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * @author prabhakaran.nivanil
 *
 */

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths paths = new UniquePaths();
		int m = 3;
		int n = 2;
		System.out.println(paths.uniquePaths(m, n));
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		printArray(dp);
		return dp[m - 1][n - 1];
	}

	private void printArray(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "                ");
			}
			System.out.println();
		}
	}
}
