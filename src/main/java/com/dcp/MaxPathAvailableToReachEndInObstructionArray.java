package com.dcp;

/**
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class MaxPathAvailableToReachEndInObstructionArray {
	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		MaxPathAvailableToReachEndInObstructionArray obj = new MaxPathAvailableToReachEndInObstructionArray();

		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
			return 0;
		int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = 0; i < res[0].length; i++) {
			if (i > 0) {
				if (obstacleGrid[0][i] == 1)
					res[0][i] = 0;
				else if (res[0][i - 1] == 0) {
					res[0][i] = 0;
				} else {
					res[0][i] = 1;
				}
			} else {
				res[0][i] = 1;
			}
		}

		for (int i = 0; i < res.length; i++) {
			if (i > 0) {
				if (obstacleGrid[i][0] == 1)
					res[i][0] = 0;
				else if (res[i - 1][0] == 0) {
					res[i][0] = 0;
				} else {
					res[i][0] = 1;
				}
			} else {
				res[i][0] = 1;
			}
		}

		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[i][j] = 0;
				} else {
					if (res[i - 1][j] == 0 && res[i][j - 1] == 0)
						res[i][j] = 0;
					else
						res[i][j] = res[i - 1][j] + res[i][j - 1];

				}
			}
		}

		return res[res.length - 1][res[0].length - 1];
	}
}
