package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class BuyAndSellStockOnce {
	public static void main(String[] args) {
		BuyAndSellStockOnce buySellStock = new BuyAndSellStockOnce();
		int[] prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(buySellStock.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int leftMin[] = new int[prices.length];
		int rightMax[] = new int[prices.length];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < leftMin.length; i++) {
			if (min > prices[i])
				min = prices[i];
			leftMin[i] = min;
		}

		for (int i = rightMax.length - 1; i >= 0; i--) {
			if (max < prices[i])
				max = prices[i];
			rightMax[i] = max;
		}

		int diff = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			diff = Math.max(rightMax[i] - leftMin[i], diff);
		}

		if (diff < 0)
			return 0;

		return diff;
	}
}
