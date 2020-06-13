package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblems {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<List<String>>();
		int[][] mat = new int[n][n];
		solveNQueens(mat, 0, list);
		return list;
	}

	private void solveNQueens(int[][] mat, int col, List<List<String>> list) {
		if (col == mat.length) {
			addInlist(mat, list);
			return;
		}
		for (int i = 0; i < mat.length; i++) {
			if (isSafe(mat, i, col)) {
				mat[i][col] = 1;
				solveNQueens(mat, col + 1, list);
				mat[i][col] = 0;
			}
		}
	}

	private boolean isSafe(int[][] board, int row, int col) {
		int i, j;

		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		int N = board.length;
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	private void addInlist(int[][] mat, List<List<String>> list) {
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < mat.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < mat[0].length; j++) {
				sb.append(mat[i][j] == 1 ? "Q" : ".");
			}
			li.add(sb.toString());
		}
		list.add(li);
	}
	
	public static void main(String[] args) {
		NQueenProblems obj = new NQueenProblems();
		List<List<String>> li = obj.solveNQueens(4);
		System.out.println(li);
	}
}
