package com.dcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * You run an e-commerce website and want to record the last N order ids in a
 * log. Implement a data structure to accomplish this, with the following API:
 * 
 * @author prabhakaran.nivanil
 *
 */
public class LastKRecords {
	static int N = 5;
	int[] orderList = new int[N];
	int index = 0;

	static List<Integer> allOrders = new ArrayList<>();

	public static void main(String[] args) {
		LastKRecords obj = new LastKRecords();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int ele = i + r.nextInt(i + 1);
			obj.record(ele);
			allOrders.add(ele);
		}

		System.out.println(Arrays.toString(obj.orderList));
		System.out.println(allOrders);

		System.out.println(obj.index);
		for (int i = 0; i < N; i++) {
			System.out.println("last order " + (i + 1) + " from the log is " + obj.get_last(i));
		}
	}

	/**
	 * adds the order_id to the log
	 * 
	 * @param order_id
	 */
	public void record(int order_id) {
		if (index >= N)
			index = index % N;
		orderList[index++] = order_id;
	}

	/**
	 * gets the ith last element from the log. i is guaranteed to be smaller than or
	 * equal to N.
	 * 
	 * @param i
	 */
	public Integer get_last(int i) {
		if (i >= orderList.length)
			return -1;

		return orderList[(index - i - 1 + N) % N];
	}
}
