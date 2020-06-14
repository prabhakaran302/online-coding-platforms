package com.dcp;

/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SubSetSumProblem {
	public static void main(String[] args) {
		SubSetSumProblem setSumProblem = new SubSetSumProblem();

		int[] nums = new int[] { 2, 2, 3, 5 };
		boolean value = setSumProblem.canPartition(nums);
		System.out.println(value);
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i : nums)
			sum += i;

		if (sum % 2 != 0)
			return false;

		System.out.println(sum);

		int n = nums.length;

		boolean[][] dp = new boolean[n + 1][sum / 2 + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else {
					dp[i][j] = dp[i - 1][j];
					if (nums[i - 1] <= j) {
						dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
					}
				}
			}
		}

		// printArray(dp);

		return dp[dp.length - 1][dp[0].length - 1];

	}

	private void printArray(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "                ");
			}
			System.out.println();
		}
	}
}
