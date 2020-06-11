package com.dcp;

import java.util.Random;

/**
 * Select a random number from stream, with O(1) space
 * 
 * @author prabhakaran.nivanil
 *
 */
public class RandomNumberFromStream {

	static int count = 0;
	static int res = 0;

	public static void main(String[] args) {
		for (int i = 1; i <= 14; i++) {
			System.out.println("Random element from stream till " + i + " is " + generateRandom(i));
		}
	}

	private static int generateRandom(int x) {
		count++;
		if (count == 1)
			res = x;
		else {
			Random r = new Random();
			int i = r.nextInt(count);

			if (i == count - 1)
				res = x;
		}

		return res;
	}
}
