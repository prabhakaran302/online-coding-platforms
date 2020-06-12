package com.dcp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class MaxValueInSubarrayOfWindowSizeK {
	public static void main(String[] args) {
		MaxValueInSubarrayOfWindowSizeK obj = new MaxValueInSubarrayOfWindowSizeK();
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int res[] = new int[nums.length - k + 1];
		Deque<Integer> q = new LinkedList<Integer>();
		int i;
		for (i = 0; i < k; i++) {
			while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
				q.removeLast();
			}
			q.add(i);
		}

		int j = 0;
		for (; i < nums.length; i++) {
			res[j++] = nums[q.peekFirst()];

			while (!q.isEmpty() && q.peekFirst() <= i - k) {
				q.removeFirst();
			}

			while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
				q.removeLast();
			}
			q.add(i);
		}

		res[j++] = nums[q.peekFirst()];

		return res;
	}
}
