package com.practice.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class EasyPracticeQuestions {
	public static void main(String[] args) {
		EasyPracticeQuestions easy = new EasyPracticeQuestions();
		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(easy.removeDuplicates(nums));
		System.out.println("***************************\n");

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		easy.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
		System.out.println("***************************\n");

		nums = new int[] { 1, 2, 3, 1 };
		System.out.println(easy.containsDuplicate(nums));
		System.out.println("***************************\n");
	}

	/**
	 * Given a sorted array nums, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int len = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[len++] = nums[i];
			}
		}
		nums[len++] = nums[nums.length - 1];
		return len;
	}

	/**
	 * Given an array, rotate the array to the right by k steps, where k is
	 * non-negative.
	 * 
	 * Follow up:
	 * 
	 * Try to come up as many solutions as you can, there are at least 3 different
	 * ways to solve this problem.
	 * <p>
	 * Could you do it in-place with O(1) extra space?
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			int temp = nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = temp;
		}
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
