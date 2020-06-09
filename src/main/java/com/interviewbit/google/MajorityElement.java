package com.interviewbit.google;

import java.util.List;

public class MajorityElement {
	public static void main(String[] args) {

	}

	public int majorityElement(final List<Integer> A) {
		int maj = A.get(0);
		int maj_length = 1;
		for (int i = 1; i < A.size(); i++) {
			if (maj_length == 0) {
				maj = A.get(i);
				maj_length = 1;
			}
			if (A.get(i) == maj) {
				maj_length++;
			} else {
				maj_length--;
			}
		}

		int count = 0;
		for (int i : A) {
			if (i == maj)
				count++;
		}

		if (count >= A.size() / 2)
			return maj;

		return -1;
	}
}
