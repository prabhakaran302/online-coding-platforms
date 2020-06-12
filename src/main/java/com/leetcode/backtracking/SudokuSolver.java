package com.leetcode.backtracking;

/**
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SudokuSolver {
	static int N = 9;

	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 6, 0, 0, 0, 5, 0, 0, 0 }, { 0, 9, 3, 7, 1, 0, 0, 5, 0 },
				{ 4, 8, 0, 9, 3, 0, 7, 0, 0 }, { 0, 0, 9, 0, 0, 0, 4, 0, 0 }, { 6, 2, 4, 1, 0, 8, 3, 9, 5 },
				{ 0, 0, 8, 0, 0, 0, 1, 0, 0 }, { 0, 0, 2, 0, 4, 1, 0, 7, 9 }, { 0, 1, 0, 0, 9, 3, 8, 4, 0 },
				{ 0, 0, 0, 5, 0, 0, 0, 1, 0 } };
		printArray(board);

		if (solveSudoku(board) != true)
			System.out.println("No solution exists");

		System.out.println();

		printArray(board);

	}

	private static void printArray(int[][] grid) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean solveSudoku(int[][] board) {
		int row = -1;
		int col = -1;

		boolean isEmpty = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = true;
				}
				if (isEmpty)
					break;
			}
			if (isEmpty)
				break;
		}

		if (!isEmpty)
			return true;

		for (int i = 1; i <= N; i++) {
			if (isSafe(board, row, col, i)) {
				board[row][col] = i;
				if (solveSudoku(board)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] grid, int row, int col, int num) {

		for (int i = 0; i < N; i++) {
			if (grid[row][i] == num)
				return false;
		}

		for (int i = 0; i < N; i++) {
			if (grid[i][col] == num)
				return false;
		}

		int med = (int) Math.sqrt(N);
		int rowStart = row - row % med;
		int colStart = col - col % med;

		for (int i = rowStart; i < med + rowStart; i++) {
			for (int j = colStart; j < med + colStart; j++) {
				if (grid[i][j] == num)
					return false;
			}
		}

		return true;
	}
}
