package com.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/submissions/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SegregateColorArray {
	public void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		int temp = -1;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}
		}

	}

	public static void main(String[] args) {
		int nums[] = new int[] { 1,0,1,1,1,2,1, 2 };
		SegregateColorArray obj = new SegregateColorArray();
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
