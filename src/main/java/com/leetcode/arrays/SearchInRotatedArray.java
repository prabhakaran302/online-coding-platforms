package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0] == target ? 0 : -1;
		return searchUtil(nums, 0, nums.length - 1, target);
	}

	private int searchUtil(int[] nums, int start, int end, int target) {
		if (start > end)
			return -1;

		int mid = start + ((end - start) / 2);
		if (nums[mid] == target)
			return mid;

		if (nums[start] <= nums[mid]) {
			if (target <= nums[mid] && target >= nums[start])
				return searchUtil(nums, start, mid, target);
			else
				return searchUtil(nums, mid + 1, end, target);
		} else {
			if (target >= nums[mid] && target <= nums[end])
				return searchUtil(nums, mid + 1, end, target);
			else
				return searchUtil(nums, start, mid, target);
		}
	}

	public static void main(String[] args) {
		SearchInRotatedArray rotatedArray = new SearchInRotatedArray();
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(rotatedArray.search(nums, target));
	}
}
