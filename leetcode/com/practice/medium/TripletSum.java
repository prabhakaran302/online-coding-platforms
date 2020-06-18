package com.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/submissions/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class TripletSum {

	/**
	 * Solution using Sort Array Time :- O(n2logn) ~ O(n2) Space :- O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.parallelSort(nums);
		int l = 1;
		int r = nums.length - 1;

		System.out.println(Arrays.toString(nums));

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int i = 0; i < nums.length - 1; i++) {
			l = i + 1;
			r = nums.length - 1;
			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					List<Integer> li = new ArrayList<Integer>();
					li.add(nums[i]);
					li.add(nums[l]);
					li.add(nums[r]);
					set.add(li);
					l++;
					r--;
				} else if (nums[i] + nums[l] + nums[r] > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		Iterator<List<Integer>> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	/**
	 * Solution using hashmap O(n2) -Time and O(n) - space
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums, int n) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// TODO: Implementation
		return list;
	}

	public static void main(String[] args) {
		TripletSum sum = new TripletSum();
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(sum.threeSum(nums));
		System.out.println(sum.threeSum(nums, nums.length));
	}
}
