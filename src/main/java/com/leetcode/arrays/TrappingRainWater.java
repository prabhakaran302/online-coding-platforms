package com.leetcode.arrays;

public class TrappingRainWater {
	public int trap(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int sum = 0;

		int max = height[0];
		for (int i = 0; i < left.length; i++) {
			if (max < height[i]) {
				max = height[i];
			}
			left[i] = max;
		}

		max = height[height.length - 1];

		for (int i = height.length - 1; i >= 0; i--) {
			if (max < height[i]) {
				max = height[i];
			}
			right[i] = max;
		}

		for (int i = 0; i < height.length; i++) {
			sum += Math.min(left[i], right[i]) - height[i];
		}

		return sum;
	}
}
