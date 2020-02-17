package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionEasy {
	public int[] decompressRLElist(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i = i + 2) {
			int n = nums[i];
			int e = nums[i + 1];
			while (n-- > 0)
				result.add(e);

		}
		int res[] = result.stream().mapToInt(Integer::intValue).toArray();
		return res;
	}

	public int findNumbers(int[] nums) {
		// return (int) Arrays.stream(nums).filter((val) ->
		// (String.valueOf(val).length() % 2 == 0)).count();
		int count = 0;
		for (int n : nums) {
			if (String.valueOf(n).length() % 2 == 0)
				count++;
		}
		return count;
	}

	public int countNegatives(int[][] grid) {
		int count = 0;
		int r = grid.length - 1;
		int c = 0;
		while (r >= 0 && c <= grid[0].length - 1) {
			if (grid[r][c] < 0) {
				count += (grid[0].length - c);
				r--;
			} else {
				c++;
			}
		}
		return count;
	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int count = 0;
		int[] cur = points[0];
		for (int i = 1; i < points.length; i++) {
			count += minTimeToVisitAllPointsUtil(cur, points[i]);
			cur = points[i];
		}
		return count;
	}

	private int minTimeToVisitAllPointsUtil(int[] cur, int[] is) {
		int min = 0;
		int x1 = cur[0];
		int x2 = is[0];
		int y1 = cur[1];
		int y2 = is[1];
		int hor = Math.abs(x2 - x1);
		int ver = Math.abs(y2 - y1);
		int dis = Math.min(hor, ver);
		if (hor > ver) {
			min += (hor - dis);
		} else
			min += (ver - dis);

		return min + dis;
	}

	public static void main(String[] args) {
		SolutionEasy sEasy = new SolutionEasy();
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(sEasy.decompressRLElist(nums)));
		int[][] arr = new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println(sEasy.countNegatives(arr));
	}
}
