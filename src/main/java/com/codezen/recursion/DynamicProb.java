package com.codezen.recursion;

public class DynamicProb {
	public static void main(String[] args) {
		String s1 = "abcpq";
		String s2 = "adcq";
		System.out.println("Edit Minimum Distance (  " + s1 + " , " + s2 + " ) is " + editDistance(s1, s2));

		int[] weight = new int[] { 10,20,30 };
		int[] value = new int[] { 60,100,120 };
		int maxWeight = 50;
		System.out.println("Knapsack Max weight " + knapsack(weight, value, maxWeight));

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

	private static void printArray(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			System.out.println();
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
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
				if (i == 0 || j == 0) {
					mat[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1];
				} else {
					mat[i][j] = Math.min(mat[i - 1][j], Math.min(mat[i][j - 1], mat[i - 1][j - 1])) + 1;
				}
			}
		}
		return mat[s1.length()][s2.length()];
	}
}
