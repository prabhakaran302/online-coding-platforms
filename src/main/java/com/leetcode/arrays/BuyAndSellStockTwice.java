package com.leetcode.arrays;

public class BuyAndSellStockTwice {
	public static void main(String[] args) {
		BuyAndSellStockTwice buyAndSellStockTwice = new BuyAndSellStockTwice();
		int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(buyAndSellStockTwice.maxProfit(prices));
		
		
		System.out.println(maxProfit(prices, prices.length));
	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] profit = new int[n];
		int max_price = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (max_price < prices[i])
				max_price = prices[i];

			profit[i] = Math.max(profit[i + 1], max_price - prices[i]);
		}

		int min_price = prices[0];
		for (int i = 1; i < n; i++) {
			if (min_price > prices[i])
				min_price = prices[i];

			profit[i] = Math.max(profit[i - 1], profit[i] + (prices[i] - min_price));
		}

		return profit[n - 1];
	}

	static int maxProfit(int price[], int n) {
		// Create profit array and initialize it as 0
		int profit[] = new int[n];
		for (int i = 0; i < n; i++)
			profit[i] = 0;

		/*
		 * Get the maximum profit with only one transaction allowed. After this loop,
		 * profit[i] contains maximum profit from price[i..n-1] using at most one trans.
		 */
		int max_price = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			// max_price has maximum of price[i..n-1]
			if (price[i] > max_price)
				max_price = price[i];

			// we can get profit[i] by taking maximum of:
			// a) previous maximum, i.e., profit[i+1]
			// b) profit by buying at price[i] and selling at
			// max_price
			profit[i] = Math.max(profit[i + 1], max_price - price[i]);
		}

		/*
		 * Get the maximum profit with two transactions allowed After this loop,
		 * profit[n-1] contains the result
		 */
		int min_price = price[0];
		for (int i = 1; i < n; i++) {
			// min_price is minimum price in price[0..i]
			if (price[i] < min_price)
				min_price = price[i];

			// Maximum profit is maximum of:
			// a) previous maximum, i.e., profit[i-1]
			// b) (Buy, Sell) at (min_price, price[i]) and add
			// profit of other trans. stored in profit[i]
			profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - min_price));
		}
		int result = profit[n - 1];
		return result;
	}
}
