package com.interviewbit.google;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumNoPlatformRequired {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(18);
		A.add(li);

		li = new ArrayList<Integer>();
		li.add(18);
		li.add(23);
		A.add(li);

		li = new ArrayList<Integer>();
		li.add(15);
		li.add(29);
		A.add(li);

		li = new ArrayList<Integer>();
		li.add(4);
		li.add(15);
		A.add(li);

		li = new ArrayList<Integer>();
		li.add(2);
		li.add(11);
		A.add(li);

		li = new ArrayList<Integer>();
		li.add(5);
		li.add(13);
		A.add(li);

		MinimumNoPlatformRequired obj = new MinimumNoPlatformRequired();
		System.out.println(obj.solve(A));
	}

	public int solve(ArrayList<ArrayList<Integer>> A) {
		int result = 0;
		int max = 0;
		ArrayList<Integer> arrival = new ArrayList<Integer>();
		ArrayList<Integer> dep = new ArrayList<Integer>();

		for (int i = 0; i < A.size(); i++) {
			arrival.add(A.get(i).get(0));
			dep.add(A.get(i).get(1));
		}

		Collections.sort(arrival);
		Collections.sort(dep);

		int i = 0;
		int j = 0;
		while (i < A.size() && j < A.size()) {
			if (arrival.get(i) < dep.get(j)) {
				i++;
				result++;
			} else {
				j++;
				result--;
			}
			
			if(max < result)
				max = result;
		}

		return max;
	}
}
