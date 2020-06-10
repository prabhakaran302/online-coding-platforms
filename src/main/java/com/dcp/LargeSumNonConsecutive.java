package com.dcp;

/**
 * Given a list of integers, write a function that returns the largest sum of
 * non-adjacent numbers. Numbers can be 0 or negative.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class LargeSumNonConsecutive {
	public static void main(String[] args) {
		LargeSumNonConsecutive obj = new LargeSumNonConsecutive();
		int[] nums = new int[] { 5, 5, 10, 100, 10, 5 };
		System.out.println(obj.maxSubArrayContingous(nums));

		System.out.println(obj.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int inc = nums[0] < 0 ? 0 : nums[0];
		int exc = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= 0) {
				int temp = Math.max(inc, exc);
				inc = Math.max(exc + nums[i], inc);
				exc = temp;
			} else {
				exc = Math.max(inc, exc);
			}
		}
		return Math.max(inc, exc);
	}

	/**
	 * Kadane Algorithm
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArrayContingous(int[] nums) {
		int max = nums[0];
		int sum_till = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum_till < 0) {
				sum_till = 0;
			}
			sum_till += nums[i];
			if (max < sum_till)
				max = sum_till;
		}
		return max;
	}
}
