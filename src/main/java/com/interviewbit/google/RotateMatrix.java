package com.interviewbit.google;

import java.util.ArrayList;

public class RotateMatrix {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		transposeMatrix(a);
		reverseMatrix(a);
	}

	private void reverseMatrix(ArrayList<ArrayList<Integer>> a) {
		for (int i = 0; i < a.size(); i++) {
			int k = 0;
			for (int j = a.size() - 1; j > k; j--) {
				int tempL = a.get(i).get(k);
				int tempF = a.get(i).get(j);

				a.get(i).set(j, tempL);
				a.get(i).set(k, tempF);
				k++;
			}
		}
	}

	private void transposeMatrix(ArrayList<ArrayList<Integer>> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = i; j < a.size(); j++) {
				int tempi = a.get(i).get(j);
				int tempj = a.get(j).get(i);
				a.get(i).set(j, tempj);
				a.get(j).set(i, tempi);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		a.add(li);
		li = new ArrayList<Integer>();
		li.add(4);
		li.add(5);
		li.add(6);
		a.add(li);
		li = new ArrayList<Integer>();
		li.add(7);
		li.add(8);
		li.add(9);
		a.add(li);

		RotateMatrix r = new RotateMatrix();
		r.rotate(a);

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(matrix);

		r.solve(matrix);
		System.out.println("final");
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] solve(int[][] matrix) {
		transpose(matrix);
		System.out.println("transpose");
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("rotate");
		printMatrix(matrix);
		return matrix;
	}

	public void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {

				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;

			}
		}
	}

	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int k = 0;
			for (int j = matrix[0].length - 1; j > k; j--) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[k][i];
				matrix[k][i] = temp;

				k++;
			}
		}
	}
}
