package com.dcp;

import java.util.Arrays;
import java.util.Random;

/**
 * Randomly choosing k samples from a list of n items, where n is either a very
 * large or unknown number
 * 
 * @author prabhakaran.nivanil
 *
 */
public class ReservoirSampling {
	public static void main(String[] args) {
		int n = 1;
		int k = 1;
		for (int i = 1; i <= 20; i++) {
			int stream[] = new int[i];
			int count = 1;
			for (int j = 0; j < i; j++) {
				stream[j] = count++;
				n = stream.length;
			}
			selectKItems(stream, n, k);
		}
	}

	private static void selectKItems(int[] stream, int n, int k) {
		int ransom = stream[0];
		Random r = new Random();
		for (int i = 1; i < n; i++) {
			int j = r.nextInt(i + 1);
			if (j < k)
				ransom = stream[i];
		}
		System.out.println("For Stream " + Arrays.toString(stream) + " random element is " + ransom);
	}
}
