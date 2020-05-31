package com.codezen.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recursion {

	public static void main(String[] args) {
		printSequence(1);
		System.out.println(Arrays.deepToString(printWellFormedParanthesis(3)));
		printCombination(4);

		int M[][] = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
		System.out.println(getMaxOnes(M));
	}

	/**
	 * Let A[0 ... n-1] be an array of n distinct positive integers. If i < j and
	 * A[i] > A[j] then the pair (i, j) is called an inversion of A (where i and j
	 * are indexes of A). Given an integer array A, your task is to find the number
	 * of inversions in A.
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	long solve(int[] A, int n) {
		int result = 1;
		
		return result;
	}

	static int maxOnesCount = 1;

	/**
	 * Given a n*m matrix, find and print the number of cells in the largest region
	 * in the matrix. Note that there may be more than one region in the matrix.
	 * 
	 * @param inputMatrix
	 * @return
	 */
	public static int getMaxOnes(int[][] inputMatrix) {
		int row = inputMatrix.length;
		int col = inputMatrix[0].length;
		boolean[][] visited = new boolean[row][col];

		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (inputMatrix[i][j] == 1 && !visited[i][j]) {
					maxOnesCount = 1;
					DFS(inputMatrix, i, j, visited);
					result = Math.max(maxOnesCount, result);
				}
			}
		}

		return result;
	}

	private static void DFS(int[][] inputMatrix, int row, int col, boolean[][] visited) {
		int[] rowsC = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colC = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		for (int k = 0; k < rowsC.length; k++) {
			if (isSafe(inputMatrix, visited, row + rowsC[k], col + colC[k])) {
				maxOnesCount++;
				DFS(inputMatrix, row + rowsC[k], col + colC[k], visited);
			}
		}
	}

	private static boolean isSafe(int[][] inputMatrix, boolean[][] visited, int i, int j) {
		return (i < inputMatrix.length && i >= 0 && j < inputMatrix[0].length && j >= 0
				&& (inputMatrix[i][j] == 1 && !visited[i][j]));
	}

	/**
	 * Given an integer n, break it into smaller numbers such that their summation
	 * is equal to n. Print all such combinations in different lines.
	 */
	public static void printCombination(int num) {
		int[] dp = new int[200];
		solvePrintCombination(num, num, 1, dp);
	}

	private static void solvePrintCombination(int remSum, int maxVal, int idx, int[] dp) {
		if (remSum == 0) {
			print(idx, dp);
			return;
		}
		for (int i = 1; i <= maxVal; i++) {
			if (i > remSum) {
				continue;
			} else if (i <= remSum) {
				dp[idx] = i;
				solvePrintCombination(remSum - i, i, idx + 1, dp);
			}
		}
	}

	private static void print(int idx, int[] dp) {
		for (int i = idx - 1; i >= 1; i--) {
			System.out.print(dp[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * Given n pairs of parentheses, write a function to generate and print all
	 * combinations of well-formed parentheses. That is, you need to generate all
	 * possible valid set of parenthesis that can be formed with given number of
	 * pairs.
	 * 
	 * @param n
	 * @return
	 */
	public static String[] printWellFormedParanthesis(int n) {
		char[] arr = new char[2 * n];
		List<String> values = new ArrayList<>();
		printWellFormedParanthesis(arr, 0, n, 0, 0, values);
		Collections.reverse(values);
		String[] resArr = new String[values.size()];
		return values.toArray(resArr);
	}

	private static void printWellFormedParanthesis(char[] arr, int pos, int n, int start, int end,
			List<String> values) {
		if (end == n) {
			char[] res = new char[arr.length];
			for (int i = 0; i < arr.length; i++)
				res[i] = arr[i];
			values.add(String.valueOf(res));
		} else {
			if (start > end) {
				arr[pos] = ')';
				printWellFormedParanthesis(arr, pos + 1, n, start, end + 1, values);
			}
			if (start < n) {
				arr[pos] = '(';
				printWellFormedParanthesis(arr, pos + 1, n, start + 1, end, values);
			}
		}
	}

	/**
	 * Given an integer n, you need to print all numbers less than n which are
	 * having digits only 2 or 5 or both. Print every number in new line. Order of
	 * numbers doesn't matter.
	 * 
	 * @param range
	 */
	public static void printSequence(int n) {
		printSequence(2, n);
	}

	private static void printSequence(int start, int range) {
		if (start <= range) {
			checkVal(start);
			start = start + 1;
			printSequence(start, range);
		} else {
			return;
		}
	}

	private static void checkVal(int start) {
		String str = String.valueOf(start);
		if (str.indexOf("0") == -1 && str.indexOf("1") == -1 && str.indexOf("3") == -1 && str.indexOf("4") == -1
				&& str.indexOf("6") == -1 && str.indexOf("7") == -1 && str.indexOf("8") == -1 && str.indexOf("9") == -1)
			System.out.println(str);
	}
}
