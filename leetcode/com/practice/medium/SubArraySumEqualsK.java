package com.practice.medium;

public class SubArraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int curSum = nums[0];
		int i = 1;
		int j = nums.length - 1;
		int count = 0;

		int delIndex = 0;
		while (i <= j) {
			if (curSum == k) {
				count++;
			} else if (curSum > k) {
				curSum -= nums[delIndex++];
			}
			i++;
			curSum += nums[i];
		}

		if (curSum == k)
			count++;
		return count;
	}

	public static void main(String[] args) {
		SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
		int[] nums = new int[] { 1, 2, 3 };
		int k = 3;
		System.out.println(subArraySumEqualsK.subarraySum(nums, k));

		nums = new int[] { 1, 1, 1 };
		k = 2;
		System.out.println(subArraySumEqualsK.subarraySum(nums, k));

		nums = new int[] { -1, -1, 1 };
		k = 0;
		System.out.println(subArraySumEqualsK.subarraySum(nums, k));
	}
}
