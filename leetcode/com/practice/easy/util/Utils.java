package com.practice.easy.util;

public class Utils {
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void printBooleanArray(boolean[][] root) {
		for (int i = 0; i < root.length; i++) {
			for (int j = 0; j < root[0].length; j++) {
				System.out.print(root[i][j] + " ");
			}
			System.out.println();
		}
	}
}
