package com.practice.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int i : stones)
			queue.offer(i);

		while (queue.size() > 1) {
			int f = queue.poll();
			int r = queue.poll();

			if (f != r) {
				queue.offer(Math.abs(f - r));
			}
		}
		
		if(queue.isEmpty())
			queue.offer(0);

		return queue.poll();
	}

	public static void main(String[] args) {
		LastStoneWeight l = new LastStoneWeight();
		int[] stones = new int[] { 7, 6, 7, 6, 9 };
		System.out.println(l.lastStoneWeight(stones));
	}
}
