package com.dcp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFromDataStream {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianFromDataStream() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
	}

	public void addNum(int num) {
		minHeap.offer(num);
		maxHeap.offer(minHeap.poll());

		if (minHeap.size() < maxHeap.size())
			minHeap.offer(maxHeap.poll());
	}

	public double findMedian() {
		if (minHeap.size() > maxHeap.size())
			return minHeap.peek();

		return (minHeap.peek() + maxHeap.peek()) / 2;
	}
}
