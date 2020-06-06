package com.codezen.recursion;

public class DynamicProb {
	public static void main(String[] args) {
		int problemCount = 0;

		String s1 = "abc";
		String s2 = "dc";
		System.out.println("Problem " + ++problemCount + " Name: >>  Edit Minimum Distance (  " + s1 + " , " + s2
				+ " ) is " + editDistance(s1, s2));

		int[] weight = new int[] { 10, 20, 30 };
		int[] value = new int[] { 60, 100, 120 };
		int maxWeight = 50;
		System.out.println("Problem " + ++problemCount
				+ " Name: >>  Knapsack Max weight  ************ (Codezen Some cases fails) ************ "
				+ knapsack(weight, value, maxWeight));

		value = new int[] { 1, 4, 3, 4 };
		System.out.println("Problem " + ++problemCount + " Name: >>  Max Subsegment if one change allowed "
				+ solve(value, value.length));

		value = new int[] { 10, 15, 20, 25 };
		System.out.println("Problem " + ++problemCount
				+ " Name: >>  Cost of Matrix Multiplication  ************ (Pending)  ************ " + mcm(value));

		System.out.println("Problem " + ++problemCount + " Name: >>  No. of ways to paint fence " + paintFences(3));

		s1 = "adebc";
		s2 = "dcadb";
		System.out.println(
				"Problem " + ++problemCount + " Name: >>  LCS (  " + s1 + " , " + s2 + "  ) is " + lcs(s1, s2));

		int n = 10;
		System.out.println("Problem " + ++problemCount + " Name: >>  Minimum Steps to reach 1 from " + n + " is >> "
				+ countStepsTo1(n));

		n = 10;
		System.out.println("Problem " + ++problemCount + " Name: >>  No of ways to climb stairs of steps " + n
				+ " is >> " + staircase(n));

	}

	/**
	 * A child is running up a staircase with N steps, and can hop either 1 step, 2
	 * steps or 3 steps at a time. Implement a method to count how many possible
	 * ways the child can run up to the stairs. You need to return number of
	 * possible ways W.
	 * 
	 * @param n
	 * @return
	 */
	public static int staircase(int n) {
		return 0;
	}

	/**
	 * Given a positive integer n, find the minimum number of steps s, that takes n
	 * to 1. You can perform any one of the following 3 steps.
	 * 
	 * @param n
	 * @return
	 */
	public static int countStepsTo1(int n) {
		int[] dp = new int[n + 1];
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			if (i % 3 == 0) {
				dp[i] = dp[i / 3] + 1;
			} else if (i % 2 == 0 && i % 3 != 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}
		// System.out.println(Arrays.toString(dp));
		return dp[n];

	}

	/**
	 * Given 2 strings of S1 and S2 with lengths m and n respectively, find the
	 * length of longest common subsequence.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int lcs(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	/**
	 * Write an algorithm that counts - the number of ways you can paint a fence
	 * with N posts using 2 colors such that no more than 2 adjacent fence posts are
	 * painted with the same color.
	 * 
	 * @param n
	 * @return
	 */
	public static int paintFences(int n) {
		int first = 2;
		int second = 4;

		int mod = 1000000007;

		for (int i = 3; i <= n; i++) {
			int temp = first % mod;
			first = second % mod;
			second = second % mod + temp % mod;
		}
		return second % mod;
	}

	/**
	 * Matrix Chain Multiplication
	 * 
	 * @param p
	 * @return
	 */
	public static int mcm(int[] p) {
		int result = 1;
		int dp[][] = new int[p.length - 1][p.length - 1];

		// TODO: Complete Code

		for (int l = 0; l < p.length - 1; l++) {

		}

		// DynamicProbUtil.printArray(dp);
		return result;
	}

	/**
	 * Your task is to find the longest subsegment of a, such that it is possible to
	 * change at most one number (change one number to any integer you want) from
	 * the subsegment to make the subsegment strictly increasing. You need to return
	 * the length of the maximum subsegment that you can find by changing only one
	 * integer in the given sequence
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	public static int solve(int[] a, int n) {
		int ans = 0;
		int l[] = new int[a.length];
		l[0] = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] < a[i]) {
				l[i] = l[i - 1] + 1;
			} else {
				l[i] = 1;
			}
		}
		int r[] = new int[a.length];
		r[r.length - 1] = 1;
		for (int i = a.length - 2; i > 0; i--) {
			if (a[i + 1] > a[i]) {
				r[i] = r[i + 1] + 1;
			} else {
				r[i] = 1;
			}
		}
		for (int i = a.length - 2; i > 0; i--) {
			if (a[i + 1] - a[i - 1] > 1) {
				ans = Math.max(ans, l[i - 1] + r[i + 1] + 1);
			}
		}
		return ans;
	}

	/**
	 * A thief robbing a store and can carry a maximal weight of W into his
	 * knapsack. There are N items and ith item weigh wi and is of value vi. What is
	 * the maximum value V, that thief can take ?
	 * 
	 * @param weight
	 * @param value
	 * @param maxWeight
	 * @return
	 */
	public static int knapsack(int[] weight, int value[], int maxWeight) {
		int[][] dp = new int[weight.length + 1][maxWeight + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (weight[i - 1] <= j) {
					dp[i][j] = Math.max((value[i - 1] + dp[i - 1][j - weight[i - 1]]), dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[weight.length][maxWeight];
	}

	/**
	 * Given two strings s and t of lengths m and n respectively, find the Edit
	 * Distance between the strings. Edit Distance of two strings is minimum number
	 * of steps required to make one string equal to other. In order to do so you
	 * can perform following three operations only :
	 * 
	 * 1. Delete a character
	 * 
	 * 2. Replace a character with another one
	 * 
	 * 3. Insert a character
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int editDistance(String s1, String s2) {
		int mat[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0) {
					mat[i][j] = j;
				} else if (j == 0) {
					mat[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1];
				} else {
					mat[i][j] = Math.min(mat[i - 1][j], Math.min(mat[i][j - 1], mat[i - 1][j - 1])) + 1;
				}
			}
		}
		return mat[s1.length()][s2.length()];
	}

	static class DynamicProbUtil {
		@SuppressWarnings("unused")
		private static void printArray(int[][] dp) {
			for (int i = 0; i < dp.length; i++) {
				System.out.println();
				for (int j = 0; j < dp[0].length; j++) {
					System.out.print(dp[i][j] + " ");
				}
			}
		}
	}
}
