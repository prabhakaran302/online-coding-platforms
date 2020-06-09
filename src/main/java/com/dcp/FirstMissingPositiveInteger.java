package com.dcp;

/**
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class FirstMissingPositiveInteger {
	public static void main(String[] args) {
		int arr[] = new int[] { -1, -2, -4, 1, 2, -3, 4, 0, 5 };
		System.out.println(firstMissingPositiveInteger(arr));
	}

	public static int firstMissingPositiveInteger(int[] arr) {
		int shift = segregatePositiveNegative(arr);
		int arr2[] = new int[arr.length - shift];
		int j = 0;
		for (int i = shift; i < arr.length; i++) {
			arr2[j] = arr[i];
			j++;
		}
		return findMissingPositive(arr2, j);
	}

	private static int findMissingPositive(int[] arr, int size) {
		int i;

		for (i = 0; i < size; i++) {
			int x = Math.abs(arr[i]);
			if (x - 1 < size && arr[x - 1] > 0)
				arr[x - 1] = -arr[x - 1];
		}

		for (i = 0; i < size; i++)
			if (arr[i] > 0)
				return i + 1;

		return size + 1;
	}

	private static int segregatePositiveNegative(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			if (arr[j] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			} else {
				j--;
			}
		}
		return i;
	}
}
