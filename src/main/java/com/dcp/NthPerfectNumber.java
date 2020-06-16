package com.dcp;

public class NthPerfectNumber {
	public static void main(String[] args) {
		int k = 20;
		getNthPerfect(k);
	}

	private static void getNthPerfect(int n) {
		int nthElement = 19 + (n - 1) * 9;
		int outliersCount = (int) Math.log10(nthElement) - 1;

		nthElement += 9 * outliersCount;
		System.out.println(nthElement);
	}
}
