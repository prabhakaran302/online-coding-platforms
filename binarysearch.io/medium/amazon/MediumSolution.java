package medium.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MediumSolution {
	public static void main(String[] args) {
		MediumSolution sol = new MediumSolution();
		System.out.println(sol.solveCutPalindrome("cat", "pac"));
		System.out.println("###############################\n");

		int[] nums = new int[] { -21, -98, 259, -998, -494, -603, -312, -429, 292, -962, 566, 424, 448, -202, -720, 863,
				-226, -327, 667, -811, 479, -865, -684, -390, -62, -849, -541, 454, 437, -244, 429, 380, -390, 423,
				-837, 463, 258, -911, 207, 620, 911, -312, -663, -751, -327, -193, -911, 483, -534, -663, 787, -389,
				-516, 738, -571, -565, -582, -533, 696, -444, 496, 847, 535, -107, 978, 97, 517, -679, 993, 329, 157,
				23, 532, 963, -342, -514, 186, 823, 939, -716, -788, -219, 433, -27, -458, -205, 246, 886, 801, 643,
				506, 221, -958, -136, 391, -926, 565, -682, 794, 861, 51, 694, -197, -635, 616, 84, -343, -373, -797,
				890, 903, -65, -174, 784, 373, -236, -17, -667, -841, -668, -567, -838, 126, -88, -634, -110, 483, 909,
				237, 22, -910, 925, 164, -34, 315, 571, -116, -870, -7, 778, 912, -435, 495, 820, -848, -77, 996, -189,
				77, -545, 727, 28, 289, 125, 763, 992, 952, 768, -79, 912, 901, -423, 883 };
		System.out.println(Arrays.toString(sol.solveSpaceBattle(nums)));
		System.out.println("###############################\n");
	}

	/**
	 * Given a list of integers nums and an integer target, return the number of
	 * sublists whose sum is equal to target.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int solveSublistSumTarget(int[] nums, int target) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == target)
				res++;

			if (map.get(sum - target) != null)
				res += map.get(sum - target);

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}

	/**
	 * Given a singly linked list l0 and another linked list l1, each representing a
	 * number with least significant digits first, return the summed linked list.
	 * 
	 * @param l0
	 * @param l1
	 * @return
	 */
	public LLNode solveAddLinkedList(LLNode l0, LLNode l1) {
		int carry = 0;
		LLNode head = null;
		LLNode node = null;

		int sum = l0.val + l1.val + carry;
		carry = sum / 10;
		sum = sum % 10;
		head = new LLNode();
		head.val = sum;
		node = head;

		l0 = l0.next;
		l1 = l1.next;

		while (l0 != null || l1 != null) {
			sum = (l0 != null ? l0.val : 0) + (l1 != null ? l1.val : 0) + carry;
			carry = sum / 10;
			sum = sum % 10;
			head.next = new LLNode();
			head = head.next;
			head.val = sum;

			if (l0 != null)
				l0 = l0.next;
			if (l1 != null)
				l1 = l1.next;
		}

		if (carry > 0) {
			head.next = new LLNode();
			head = head.next;
			head.val = carry;
		}

		return node;
	}

	/**
	 * Given two strings a and b of equal length, return whether it is possible to
	 * cut both strings at a common point such that the first part of a and the
	 * second part of b form a palindrome.
	 * 
	 * @param string
	 * @param string2
	 * @return
	 */
	private boolean solveCutPalindrome(String a, String b) {
		return solveCutPalindromeUtil(a, b) || solveCutPalindromeUtil(b, a);
	}

	private boolean solveCutPalindromeUtil(String a, String b) {
		int i = 0;
		int j = b.length() - 1;

		boolean switchFlag = false;
		while (i < j) {
			if (switchFlag) {
				if (a.charAt(i) != a.charAt(j))
					return false;
			} else {
				if (a.charAt(i) != b.charAt(j)) {
					if (a.charAt(i) == a.charAt(j)) {
						switchFlag = true;
					} else {
						return false;
					}
				}
			}
			i++;
			j--;
		}

		return true;
	}

	/**
	 * Not Passed
	 * 
	 * @param nums
	 * @return
	 */
	public int[] solveSpaceBattle(int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			if (cur < 0) {
				int ele = stack.peek();
				while (!stack.isEmpty() && Math.abs(cur) > ele && ele > 0)
					stack.pop();

				if (!stack.isEmpty() && ele == Math.abs(cur))
					stack.pop();
				else if ((!stack.isEmpty() && ele < 0) || stack.isEmpty())
					stack.push(cur);

			} else {
				stack.push(cur);
			}
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < stack.size(); i++)
			res[i] = stack.get(i);
		return res;
	}

	/**
	 * Given a string s, eliminate consecutive duplicate characters from the string
	 * and return it.
	 * 
	 * 
	 */
	public String eliminateDuplicate(String s) {
		StringBuilder sb = new StringBuilder();
		char prev = s.charAt(0);
		sb.append(String.valueOf(prev));
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != prev) {
				prev = s.charAt(i);
				sb.append(String.valueOf(prev));
			}
		}

		return sb.toString();
	}
}

class LLNode {
	int val;
	LLNode next;
}