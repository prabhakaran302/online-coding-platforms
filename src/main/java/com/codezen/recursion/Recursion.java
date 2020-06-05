package com.codezen.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recursion {

	static class RecusrsionUtil {
		static int floorValue = -1;
		static int maxOnesCount = 1;

		static String temp_dictionary[] = new String[] { "mobile", "big", "samsung", "sam", "sung", "man", "mango", "icecream",
				"and", "go", "i", "like", "ice", "cream", "am" };
		static Set<String> dictionary = new HashSet<String>();
	}

	public static void main(String[] args) {
		printSequence(1);
		System.out.println(Arrays.deepToString(printWellFormedParanthesis(3)));
		printCombination(4);

		int M[][] = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
		System.out.println(getMaxOnes(M));

		int A[] = new int[] { 3, 2, 1 };
		System.out.println("Max Inversion " + solve(A, A.length));

		A = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("Floor Value " + findFloor(A, 25));

		for (String word : RecusrsionUtil.temp_dictionary) {
			RecusrsionUtil.dictionary.add(word);
		}

		System.out.println(wordBreak("iambig"));
		System.out.println(wordBreak("iiiiiiii"));
		System.out.println(wordBreak(""));
		System.out.println(wordBreak("ilikelikeimangoiiisamsamsung"));
		System.out.println(wordBreak("samsungandmango"));
		System.out.println(wordBreak("samsungandmangok"));
	}

	/**
	 * Given an input string and a dictionary of words, find out if the input string
	 * can be segmented into a space-separated sequence of dictionary words.
	 * 
	 * @param word
	 * @return
	 */
	private static boolean wordBreak(String word) {
		System.out.print("Possible to break Word " + word + " >> ");
		return wordBreakUtil(word, word.length());
	}

	private static boolean wordBreakUtil(String word, int length) {
		if (length == 0)
			return true;
		
		if(RecusrsionUtil.dictionary.contains(word))
			return true;

		for (int i = 1; i <= length; i++) {
			String prefix = word.substring(0, i);
			String suffix = word.substring(i, length);
			boolean dictWord = RecusrsionUtil.dictionary.contains(prefix);
			boolean wordBreakFlag = wordBreakUtil(suffix, suffix.length());
			if (dictWord && wordBreakFlag)
				return true;
		}
		return false;
	}

	/**
	 * Given a sorted array A and an integer x, floor value of x is the largest
	 * element in the array which is smaller than or equal to x. You need to write
	 * an efficient function to find floor value of x.
	 * 
	 * @param array
	 * @param element
	 * @return
	 */
	public static int findFloor(int[] array, int element) {
		findFloorUtil(array, 0, array.length - 1, element);
		return RecusrsionUtil.floorValue;
	}

	private static void findFloorUtil(int[] array, int low, int high, int element) {
		if (low < high) {
			int mid = (low + high) / 2;

			if (array[mid] == element)
				RecusrsionUtil.floorValue = array[mid];

			if (array[mid] < element && mid != high && array[mid + 1] > element)
				RecusrsionUtil.floorValue = array[mid];

			if (array[mid] > element) {
				findFloorUtil(array, low, mid, element);
			} else if (array[mid] < element) {
				findFloorUtil(array, mid + 1, high, element);
			}
		}
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
	public static long solve(int[] A, int n) {
		return solveUtil(A, 0, n - 1);
	}

	private static long solveUtil(int[] a, int low, int high) {
		int count = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			count += solveUtil(a, low, mid);
			count += solveUtil(a, mid + 1, high);
			count += megreSolveUtil(a, low, mid, high);

		}
		return count;
	}

	private static int megreSolveUtil(int[] a, int low, int mid, int high) {
		int[] left = Arrays.copyOfRange(a, low, mid + 1);
		int[] right = Arrays.copyOfRange(a, mid + 1, high + 1);
		int swaps = 0;
		int i = 0, j = 0, k = low;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
				swaps += (mid + 1) - (low + i);
			}
		}
		while (i < left.length)
			a[k++] = left[i++];

		while (j < right.length)
			a[k++] = right[j++];

		return swaps;
	}

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
					RecusrsionUtil.maxOnesCount = 1;
					DFS(inputMatrix, i, j, visited);
					result = Math.max(RecusrsionUtil.maxOnesCount, result);
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
				RecusrsionUtil.maxOnesCount++;
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
