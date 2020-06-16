package com.dcp;

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		int n = nums.length;
		int fMax = Integer.MIN_VALUE, sMax = Integer.MIN_VALUE, tMax = Integer.MIN_VALUE, fMin = Integer.MAX_VALUE,
				sMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (nums[i] > fMax) {
				tMax = sMax;
				sMax = fMax;
				fMax = nums[i];
			} else if (nums[i] > sMax) {
				tMax = sMax;
				sMax = nums[i];
			} else if (nums[i] > tMax) {
				tMax = nums[i];
			}

			if (nums[i] < fMin) {
				sMin = fMin;
				fMin = nums[i];
			} else if (nums[i] < sMin) {
				sMin = nums[i];
			}

		}

		System.out.println("fMax >> " + fMax + " :: sMax >> " + sMax + " :: tMax >> " + tMax + " :: fMin >> " + fMin
				+ " :: sMin >> " + sMin);

		return Math.max((fMax * sMax * tMax), (fMin * sMin * fMax));
	}

	public static void main(String[] args) {
		int nums[] = new int[] { -3, -2, -1 };
		MaximumProductOfThreeNumbers mp = new MaximumProductOfThreeNumbers();
		System.out.println(mp.maximumProduct(nums));
	}
}
