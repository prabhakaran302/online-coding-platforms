package com.practice.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if (s.length() < p.length())
			return list;

		int sL = s.length();
		int pL = p.length();

		int[] sArray = new int[256];
		int[] pArray = new int[256];

		for (int i = 0; i < pL; i++) {
			pArray[p.charAt(i)]++;
			sArray[s.charAt(i)]++;
		}

		for (int i = pL; i < sL; i++) {
			if (compare(sArray, pArray)) {
				list.add(i - pL);
			}
			sArray[s.charAt(i)]++;

			sArray[s.charAt(i - pL)]--;
		}

		if (compare(sArray, pArray)) {
			list.add(sL - pL);
		}
		return list;
	}

	private boolean compare(int[] sArray, int[] pArray) {
		for (int i = 0; i < sArray.length; i++) {
			if (pArray[i] != sArray[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new FindAllAnagramsInString().findAnagrams("abab", "ab"));
	}

}
