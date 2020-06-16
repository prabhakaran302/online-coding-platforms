package com.practice.easy;

public class ShiftZeroMaintaingRelativeOrder {
	public void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}
		}
		for (int i = count; i < nums.length; i++) {
			nums[i] = 0;
		}

	}

	public static void main(String[] args) {
		ShiftZeroMaintaingRelativeOrder obj = new ShiftZeroMaintaingRelativeOrder();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		obj.moveZeroes(nums);
	}
}
