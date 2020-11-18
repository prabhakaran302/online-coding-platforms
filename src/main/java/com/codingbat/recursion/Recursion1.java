package com.codingbat.recursion;

public class Recursion1 {

	public int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	/**
	 * 
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3,
	 * ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3
	 * ears, because they each have a raised foot. Recursively return the number of
	 * "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
	 * bunnyEars2(0) â†’ 0 bunnyEars2(1) â†’ 2 bunnyEars2(2) â†’ 5
	 */
	public int bunnyEars2(int bunnies) {
		if (bunnies <= 0)
			return 0;
		int val = 0;
		if (bunnies % 2 != 0)
			val = 2;
		if (bunnies % 2 == 0)
			val = 3;
		return val + bunnyEars2(bunnies - 1);
	}

	/**
	 * 
	 * 
	 * We have triangle made of blocks. The topmost row has 1 block, the next row
	 * down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively
	 * (no loops or multiplication) the total number of blocks in such a triangle
	 * with the given number of rows.
	 * 
	 * 
	 * triangle(0) â†’ 0 triangle(1) â†’ 1 triangle(2) â†’ 3
	 * 
	 * @param rows
	 * @return
	 */
	public int triangle(int rows) {
		if (rows <= 0)
			return 0;
		if (rows == 1)
			return 1;
		return rows + triangle(rows - 1);
	}

	/**
	 * 
	 * Given a non-negative int n, return the sum of its digits recursively (no
	 * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
	 * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 * 
	 * 
	 * sumDigits(126) â†’ 9 \n sumDigits(49) â†’ 13 sumDigits(12) â†’ 3
	 * 
	 * @param n
	 * @return
	 */
	public int sumDigits(int n) {
		if (n <= 0)
			return 0;
		return (n % 10) + sumDigits(n / 10);
	}

	/**
	 * 
	 * Given a non-negative int n, return the count of the occurrences of 7 as a
	 * digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10
	 * yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes
	 * the rightmost digit (126 / 10 is 12).
	 * 
	 * 
	 * count7(717) â†’ 2 count7(7) â†’ 1 count7(123) â†’ 0
	 * 
	 * @param n
	 * @return
	 */
	public int count7(int n) {
		if (n <= 0)
			return 0;
		return (n % 10 == 7 ? 1 : 0) + count7(n / 10);
	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) the number of lowercase 'x'
	 * chars in the string.
	 * 
	 * 
	 * countX("xxhixx") â†’ 4 countX("xhixhix") â†’ 3 countX("hi") â†’ 0
	 */
	public int countX(String str) {
		return countXUtil(str, 0);
	}

	private int countXUtil(String str, int i) {
		if (i >= str.length())
			return 0;
		return (str.charAt(i) == 'x' ? 1 : 0) + (countXUtil(str, i + 1));
	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) the number of times lowercase
	 * "hi" appears in the string.
	 * 
	 * 
	 * countHi("xxhixx") â†’ 1 countHi("xhixhix") â†’ 2 countHi("hi") â†’ 1
	 */
	public int countHi(String str) {
		return countHiUtil(str, 0);
	}

	private int countHiUtil(String str, int i) {
		if (i >= str.length() - 1)
			return 0;
		return (str.substring(i, i + 2).equalsIgnoreCase("hi") ? 1 : 0) + countHiUtil(str, i + 1);
	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) a new string where all the
	 * lowercase 'x' chars have been changed to 'y' chars.
	 * 
	 * 
	 * changeXY("codex") â†’ "codey" changeXY("xxhixx") â†’ "yyhiyy"
	 * changeXY("xhixhix") â†’ "yhiyhiy"
	 */
	public String changeXY(String str) {
		StringBuilder sb = new StringBuilder();
		changeXY(str, sb, 0);
		return sb.toString();
	}

	private void changeXY(String str, StringBuilder sb, int i) {
		if (i >= str.length())
			return;
		if (str.charAt(i) == 'X')
			sb.append('Y');
		else
			sb.append(str.charAt(i));
		changeXY(str, sb, i + 1);
	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) a new string where all
	 * appearances of "pi" have been replaced by "3.14".
	 * 
	 * 
	 * changePi("xpix") â†’ "x3.14x" changePi("pipi") â†’ "3.143.14" changePi("pip")
	 * â†’ "3.14p"
	 */
	public String changePi(String str) {
		if (str.length() < 2)
			return str;
		StringBuilder sb = new StringBuilder();
		changePiUtil(str, sb, 0);
		if (!str.substring(str.length() - 2).equalsIgnoreCase("pi"))
			sb.append(str.substring(str.length() - 1));
		return sb.toString();
	}

	private void changePiUtil(String str, StringBuilder sb, int i) {
		if (i >= str.length() - 1)
			return;
		if (str.substring(i, i + 2).equalsIgnoreCase("pi")) {
			sb.append("3.14");
			i++;
		} else
			sb.append(str.charAt(i));

		changePiUtil(str, sb, i + 1);
	}

	/**
	 * Given a string, compute recursively a new string where all the 'x' chars have
	 * been removed.
	 * 
	 * 
	 * noX("xaxb") â†’ "ab" noX("abc") â†’ "abc" noX("xx") â†’ ""
	 * 
	 */
	public String noX(String str) {
		StringBuilder sb = new StringBuilder();
		noX(str, sb, 0);
		return sb.toString();
	}

	private void noX(String str, StringBuilder sb, int i) {
		if (i >= str.length())
			return;
		if (!(str.charAt(i) == 'x'))
			sb.append(str.charAt(i));
		noX(str, sb, i + 1);
	}

	/**
	 * 
	 * Given an array of ints, compute recursively if the array contains a 6. We'll
	 * use the convention of considering only the part of the array that begins at
	 * the given index. In this way, a recursive call can pass index+1 to move down
	 * the array. The initial call will pass in index as 0.
	 * 
	 * 
	 * array6([1, 6, 4], 0) â†’ true array6([1, 4], 0) â†’ false array6([6], 0) â†’
	 * true
	 */

	public boolean array6(int[] nums, int index) {
		if (index >= nums.length)
			return false;
		if (nums[index] == 6)
			return true;
		return array6(nums, index + 1);
	}

	public int array11(int[] nums, int index) {
		if (index >= nums.length)
			return 0;

		return ((nums[index] == 11) ? 1 : 0) + array11(nums, index + 1);
	}

	/**
	 * Given an array of ints, compute recursively if the array contains somewhere a
	 * value followed in the array by that value times 10. We'll use the convention
	 * of considering only the part of the array that begins at the given index. In
	 * this way, a recursive call can pass index+1 to move down the array. The
	 * initial call will pass in index as 0.
	 * 
	 * 
	 * array220([1, 2, 20], 0) â†’ true array220([3, 30], 0) â†’ true array220([3],
	 * 0) â†’ false
	 * 
	 */
	public boolean array220(int[] nums, int index) {
		if (nums.length <= 1)
			return false;
		if (index + 1 > nums.length - 1)
			return false;
		if (nums[index] * 10 == nums[index + 1])
			return true;
		return array220(nums, index + 1);
	}

	public String allStar(String str) {
		if (str == null || str.isEmpty())
			return str;
		StringBuilder sb = new StringBuilder();
		allStar(str, sb, 0);
		return sb.toString().substring(0, sb.length() - 1);
	}

	private void allStar(String str, StringBuilder sb, int i) {
		if (i >= str.length())
			return;
		sb.append(str.charAt(i));
		sb.append("*");
		allStar(str, sb, i + 1);
	}

	/**
	 * 
	 * Given a string, compute recursively a new string where identical chars that
	 * are adjacent in the original string are separated from each other by a "*".
	 * 
	 * 
	 * pairStar("hello") â†’ "hel*lo" pairStar("xxyy") â†’ "x*xy*y" pairStar("aaaa")
	 * â†’ "a*a*a*a"
	 * 
	 */
	public String pairStar(String str) {
		if (str == null || str.isEmpty())
			return str;
		StringBuilder sb = new StringBuilder();
		pairStar(str, sb, 0);
		return sb.append(str.charAt(str.length() - 1)).toString();
	}

	private void pairStar(String str, StringBuilder sb, int i) {
		if (i > str.length() - 2)
			return;
		if (str.charAt(i) == str.charAt(i + 1)) {
			sb.append(str.charAt(i)).append("*");
		} else {
			sb.append(str.charAt(i));
		}
		pairStar(str, sb, i + 1);
	}

	/**
	 * We'll say that a "pair" in a string is two instances of a char separated by a
	 * char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3
	 * pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the
	 * given string.
	 * 
	 * 
	 * countPairs("axa") → 1 countPairs("axax") → 2 countPairs("axbx") → 1
	 */
	public int countPairs(String str) {
		if (str == null || str.isEmpty())
			return 0;
		return countPairs(str, 0);
	}

	private int countPairs(String str, int i) {
		if (i >= str.length() - 2)
			return 0;
		return ((str.charAt(i) == str.charAt(i + 2) ? 1 : 0)) + countPairs(str, i + 1);
	}

	/**
	 * 
	 * Count recursively the total number of "abc" and "aba" substrings that appear
	 * in the given string.
	 * 
	 * 
	 * countAbc("abc") → 1 countAbc("abcxxabc") → 2 countAbc("abaxxaba") → 2
	 */
	public int countAbc(String str) {
		return countAbc(str, 0);
	}

	private int countAbc(String str, int i) {
		if (str == null || str.isEmpty() || str.length() < 3)
			return 0;
		if (i >= str.length() - 2)
			return 0;
		int val = 0;
		if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'b'
				&& (str.charAt(i + 2) == 'a' || str.charAt(i + 2) == 'c')) {
			val = 1;
		}

		return val + countAbc(str, i + 1);
	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) the number of "11" substrings
	 * in the string. The "11" substrings should not overlap.
	 * 
	 * 
	 * count11("11abc11") → 2 count11("abc11x11x11") → 3 count11("111") → 1
	 * 
	 */
	public int count11(String str) {
		if (str == null || str.isEmpty())
			return 0;
		return count11(str, 0);
	}

	private int count11(String str, int i) {
		if (i >= str.length() - 1)
			return 0;
		boolean jump = false;
		if (str.charAt(i) == '1' || str.charAt(i + 1) == '1') {
			jump = true;
		}
		return (jump ? 1 : 0) + count11(str, (jump ? i + 2 : i + 1));
	}

	/**
	 * 
	 * Given a string, return recursively a "cleaned" string where adjacent chars
	 * that are the same have been reduced to a single char. So "yyzzza" yields
	 * "yza".
	 * 
	 * 
	 * stringClean("yyzzza") → "yza" stringClean("abbbcdd") → "abcd"
	 * stringClean("Hello") → "Helo"
	 */
	public String stringClean(String str) {
		StringBuilder sb = new StringBuilder();
		stringClean(str, sb, 0);
		sb.append(str.charAt(str.length() - 1));
		return sb.toString();
	}

	private void stringClean(String str, StringBuilder sb, int i) {
		if (i >= str.length() - 1) {
			return;
		}
		if (str.charAt(i) != str.charAt(i + 1))
			sb.append(str.charAt(i));
		stringClean(str, sb, i + 1);
	}

	public static void main(String[] args) {
		Recursion1 f = new Recursion1();
		System.out.println(f.bunnyEars2(1));
		System.out.println(f.triangle(2));
		System.out.println(f.sumDigits(126));
		System.out.println(f.countX("hi"));
		System.out.println(f.countHi("xxhixx"));
		System.out.println(f.changePi("xpix"));
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(f.array220(nums, 0));

		System.out.println(f.pairStar("aaab"));
		System.out.println(f.countPairs("axax"));
		System.out.println(f.countAbc("abaxxaba"));
		System.out.println(f.count11("1Hello1"));
		System.out.println(f.stringClean("abbbcdd"));
	}

}
