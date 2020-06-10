package com.dcp;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the
 * number of ways it can be decoded.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		int count[] = new int[s.length() + 1];
		count[0] = 1;
		count[1] = 1;
		if (s.charAt(0) == '0')
			return 0;
		for (int i = 2; i < count.length; i++) {
			count[i] = 0;
			if (Integer.parseInt(String.valueOf(s.charAt(i - 1))) > 0)
				count[i] = count[i - 1];

			if (Integer.parseInt(String.valueOf(s.charAt(i - 2))) == 1
					|| (Integer.parseInt(String.valueOf(s.charAt(i - 2))) == 2
							&& Integer.parseInt(String.valueOf(s.charAt(i - 1))) < 7))
				count[i] += count[i - 2];

		}
		return count[count.length - 1];
	}

	public static void main(String[] args) {
		DecodeWays dWays = new DecodeWays();
		String s = "12123";
		System.out.println("String " + s + " >> ways >> " + dWays.numDecodings(s));
	}
}
