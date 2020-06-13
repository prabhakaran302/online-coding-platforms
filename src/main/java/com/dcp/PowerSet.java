package com.dcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class PowerSet {
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int i = 0; i < nums.length; ++i) {
			List<List<Integer>> newResult = new ArrayList<>();
			for (List<Integer> L : result) {
				L = new ArrayList<>(L);
				L.add(nums[i]);
				newResult.add(L);
			}
			result.addAll(newResult);
		}

		removeDuplicates(result);

		System.out.println(result);
		return result;

	}

	private void removeDuplicates(List<List<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			for (int j = i + 1; j < result.size(); j++) {
				List<Integer> li1 = result.get(i);
				List<Integer> li2 = result.get(j);

				if (li1.size() == li2.size()) {
					Collections.sort(li1);
					Collections.sort(li2);

					boolean flag = false;
					for (int k = 0; k < li1.size(); k++) {
						if (li1.get(k) != li2.get(k)) {
							break;
						}
						if (k == li1.size() - 1)
							flag = true;
					}
					if (flag) {
						result.remove(li1);
						i--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		PowerSet powerSet = new PowerSet();

		int[] nums = new int[] { 1, 2, 3 };
		powerSet.subsetsWithDup(nums);
	}
}
