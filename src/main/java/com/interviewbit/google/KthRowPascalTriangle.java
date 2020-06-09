package com.interviewbit.google;

import java.util.ArrayList;

public class KthRowPascalTriangle {
	public static void main(String[] args) {
		System.out.println(new KthRowPascalTriangle().getRow(2));
	}

	public ArrayList<Integer> getRow(int A) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (A == 0) {
			list.add(1);
			return list;
		}

		for (int j = 0; j <= A; j++) {
			list.add(getPascal(A, j));
		}

		return list;

	}

	private Integer getPascal(int i, int j) {
		if (j == 0)
			return 1;
		else if (i == j)
			return 1;
		else {
			return getPascal(i - 1, j - 1) + getPascal(i - 1, j);
		}
	}

}
