package com.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/string-compression/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class StringCompression {
	public int compress(char[] chars) {
		if (chars.length == 1)
			return 1;
		int i = 0;
		int j = chars.length;
		int count = 1;
		int index = 0;
		StringBuilder res = new StringBuilder();
		while (i <= j - 1) {
			while (i < j - 1 && chars[i] == chars[i + 1]) {
				count++;
				i++;
			}
			if (count == 1) {
				res.append(chars[i]);
				chars[index++] = chars[i];
			} else if (count > 9) {
				res.append(chars[i]).append(count);
				chars[index++] = chars[i];
				chars[index++] = (char) (count / 10 + '0');
				chars[index++] = (char) (count % 10 + '0');
			} else {
				chars[index++] = chars[i];
				chars[index++] = (char) (count + '0');
				res.append(chars[i]).append(count);
			}

			count = 1;
			i++;
		}
		System.out.println(res);
		return res.length();
	}

	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		char[] chars = { 'a', 'b', 'c' };
		System.out.println(Arrays.toString(chars));

		obj.compress(chars);
		System.out.println(Arrays.toString(chars));
	}
}
