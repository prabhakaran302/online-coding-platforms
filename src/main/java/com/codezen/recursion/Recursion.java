package com.codezen.recursion;

public class Recursion {
	public static void main(String[] args) {
		printSequence(10);
	}

	public static void printSequence(int range) {
		if (range > 2) {
			if (String.valueOf(range).indexOf("2") != -1 || String.valueOf(range).indexOf("5") != -1)
				System.out.println(range);
			printSequence(range--);
		}
	}
}
