package com.dcp;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	public static void main(String[] args) {
		MergeIntervals mergeIntervals = new MergeIntervals();
		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] res = mergeIntervals.merge(intervals);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] merge(int[][] c) {

		if (c.length <= 1)
			return c;

		Integer[][] intervals = new Integer[c.length][c[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				intervals[i][j] = c[i][j];
			}
		}

		Comparator<Integer[]> comp = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		};

		Arrays.sort(intervals, comp);

		Integer[][] res = new Integer[intervals.length][intervals[0].length];
		int index = 0;
		Integer[] prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			Integer[] cur = intervals[i];
			if (prev[1] >= cur[0]) {
				prev[1] = Math.max(prev[1], cur[1]);
			} else {
				res[index++] = prev;
				prev = cur;
			}
		}

		res[index++] = prev;

		int[][] t = new int[intervals.length][intervals[0].length];
		int count = 0;
		for (Integer[] tempC : res) {
			if (count >= index)
				break;
			t[count++] = new int[] { tempC[0], tempC[1] };
		}

		return Arrays.copyOfRange(t, 0, count);
	}
}
