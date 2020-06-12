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

		return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };

		MedianFromDataStream obj = new MedianFromDataStream();

		for (int i = 0; i < arr.length; i++) {
			obj.addNum(arr[i]);
			System.out.println(obj.minHeap);
			System.out.println(obj.maxHeap);
			System.out.println(obj.findMedian());
		}
	}
}
