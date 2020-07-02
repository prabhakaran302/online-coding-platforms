package com.practice.easy.util;

public class Utils {
	public static void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
